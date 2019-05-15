package cn.codeyang.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*")
@Slf4j
public class TimeFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("filter init...");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.info("filter doFilter...");
		StringBuffer url = ((HttpServletRequest) servletRequest).getRequestURL();
		log.info("filter url: {}...", url.toString());

		long start = System.currentTimeMillis();
		filterChain.doFilter(servletRequest, servletResponse);
		log.info("filter speed {} 毫秒...", System.currentTimeMillis() - start);
		log.info("filter finish...");
	}



}
