package com.sdstc.pub.filter;

import javax.servlet.http.HttpServletRequest;

import com.sdstc.pub.dto.ResultDto;

/**
   * 过滤器执行检查接口
 * @author cheng
 *
 */
public interface CheckerFilter {
    ResultDto doFilter(HttpServletRequest request);
}
