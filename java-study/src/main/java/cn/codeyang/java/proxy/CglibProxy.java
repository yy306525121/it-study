package cn.codeyang.java.proxy;

import cn.codeyang.java.service.impl.HelloConcrete;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yangzhongyang
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {

	static CglibProxy callback = new CglibProxy();

	private CglibProxy() {
	}

	public static Object getInstance(Class clazz) {
		try {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(clazz);
			enhancer.setCallback(callback);

			return enhancer.create();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		log.info("You said: " + Arrays.toString(args));
		return proxy.invokeSuper(obj, args);
	}
}
