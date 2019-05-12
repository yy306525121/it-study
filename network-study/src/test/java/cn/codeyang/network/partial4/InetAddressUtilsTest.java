package cn.codeyang.network.partial4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.Assert.*;

/**
 * @author yangzhongyang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class InetAddressUtilsTest {

	@Test
	public void getIp() throws UnknownHostException {
		InetAddress address = InetAddressUtils.getIp("www.baidu.com");
		log.info(address.toString());
	}

	@Test
	public void getHost() throws UnknownHostException {
		InetAddress host = InetAddressUtils.getHost("61.135.169.125");
		log.info(host.getCanonicalHostName());
	}
}
