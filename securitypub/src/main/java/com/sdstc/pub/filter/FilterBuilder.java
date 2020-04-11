package com.sdstc.pub.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sdstc.pub.dto.ResultDto;

/**
 * Filter 构建者--只支持单过滤器
 * 
 * @author cheng
 *
 */
public class FilterBuilder {

	public List<Filter> filters = new ArrayList<Filter>();

	ApplicationContext applicationContext;

	public FilterBuilder(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * 新增过滤器
	 * 
	 * @param matcher
	 * @param checkerBeanName
	 * @param failureHanderBeanName
	 */
	public void addFilter(AntPathRequestMatcher matcher, String checkerBeanName, String failureHanderBeanName) {
		filters.add(new Filter(matcher, checkerBeanName, failureHanderBeanName));
	}

	/**
	 * 核查处理
	 * 
	 * @param request
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public boolean checkReq(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Filter> filters = this.matcherReq(request);
		boolean pass = true;
		if (filters != null && filters.size() > 1) {
            for(Filter filter:filters) {
            	//调用过滤器执行
            	CheckerFilter checkerFilter = applicationContext.getBean(filter.getCheckerBeanName(), CheckerFilter.class);
    			ResultDto result = checkerFilter.doFilter(request);
    			if(result.getResult()==ResultDto.FAILE) {
    				//结果处理
    				FailureHandler failtureHandler = applicationContext.getBean(filter.getFailureHanderBeanName(), FailureHandler.class);
    				failtureHandler.doResult(request, response, result);
    				pass = false;
    				break;
    			}
            }
		}
		return pass;
	}

	/**
	 * 返回匹配的Filter
	 * 
	 * @param request
	 * @return
	 */
	public List<Filter> matcherReq(HttpServletRequest request) {
        return this.filters.stream().filter(filter->{
        	return filter.getMatcher().matches(request);
        }).collect(Collectors.toList());
	}
}
