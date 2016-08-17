package bbd.dashboard;

public class Log {

	public static boolean infoEnabled;
	public static boolean errorEnabled;
	public static boolean logToFile = false;
	
	public static void info(Object info) {
		if(infoEnabled) {
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			if(stackTraceElements.length > 2) {
				String message = "<info> ";
				StackTraceElement s = stackTraceElements[2];
				message += s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1) + " :: " ;
				message += s.getMethodName() + " :: ";
				message += info;
				message = message.replace("<init>", "Constructor");
				log(message);
			}
		}
	}
	
	public static void error(Object error) {
		if(errorEnabled) {			
			if(error instanceof Throwable) {
				((Throwable)error).printStackTrace();
			} else {
				StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
				if(stackTraceElements.length > 2) {
					String message = "<error> ";
					StackTraceElement s = stackTraceElements[2];
					message += s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1) + " :: " ;
					message += s.getMethodName() + " :: ";
					message += error;
					message = message.replace("<init>", "Constructor");
					log(message);
				}
			}			
		}
	}
	
	private static void log(String message) {
		if(!logToFile)
			System.out.println(message);
	}
}
