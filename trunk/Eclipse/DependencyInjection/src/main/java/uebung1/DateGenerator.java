package uebung1;

import java.time.LocalDate;

public class DateGenerator implements IDate{

	public LocalDate getCurrentDate() {
		LocalDate date = LocalDate.now();
		return date;
	}

}
