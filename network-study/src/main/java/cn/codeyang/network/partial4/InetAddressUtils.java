package cn.codeyang.network.partial4;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yangzhongyang
 */
@Slf4j
public class InetAddressUtils {

	public static InetAddress getIp(String host) throws UnknownHostException {
		return InetAddress.getByName(host);
	}

	public static InetAddress getHost(String ip) throws UnknownHostException {
		return InetAddress.getByName(ip);
	}
}
