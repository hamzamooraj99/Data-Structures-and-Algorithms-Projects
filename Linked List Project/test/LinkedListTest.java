import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {

	LinkedList l;
	
	@Before
	public void setup(){
		l = new LinkedList();
	}
	/*
	 * Part 1: implement these methods
	 */
	@Test
	public void testSizeEmpty() {
		assertTrue(l.size() == 0);
		// test l.size() for an empty linked list
	}

	@Test
	public void testSizeMany() {
		l.addAtTail(45);
		l.addAtTail(10);
		l.addAtHead(36);
		l.addAtHead(65);
		assertTrue(l.size() == 4);
		// test l.size() after adding some numbers to the linked list
	}
	
	@Test
	public void testSizeTwice() {
		l.addAtTail(10);
		assertTrue(l.size() == 1);
		l.addAtHead(36);
		l.addAtHead(65);
		assertTrue(l.size() == 3);
		// test l.size() twice after adding some numbers to the linked list
	}

	@Test
	public void testTotalEmpty() {
		assertEquals(0, l.total());
		// test l.total() for an empty linked list
	}

	@Test
	public void testTotalMany() {
		l.addAtTail(45);
		l.addAtTail(10);
		l.addAtHead(36);
		l.addAtHead(65);
		assertEquals(156 , l.total());
		// test l.total() after adding some numbers to the linked list
	}
	
	@Test
	public void testTotalTwice() {
		l.addAtTail(10);
		assertEquals(10 , l.total());
		l.addAtHead(36);
		l.addAtHead(65);
		assertEquals(111 , l.total());
		// test l.total() twice after adding some numbers to the linked list
	}
	
	/*
	 * Optional part
	 */
	
//	@Test
//	public void testReverse() {
//		l.addAtHead(5);
//		l.addAtHead(2);
//		l.addAtHead(10);
//		l.reverse();
//		assertEquals(5, l.removeAtHead());
//		assertEquals(2, l.removeAtHead());	
//		assertEquals(10, l.removeAtHead());	
//	}

}
