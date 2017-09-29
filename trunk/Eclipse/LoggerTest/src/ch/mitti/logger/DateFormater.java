package ch.mitti.logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormater {
	DateGenerator dateGenerator;
	
	public DateFormater(){
		dateGenerator = new DateGenerator();
	}
	
	public String formatDate(LocalDate date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return date.format(formatter);
	}
}
