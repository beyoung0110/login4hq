package com.login4hq.action.account;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LoginFilter implements Filter {

	final static Logger logger = Logger.getLogger(LoginFilter.class);
	
	//failPage和excludeURIs,从配置文件中读取
	private String failPage = null;
	private HashSet<String> excludeURIs = new HashSet<String>();
	
	public void destroy() {
		failPage = null;
		excludeURIs = null;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		/*if ( excludeURIs.contains(req.getRequestURI()) || checkPermission(req, (HttpServletResponse)response) ) {
			chain.doFilter(request, response);
		} */
		if ( excludeURIs.contains(req.getRequestURI()) || checkPermission(req, (HttpServletResponse)response) ) {
			chain.doFilter(request, response);
		} else {
			logger.info("In PermissionFilter， 跳转authentation登录...");
			try {
				String message = java.net.URLEncoder.encode("请登录","utf-8");
				res.sendRedirect( failPage + "?message="+message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void init(FilterConfig config) throws ServletException {
		String contextPath = config.getServletContext().getContextPath();

		failPage = contextPath + config.getInitParameter("failPage");
		String excludeURIString = config.getInitParameter("excludeURIs");
		StringBuilder uris = new StringBuilder();
		if (excludeURIString != null && !excludeURIString.trim().equals("")) {
			excludeURIString = excludeURIString.replaceAll("[\t\n]", "");
			for (String uri : excludeURIString.split(";")) {
				uri = contextPath + uri.trim();
				excludeURIs.add(uri.trim());
				uris.append(uri);
				uris.append(';');
			}
			if (uris.length() > 0) {
				uris.deleteCharAt(uris.length() - 1);
			}		
		}
		
		logger.debug(config.getFilterName() + " Set context path as:" + contextPath);
		logger.info(config.getFilterName() + " Set fail page :" + failPage);
		logger.info(config.getFilterName() + "Set permission check exlude uris:" + uris);	
	}
	
	/**
	 * 检查权限
	 * @param request
	 * @param response
	 * @return
	 */
	protected boolean checkPermission(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("In the loginfilter, the request url is " + request.getRequestURI());
		HttpSession session = request.getSession();
		if( null == session.getAttribute("user") || !((String)session.getAttribute("user")).equals("admin")){
			return false;
		}
		return true;
	}
}

