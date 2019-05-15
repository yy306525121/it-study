package cn.codeyang.java.proxy;

import cn.codeyang.java.service.impl.HelloConcrete;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yangzhongyang
 */
public class CglibProxyTest {

	@Test
	public void proxy() {
		HelloConcrete instance = (HelloConcrete) CglibProxy.getInstance(HelloConcrete.class);

		String sayResult = instance.sayHello("yangzhongyang");
		System.out.println(sayResult);
	}
}
