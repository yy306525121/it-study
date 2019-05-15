# Filter的使用

```java
@Component
@WebFilter(urlPatterns = "/*")
@Slf4j
public class TimeFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		StringBuffer url = ((HttpServletRequest) servletRequest).getRequestURL();
		log.info("filter start url: {}", url.toString());

		long start = System.currentTimeMillis();
		filterChain.doFilter(servletRequest, servletResponse);
		log.info("speed {} 毫秒", System.currentTimeMillis() - start);
		log.info("filter finish");
	}
}
```

如果想让Filter生效有两种方法
* 添加@Component注解和WebFilter注解声明对哪些url生效
*
```java
@Bean
public FilterRegistrationBean filterRegistration(){
    FilterRegistrationBean registration = new FilterRegistrationBean();
    TimeFilter timeFilter = new TimeFilter();
    registration.setFilter(timeFilter);

    ArrayList<String> urls = new ArrayList<>();
    urls.add("/*");
    registration.setUrlPatterns(urls);

    return registration;
}
```


# Interceptor 的使用
1: 新建一个类实现HandlerInterceptor
```java
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
```

2: 新建一个配置类 实现WebMvcConfigurer， 同时重写addInterceptors方法
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TimeInterceptor()).addPathPatterns("/**");
	}
}

```
