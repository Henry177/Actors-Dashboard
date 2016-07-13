package bbd.dashboard;

import java.net.NetworkInterface;
import java.net.SocketException;

public class DashboardUtils {

	public static void log(Object logMessage) {
		System.out.println(logMessage);
	}
	
	public static String getIPandPort() {
		try {
			NetworkInterface tmp = NetworkInterface.getNetworkInterfaces().nextElement();
			return "http://" + tmp.getInetAddresses().nextElement().toString().substring(1) + ":8080/";
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return "";
	}
}
