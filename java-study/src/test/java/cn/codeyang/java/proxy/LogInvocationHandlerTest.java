package cn.codeyang.java.proxy;

import cn.codeyang.java.service.HelloService;
import cn.codeyang.java.service.impl.HelloServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author yangzhongyang
 */
public class LogInvocationHandlerTest {

	@Test
	public void invoke() {
		HelloService helloService = (HelloService) Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class<?>[]{HelloService.class},
				new LogInvocationHandler(new HelloServiceImpl()));
		String aaaa = helloService.sayHello("aaaa");
		System.out.println(aaaa);
	}

}
