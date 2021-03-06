package ch.mitti.MathListTests;

import ch.mitti.MathLight.MathOperations;

public class MathOperationTest {
	
	int a = 0;
	int b = 0;
	MathOperations mathLight;
	int testsDone = 0;
	int testsGood = 0;
	
	public MathOperationTest(){
		mathLight = new MathOperations();
	}
	
	public int getTestsDone(){
		return testsDone;
	}
	
	public int getTestsGood(){
		return testsGood;
	}
	
	public static void main(String[] args){
		MathOperationTest mathTest = new MathOperationTest();
		
		mathTest.testAddition(5, 4, 9);
		mathTest.testSubtraktion(5, 3, 2);
		mathTest.testMultiplikation(8, 3, 24);
		mathTest.testDivision(21, 7, 3);
		mathTest.testDivision(21, 0, 1);
		
		System.out.println("Tests Done: " + mathTest.getTestsDone());
		System.out.println("Tests Good: " + mathTest.getTestsGood());
	}
	
	
	private boolean testAddition(int a, int b, int soll){
		int r = mathLight.addiere(a, b);
		testsDone++;
		if(r == soll) {
			testsGood++;
			return true;
		}
		else return false;
	}
	
	private boolean testSubtraktion(int a, int b, int soll){
		int r = mathLight.subtrahiere(a, b);
		testsDone++;
		if(r == soll) {
			testsGood++;
			return true;
		}
		else return false;
	}
	
	private boolean testMultiplikation(int a, int b, int soll){
		int r = mathLight.multipliziere(a, b);
		testsDone++;
		if(r == soll) {
			testsGood++;
			return true;
		}
		else return false;
	}
	
	private boolean testDivision(int a, int b, double soll){
		try{
			double r = mathLight.dividiere(a, b);
			testsDone++;
			if(r == soll) {
				testsGood++;
				return true;
			}
		} catch (IllegalArgumentException e){
			return false;
		}
		return true;
		
	}
}
