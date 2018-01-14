package ch.mitti.chat;

public class LoggerSingleton {
	private static LoggerSingleton loggerSingelton=null;
	private LoggerGui gui;
	
	protected LoggerSingleton(String name) {
		gui = new LoggerGui(name);
	}
	
	public  static synchronized LoggerSingleton getLoggerInstance(String name) {
		if(loggerSingelton == null) {
			loggerSingelton = new LoggerSingleton(name);
		}
		return loggerSingelton;
	}
	
	public void writeLog(String message) {
		gui.addMessage(message);
	}
}
