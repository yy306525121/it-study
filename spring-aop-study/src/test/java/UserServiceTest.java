import cn.codeyang.aop.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author akafra
 */
public class UserServiceTest {
	@Test
	public void test01(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService userService = (UserService) context.getBean("userServiceImpl");
		userService.add();
	}
}
