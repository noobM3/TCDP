package com.hangzhu.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		if( url.contains("index.html") ||url.contains("login.html") ||
				url.contains("register.html") || url.contains("register1.html")||
				url.contains("login.do") || url.contains("getsession.do") || 
				url.contains("register.do") || url.contains("logff.do") ||
				url.contains(".js") || url.contains(".css") || url.contains(".svg")
				|| url.contains(".png") || url.contains(".gif") || url.contains("checkono") ||
				url.contains("index1.html")
				)//不过滤
		{
			chain.doFilter(request, response);
			return;
		}
		else
		{
			if(session.getAttribute("owner") == null || session.getAttribute("owner") == "")//未登录
			{
				((HttpServletResponse)response).sendRedirect("login.html");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 
	}

}
