package uebung1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrentDate {
	private IDate dateGenerator;

	public CurrentDate(IDate dateGenerator){
		this.dateGenerator=dateGenerator;
	}
	
	public String getCurrentDate(){
		LocalDate date = dateGenerator.getCurrentDate();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return dateTimeFormatter.format(date);
	}
}
