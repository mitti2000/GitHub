package ch.mitti.testing;

public class extend extends abstaction {
	public void getHelp(){
		System.out.println("Help!");
	}
	
	public static void main(String[] args){
		extend extend = new extend();
		extend.getHelp();
	}
}
