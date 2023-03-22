
public class Sort {

	/*
	 * Q4
	 */
	public static void sort(int[] arr){	
		PriorityQueue pq = new PriorityQueue(arr.length);
		
		//Populates Priority Queue with Array elements
		for(int count=0; count<arr.length; count++) {
			pq.insert(arr[count]);
		}
		
		//Replaces element at count index in Array with minimum value in Priority Queue in place; Sorting the Array
		for(int count=0; count<arr.length; count++) {
			arr[count] = pq.removeMin();
		}
	}
	
	public static void main(String[] args){
		int[] arr = {53,3,5,2,4,67};
		Sort.sort(arr);
		// should be printed in order
		System.out.println(arr[0]);
		System.out.println(arr[1]);	
		System.out.println(arr[2]);
		System.out.println(arr[3]);	
		System.out.println(arr[4]);	
		System.out.println(arr[5]);	
	}
	
}
