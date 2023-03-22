import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {

	/*
	 * Q3
	 */
	
	PriorityQueue pq;
	
	@Before
	public void setup(){
		pq = new PriorityQueue(20);
	}
	
	@Test
	public void insertTestMin() {
		// insert a few numbers then test pq.min()
		pq.insert(34);
		pq.insert(45);
		pq.insert(73);
		pq.insert(22);
		assertEquals(22, pq.min());
	}
	
	@Test
	public void insertTestSize() {
		// insert a few numbers then test pq.size()
		pq.insert(34);
		pq.insert(45);
		pq.insert(73);
		pq.insert(22);
		assertEquals(4, pq.size());
	}

	@Test
	public void removeMinTest() {
		// step 1: add a few numbers to pq
		pq.insert(34);
		pq.insert(45);
		pq.insert(73);
		pq.insert(22);
		
		// step 2: call pq.removeMin() a few times to check numbers are returned in ascending order 
		assertEquals(22, pq.removeMin());
		assertEquals(34, pq.removeMin());
		assertEquals(45, pq.removeMin());
		assertEquals(73, pq.removeMin());
	}
	
	
	@Test(expected=PriorityQueueException.class)
	public void removeMinEmptyTest() {
		pq.removeMin();
	}
}	
