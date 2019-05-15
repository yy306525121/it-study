package cn.codeyang.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {
	/**
	 * 拦截之前
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("interceptor preHandle...");
		long start = System.currentTimeMillis();
		request.setAttribute("start_time", start);
		return true;
	}

	/**
	 * 请求处理之后， 视图渲染之前
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info("interceptor postHandle...");
		Long start = (Long) request.getAttribute("start_time");
		log.info("interceptor speed {} 毫秒...", System.currentTimeMillis() - start);
	}


	/**
	 * 请求， 视图渲染全部完成之后
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info("interceptor afterCompletion...");
		Long start = (Long) request.getAttribute("start_time");
		log.info("interceptor speed {} 毫秒...", System.currentTimeMillis() - start);
	}
}
