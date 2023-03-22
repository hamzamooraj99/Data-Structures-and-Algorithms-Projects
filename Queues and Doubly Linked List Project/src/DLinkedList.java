public class DLinkedList {

	private class Node {
		private Object value;
		private Node nextNode;
		private Node prevNode;

		public Node(Object v) {
			value = v;
			nextNode = null;
			prevNode = null;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object v) {
			value = v;
		}
		
		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node n) {
			nextNode = n;
		}
		
		public Node getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(Node n) {
			prevNode = n;
		}
	
	}

	// Holds a reference to the head and tail of the list
	private Node headNode;
	private Node tailNode;
	
	public DLinkedList() {
		headNode = null;
		tailNode = null;
	}

////////////// Get Values /////////////////	
	
	public Object getHeadValue(){
		if (headNode == null)
			return null;
		return headNode.value;
	}
	
	
	public Object getTailValue(){
		if (tailNode == null)
			return null;
		return tailNode.value;
	}
	
////////////// Add Values ////////////////	
	
	public void addAtHead(Object o) {
		Node newNode = new Node(o); 
		newNode.setNextNode(headNode); 
		if (headNode != null)
			headNode.setPrevNode(newNode);
		headNode = newNode; 
		// special case for empty list
		if (tailNode == null)
			tailNode = newNode;
	}

	
	public void addAtTail(Object o) {
		Node newNode = new Node(o);
		// this means that headNode == null too!
		if(tailNode == null){
			tailNode = newNode;
			headNode = newNode;
		}else{
			newNode.setPrevNode(tailNode);
			tailNode.setNextNode(newNode);
			tailNode = newNode;
		}
	}
	
///////////// Delete Values ////////////////////		
	
	public Object deleteAtHead() {
		// list is empty 
		if(headNode == null){
			headNode = null;
			tailNode = null;
			return null;
		}
		// singleton: must update tailnode too
		if(headNode == tailNode){
			Object res = headNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}
		Object res = headNode.getValue();
		headNode = headNode.getNextNode();
		headNode.setPrevNode(null);
		return res;
	}

	
	public Object deleteAtTail() {
		// list is empty 
		if(tailNode == null){
			headNode = null;
			tailNode = null;
			return null;
		}
		// singleton: must update tailnode too
		if(headNode == tailNode){
			Object res = tailNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}
		Object res = tailNode.getValue();
		tailNode = tailNode.getPrevNode();
		tailNode.setNextNode(null);
		return res;
	}

	
	/**
	 * @param idx the index position of the value
	 * @return the value in the list at a given index
	 */
	public Object get(int idx) {
		Object value = null;
		int i = 0;
		Node n = headNode;
		while (i <= idx) {
			if (n == null) {
				return -1;
			}
			else {
				value = n.getValue();
				n = n.getNextNode();
				i++;
			}
		}
		return value;
	}

	
	
	// Part 4: complete
	public void reverse(){
		//If list is empty
		if(headNode == null) {
			return;
		}
		
		//If list has one value
		else if(headNode == tailNode) {
			return;
		}
		
		//If list has multiple values
		else {
			Node counter = headNode;
			Node temp; //Temporary node declared in case of need
			while(counter != tailNode) {
				if(counter == headNode) {
					//Makes changes to headNode(to act as a tailNode - still labelled as headNode)
					headNode.prevNode = headNode.nextNode;
					headNode.nextNode = null;
					counter = headNode.getPrevNode();
				}
				
				//Makes changes to rest of the nodes in the list
				else {
					temp = counter.nextNode; //Use case of temp node
					counter.nextNode = counter.prevNode;
					counter.prevNode = temp;
					counter = counter.getPrevNode();
				}
			}
			//Makes changes to tailNode(to act as a headNode - still labelled as tailNode) after while loop, as while loop ends when counter IS tailNode
			tailNode.nextNode = tailNode.prevNode;
			tailNode.prevNode = null;
			//Finally switches label of headNode and tailNode
			temp = headNode; //Use case of temp node
			headNode = tailNode;
			tailNode = temp;
		}
	}	
}


//public void reverse(){
//	//BASE CASE
//	if(counter == tailNode) { 
//		//Makes changes to tailNode(to act as a headNode - still labelled as tailNode)
//		tailNode.nextNode = tailNode.prevNode;
//		tailNode.nextNode = null;
//		//Finally switches label of headNode and tailNode
//		temp = headNode;
//		headNode = tailNode;
//		tailNode = temp;
//	}
//	//RECURSIVE CASE
//	else {
//		if(counter == headNode) {
//			//Makes changes to headNode(to act as a tailNode - still labelled as headNode)
//			headNode.prevNode = headNode.nextNode;
//			headNode.nextNode = null;
//			//Sets counter to next node, then calls reverse()
//			reverse(counter.getNextNode());
//		}
//		//Makes changes to rest of the nodes in the list - Traverses through list recursively
//		else {
//			temp = counter.nextNode;
//			counter.nextNode = counter.prevNode;
//			counter.prevNode = counter.nextNode;
//			reverse(counter.getNextNode());
//		}
//	}
//}

			


