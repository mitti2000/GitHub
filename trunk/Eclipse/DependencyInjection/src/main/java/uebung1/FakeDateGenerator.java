package uebung1;

import java.time.LocalDate;

public class FakeDateGenerator implements IDate{

	public LocalDate getCurrentDate() {
		LocalDate date = LocalDate.of(1990, 1, 1);
		return date;
	}

}