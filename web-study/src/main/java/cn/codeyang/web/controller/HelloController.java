package cn.codeyang.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzhongyang
 */
@RestController
public class HelloController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello(String name){
		return "hello " + name;
	}

}
