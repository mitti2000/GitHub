package ch.mitti.listen;

public class TestReadConsole {

	public static void main(String[] args) {
		String test = System.console().readLine();
		
		System.out.println(test);

	}

}
