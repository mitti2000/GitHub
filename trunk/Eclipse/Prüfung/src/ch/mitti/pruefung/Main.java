package ch.mitti.pruefung;

public class Main {
	public static void main(String[] args){
		B b = new B();
		System.out.println(b.message());
		
		A b2 = new B();
		System.out.println((A)b2.message());
	}
}
