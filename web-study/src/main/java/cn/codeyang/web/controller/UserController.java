package cn.codeyang.web.controller;

import cn.codeyang.web.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akafra
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("")
	public String home(){
		return "user/index";
	}

	@RequestMapping("/list")
	public List<User> list(){
		ArrayList<User> userList = new ArrayList<>();
		userList.add(new User(1L, "张三"));
		userList.add(new User(2L, "李四"));
		return userList;
	}
}
