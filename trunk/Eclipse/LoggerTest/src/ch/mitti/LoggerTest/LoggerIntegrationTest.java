package ch.mitti.LoggerTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.mitti.logger.DateFormater;
import ch.mitti.logger.DateGenerator;
import ch.mitti.logger.Logger;

public class LoggerIntegrationTest {


	@Test
	public void Logger_log_lognow() {
		//arrange
		Logger sut = new Logger(new DateGenerator(), new DateFormater());
		//act
		sut.log();
		//assert
	}

}
