package cn.codeyang.web;

import cn.codeyang.web.filter.TimeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class WebStudyApplication {


	public static void main(String[] args) {
		SpringApplication.run(WebStudyApplication.class, args);
	}

	//@Bean
	//public FilterRegistrationBean filterRegistration(){
	//	FilterRegistrationBean registration = new FilterRegistrationBean();
	//	TimeFilter timeFilter = new TimeFilter();
	//	registration.setFilter(timeFilter);
	//
	//	ArrayList<String> urls = new ArrayList<>();
	//	urls.add("/*");
	//	registration.setUrlPatterns(urls);
	//
	//	return registration;
	//}

}
