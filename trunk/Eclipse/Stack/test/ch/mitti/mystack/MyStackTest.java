package ch.mitti.mystack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyStackTest {
	private MyStack ms;

	@Before
	public void setUp() throws Exception {
		ms = new MyStack();
	}

	@Ignore
	public void test() {
		//MyStack ms = new MyStack();
	}
	
	@Test
	public void testArray(){
		Integer[] e = new Integer[0];
		assertArrayEquals(e, ms.getE());
	}
	
	@Test
	public void testPush(){
		Integer e = new Integer(25);
		assertTrue(ms.push(e));
	}
	
	@Test
	public void testPushNull(){
		Integer e = null;
		assertFalse(ms.push(e));
	}
	
	@Test public void testPop(){
		ms.push(new Integer(10));
		ms.push(new Integer(100));
		assertTrue(ms.pop().equals(new Integer(100)));
	}

}
