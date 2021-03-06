package ch.mitti.trees;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TreeTestJunit extends TestCase {
	
	private TreeImplwork baum;
	
	public  TreeTestJunit()
	{
		
	}
	@Before
	public void setUp()
	{
		baum = new TreeImplwork();
		baum.insert(new Element(10,"Bern"));
		baum.insert(new Element(2,"Z�rich"));
		baum.insert(new Element(17,"Basel"));
		baum.insert(new Element(19,"Genf"));
		baum.insert(new Element(12,"Chur"));
		baum.insert(new Element(4,"Luzern"));
	}
		
	@Test
	public void testCreate()
	{
		System.out.println("-------CREATE TREE---------");
		baum.show();
	}
	
	@Test
	public void testSearch()
	{
		assertEquals(null,baum.search(77));
		assertEquals("Bern",(baum.search(10)).getName());
		assertEquals("Chur",(baum.search(12)).getName());
		
	}
	
	@Test
	public void testInsert()
	{
		assertEquals(null,baum.search(77));
		assertEquals("Bern",(baum.search(10)).getName());
		assertEquals("Chur",(baum.search(12)).getName());
		assertTrue(baum.insert(new Element(3,"Wil")));
		assertEquals(3,(baum.search(3)).getId());
	
		
	}
	
	@Test
	public void testAVLInsert()
	{
		assertEquals(null,baum.search(77));
		assertEquals("Bern",(baum.search(10)).getName());
		assertEquals("Chur",(baum.search(12)).getName());
		assertTrue(baum.insert(new Element(3,"Wil")));
		assertEquals(3,(baum.search(3)).getId());
	
		
	}
	
	@Test
	public void testdelete()
	{
		//Blatt l�schen
		baum.delete(4);
		assertEquals(null,baum.search(4));
		
		// Knoten mit 2 Nachfolger l�schen
		baum.delete(17);
		assertEquals(null,baum.search(17));
		assertEquals("Chur",baum.search(12).getName());
		
		//Knoten mit einem Nachfolger l�schen
		baum.delete(19);
		assertEquals(null,baum.search(19));
		//Wurzel l�schen
		
		baum.delete(10);
		assertEquals(null,baum.search(10));
		assertEquals("Z�rich",baum.search(2).getName());
		
		System.out.println("-------LOESCHEN---------"); 
		baum.show();
		
	}
	
	@Test
	public void testHeight()
	{
		assertEquals(3,baum.height());
		
	}
	
	@Test
	public void testSearch2()
	{
		assertEquals(null,baum.search2(77));
		assertEquals("Bern",(baum.search2(10)).getName());
		assertEquals("Chur",(baum.search2(12)).getName());
		
	}
	/*
	@Test
	public void testAnzahl()
	{
		assertEquals(6,baum.anzKnt());
		
		
	}*/
	
	@Test
	public void testLaenge(){
		assertEquals((14.0/6.0),(baum.length()));
	}
}
