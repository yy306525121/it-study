import cn.codeyang.aop.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test001 {
	@Test
	public void test001(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService userService = (UserService) context.getBean("userServiceImpl");
		userService.add2();
	}
}
