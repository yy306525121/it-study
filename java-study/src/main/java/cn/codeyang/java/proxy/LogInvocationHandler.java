package cn.codeyang.java.proxy;

import cn.codeyang.java.service.HelloService;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * jdk动态代理
 * jdk的动态代理必须要有接口才行
 * @author yangzhongyang
 */
@Slf4j
public class LogInvocationHandler implements InvocationHandler {

	private Object object;

	public LogInvocationHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("sayHello".equals(method.getName())) {
			log.info("你说了: {}", Arrays.asList(args));
		}
		return method.invoke(object, args);
	}
}
