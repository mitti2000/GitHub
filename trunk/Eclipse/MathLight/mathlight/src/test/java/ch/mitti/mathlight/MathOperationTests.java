package ch.mitti.mathlight;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.core.IsNot;
import org.junit.Test;

public class MathOperationTests {
	@Test
	public void addition_addPositives_returnResult(){
		//arrange
		MathOperations sut = new MathOperations();
		
		//act
		int result = sut.addiere(4, 5);
		
		//assert
		assertThat(result, is(9));
	}
	
	@Test
	public void subtraction_subtractPositives_returnResult(){
		//arrange
		MathOperations sut = new MathOperations();
		
		//act
		int result = sut.subtrahiere(5, 3);
		
		//assert
		assertThat(result, is(2));
	}
	
	@Test
	public void multiplication_multiplyPositives_returnResult(){
		//arrange
		MathOperations sut = new MathOperations();
		
		//act
		int result = sut.multipliziere(5, 8);
		
		//assert
		assertThat(result, is(40));
	}
	
	@Test
	public void division_divideByZero_throwsException(){
		//arrange
		MathOperations sut = new MathOperations();
		Boolean result = false;
		
		//act
		try{
			sut.dividiere(5, 0);
		} catch (IllegalArgumentException ex){
			result = true;
		}
		
		//assert
		assertThat(result, is(true));
	}
}	
