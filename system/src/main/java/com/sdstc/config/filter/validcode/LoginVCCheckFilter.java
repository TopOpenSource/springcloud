package com.sdstc.config.filter.validcode;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdstc.pub.dto.ResultDto;
import com.sdstc.pub.filter.CheckerFilter;

import lombok.extern.log4j.Log4j2;

/**
   * 登录验证码过滤器
 * @author cheng
 */
@Component("loginVCCheckFilter")
@Log4j2
public class LoginVCCheckFilter implements CheckerFilter{
    @Autowired
	private SysUserExtService sysUserExtService;
         
	@Override
	public ResultDto doFilter(HttpServletRequest request) {
		log.info("loginvc");
		String account=request.getParameter("account");
		String vcCode=request.getParameter("vcCode");
		
		if(this.needFilter(account)) {
			if(this.check(account, vcCode)) {
				return new ResultDto(ResultDto.SUCCESS, null);
			}else {
				return new ResultDto(ResultDto.FAILE, "验证码不正确！");
			}
		}else {
			return new ResultDto(ResultDto.SUCCESS, null);
		}
	}

	/**
	 * 判断是否需要验证码验证
	 * 需要验证码的情况
	 * 
	 * 1.首次登录
	 * 2.地址变更
	 * 3.登录失败3次
	 * 4.
	 * @param request
	 * @return
	 */
	private boolean needFilter(String userAccount) {
		
		return true;
	}
	
	/**
	   * 判断验证码是否正确
	 * @param userAccount
	 * @param vcCode
	 * @return
	 */
	private boolean check(String userAccount,String vcCode) {
		
		return true;
	}
}

