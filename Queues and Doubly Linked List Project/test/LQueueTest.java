import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LQueueTest {

	LQueue q;
	@Before
	public void setup()
	{
		q = new LQueue();
	}
	
	/*
	 * 2: complete the following test methods as specified. 
	 */
	
	@Test
	public void testIsEmpty() {
		// Checks if queue is empty
		assertTrue(q.isEmpty());
		
	}
	
	@Test
	public void testIsEmptyFalse() {
		// Add 23 to queue
		q.enqueue(32);
		// Checks that queue is no longer empty
		assertFalse(q.isEmpty());
	}

	@Test
	public void testSizeEmpty() {
		// Checks size of an empty queue(to be 0)
		assertEquals(0, q.size());
	}
	
	@Test
	public void testSizeNonEmpty() {
		// Adds 23 and then 24 to queue
		q.enqueue(23);
		q.enqueue(24);
		// Checks size increment was done correctly
		assertEquals(2, q.size());
		assertTrue(!q.isEmpty());
		//Remove 23 from queue using dequeue()
		q.dequeue();
		// Checks that size decrement was done correctly
		assertEquals(1, q.size());
	}

	@Test
	public void testEnqueue() {
		// Adds 23 and then 24 to queue
		q.enqueue(23);
		q.enqueue(24);
		// Checks that 23 is at the front
		assertEquals(23, q.front());
	}
	
	@Test
	public void testDequeue() {
		// Adds 23, 24 and then 25 to queue
		q.enqueue(23);
		q.enqueue(24);
		q.enqueue(25);
		// Checks that dequeue returns correct element.
		assertEquals(23, q.dequeue());
		assertEquals(24, q.dequeue());
		assertEquals(25, q.dequeue());
	}
	
	@Test(expected = QueueException.class)  
	public void testEmptyDequeue() {  
		// Checks that exception is thrown when dequeuing an empty queue
		q.dequeue();
	}
	
	@Test(expected = QueueException.class)  
	public void testEmptyFront() {
		// Checks that exception is thrown when returning front of an empty queue
		q.front();
	}
}
