package cn.codeyang.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 使用@Aspect定义一个切面类
 * @Pointcut定义一个切入点, 可以是一个正则表达式, 也可以是一个注解
 *
 *
 * @Before 在切入点开始处切入内容
 * @After 在切入点尾处切入内容
 * @AfterReturning 在切入点return内容之后切入内容
 * @Around 在切入点前后切入内容
 * @AfterThrowing 用来处理当切入内容部分抛出异常之后的处理逻辑
 *
 * @author yangzhongyang
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

	ThreadLocal<Long> startTime = new ThreadLocal<>();

	/**
	 * 切入点
	 */
	@Pointcut("execution(public * cn.codeyang.web.controller..*.*(..))")
	public void webLog() {
	}

	/**
	 * 在切入点开始处切入内容
	 *
	 * @param joinPoint
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint)  throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		log.info("URL: {}", request.getRequestURL());
		log.info("HTTP_METHOD: {}", request.getMethod());
		log.info("IP: {}", request.getRemoteAddr());
		log.info("CLASS_METHOD: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		log.info("ARGS: {}", Arrays.asList(joinPoint.getArgs()));

		//记录接口请求开始时间
		startTime.set(System.currentTimeMillis());
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret){
		log.info("Response: {}", ret);

		log.info("耗时: {}毫秒", System.currentTimeMillis() - startTime.get());

	}



}
