public class LSearch {


	private class Node {
		private Entry value;
		private Node nextNode;

		public Node(Entry v) {
			value = v;
			nextNode = null;
		}

		public Entry getValue() {
			return value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}
	}

	// Holds a reference to the head of the list
	private Node headNode;

	public LSearch() {
		headNode = null;
	}

	public void addAtHead(Entry e) {
		Node newNode = new Node(e); 
		newNode.setNextNode(headNode); 
		headNode = newNode; 
	}
	
	/**
	 * Q3
	 * 
	 * @param name - Name to search
	 * @return - Number associated with name
	 * 
	 * Time Complexity = O(n)
	 * 		Due to WHILE Loop traversing through linked list one element at a time, complexity is O(n)
	 * 		Worst Case - Last element in array is value to be found
	 */
	public int linearSearch(String name){
		Node currentNode = headNode; //Node variable to be used for comparison
		
		while(currentNode != null) { //TailNode.getNextNode() is null - Condition will allow for TailNode to be included
			if(currentNode.getValue().getName().equals(name)) {
				return currentNode.getValue().getNumber();
			}
			
			else {
				currentNode = currentNode.getNextNode();
			}
		}
		//If return as not been called after WHILE Loop, then name does not exist in linked list, thus...
		return -1; 
	}
}
