public class LQueue {
	
	private class Node{
		Object element;
		Node next;
		
		public Node(Object e, Node n){
			element = e;
			next = n;
		}
		
		public Node(Object e){
			element = e;
			next = null;
		}
	}
	
	private Node head;
	private Node tail;
	private int size = 0;//Set size to 0 to be incremented when enqueue() is executed
						 //and decremented with dequeue() is executed
	
	public LQueue(){
		head = null;
		tail = null;	
	}
	
	/*
	 * Part 3: complete the following methods
	 */
	
	public boolean isEmpty(){
		if(head == null) { //If head is null, that means it is pointing to nothing,
			return true;   //which means that there are no elements in the queue
		}
		else {
			return false;
		}
	}
	
	
	public int size(){
		return size; //size is set to 0 above
	}				 //size is incremented when enqueue() is executed
					 //size is decremented when dequeue() is executed
	
	
	public void enqueue(Object o){
		Node newNode = new Node(o);
		if(isEmpty()) { //If Queue is empty, then newNode is simply put in the Queue
			head = newNode;
			tail = newNode;
		}
		else { //If Queue is not empty, then some shifting around(within the Queue) is necessary
			tail.next = newNode;
			tail = newNode;
		}
		size++; //Size is incremented to count the number of elements in Queue
	}
	
	
	public Object dequeue() throws QueueException{
		if(isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		else {
			Object temp = head.element; //Store head node object in temp for return
			head = head.next; //Set head to the next node in queue
			size--; //Decrement size
			return temp;
		}//Garbage collection will remove head node
	}
	
	
	public Object front() throws QueueException{
		if(isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		else {
			return head.element; //head is a Node Object, so .element returns value
		}
	}
	
}
