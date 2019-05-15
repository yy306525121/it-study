package cn.codeyang.java.service.impl;

import cn.codeyang.java.service.HelloService;

/**
 * @author yangzhongyang
 */
public class HelloServiceImpl implements HelloService {
	@Override
	public String sayHello(String str) {
		return "HelloImpl " + str;
	}
}
