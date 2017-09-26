package ch.mitti.logger;

public class Logger {
	DateGenerator dateGenerator;
	DateFormater dateFormater;
	
	public Logger(DateGenerator dateGenerator, DateFormater dateFormater){
		this.dateGenerator = dateGenerator;
		this.dateFormater = dateFormater;
	}
	
	public void log(){
		System.out.println(dateFormater.formatDate(dateGenerator.generate()));
	}
	
}
