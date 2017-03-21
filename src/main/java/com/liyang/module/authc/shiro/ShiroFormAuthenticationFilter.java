package com.liyang.module.authc.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;


public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
	
	

	@Override
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mac = DigestUtils.md5Hex(password);
		return new UsernamePasswordToken(username,mac);
	}



	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		issueSuccessRedirect(request, response);
		// we handled the success redirect directly, prevent the chain from
		// continuing:
		System.out.println("login success");
		return false;
	}
	
	

	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		setFailureAttribute(request, e);
		// login failed, let request continue back to the login page:
		
		
		String className = e.getClass().getName(), message = "";
		
		System.out.println("login failed: "+ className);
		
		
		
		if (IncorrectCredentialsException.class.getName().equals(className) ){
			message = "用户或密码错误, 请重试.";
		} else if(UnknownAccountException.class.getName().equals(className)) {
			message = "用户名不存在, 请重试.";
		} else{
			message = "系统出现点问题，请稍后再试！";
		}
		
		request.setAttribute("message", message);
		System.out.println(message);
		return true;
	}

}
