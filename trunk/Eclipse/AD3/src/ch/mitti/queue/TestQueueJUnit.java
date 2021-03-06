package ch.mitti.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestQueueJUnit {


	private Queue myQueue;
	
	
	public TestQueueJUnit()
	{
		super();
		
	}

	@Before
	public void setUp()
	{
		myQueue = new Queue_ImplArray();
// 		myQueue = new Queue_ImplListe();
	}
	
@Test
	public void testEmpty()
	{
		assertEquals(true, myQueue.empty());	
		assertEquals(null, myQueue.deq());
		myQueue.enq(new Element(33,"Genf"));
		assertEquals(false, myQueue.empty());	
	}

@Test
	public void testEnq()
	{
		assertEquals(true, myQueue.enq(new Element(2,"Basel")));	
		assertEquals(true, myQueue.enq(new Element(4,"Wil")));	
		assertEquals(true, myQueue.enq(new Element(27,"Chur")));	
		assertEquals(2, myQueue.deq().getId());	
		assertEquals("Wil", myQueue.deq().getName());	
	}

@Test
	public void testDeq()
	{
		// lesen im leeren Stack
		assertEquals(null,myQueue.deq());
	
		assertEquals(true, myQueue.enq(new Element(2,"Basel")));	
		assertEquals(true, myQueue.enq(new Element(4,"Wil")));	
		assertEquals(true, myQueue.enq(new Element(27,"Chur")));
		assertEquals(2,myQueue.deq().getId());
		assertEquals("Wil",myQueue.deq().getName());
		assertEquals(27,myQueue.deq().getId());
		
		// leerer Stack
		assertEquals(null,myQueue.deq());
	
	}


		
}


