package loggingServiceTest;

import java.io.FileWriter;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito.*;

public class LoggingServiceTest {
	
	@Test
	public void addMessage_withMockedWriter_returnTrue(){
		//Arrage
		FileWriter writer = mock(FileWriter.class);
	}
}
