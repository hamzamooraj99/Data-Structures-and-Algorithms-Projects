import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {

	/** Insertion sort of an array
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/**
	 * Q3 - Bubble Sort on Array
	 * @param arr the array to be sorted in-place
	 * 
	 * Time Complexity - O(n^2)
	 * 		FOR(inner) Loop does O(n) work on each iteration
	 * 		WHILE(outer) Loop runs for O(n) iterations
	 * 		Therefore complexity of O(n^2)
	 */
	public static void bubbleSort(int[] arr) {
		boolean swaps = true; //Flag for when no swaps occur (for when arr is sorted)
		int arrLength = arr.length;
		int temp = 0;
		
		while(swaps) {
			swaps = false;
			
			//Below block compares two adjacent values and swaps them if the first is larger than the second.
			for(int i = 0; i < arrLength - 1; i++) {
				if(arr[i] > arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i+1] = temp;
					//Flag is set to true as a swap did occur
					swaps = true;
				}
			}
		}
	}

	/**
	 * Q5
	 * @param S - Array List to be sorted
	 * @return - Sorted Array List
	 * 
	 * Time Complexity - O(N logN)
	 * 		Each "level" of the implementation is O(n)
	 * 		The number of "levels" is however many times n can be iteratively divided by 2, which is O(log n)
	 * 		Thus time complexity of O(N logN)
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {
		if(S.size() <= 1) {//BASE CASE - Division Phase has reached limit and is ready for Conquer Phase
			return S;
		}
		
		ArrayList<Integer> sortedS = new ArrayList<Integer>();
		ArrayList<Integer> L = new ArrayList<Integer>(); //Array List for 'lesser than pivot' values
		ArrayList<Integer> E = new ArrayList<Integer>(); //Array List for 'equal to pivot' values
		ArrayList<Integer> G = new ArrayList<Integer>(); //Array List for 'greater than pivot' values
		int pivot = S.get(0);
		
		//Loop is Division Phase - Runs through Array List and compares values to pivot and sorts them in according Array lists
		for(int count = 0; count < S.size(); count++) { 
			
			if(S.get(count) < pivot)
				L.add(S.get(count));
			
			else if(S.get(count) == pivot) 
				E.add(S.get(count));
				
			else
				G.add(S.get(count));
		}
		
		//Array List variables used for Conquer Phase - Stores sorted Array List of values in L and G respectively
		ArrayList<Integer> sortedL = quickSort(L);
		ArrayList<Integer> sortedG = quickSort(G);
				
		sortedS.addAll(sortedL); sortedS.addAll(E); sortedS.addAll(sortedG); //Combining all separate Array Lists into one sorted Array List
		
		return sortedS;
		
	}

	
	/** predicate to check if array is sorted
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	
	/** predicate to check if arrayList is sorted.
	 *  Useful for checking ArrayList<Integer> lists returned
	 *  from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	
	/** Helper printing methods for testing
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
//		//Testing Bubble Sort
//		int[] arr1 = { 5, 4, 3, 2, 1 };
//		bubbleSort(arr1);
//		printIntArray(arr1);
//		
//		//Testing Insertion Sort
//		int[] arr2 = {10, 7, 1, 4};
//		insertionSort(arr2);
//		printIntArray(arr2);
		
		//Testing Quick Sort
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3.add(3);
		arr3.add(1);
		arr3.add(6);
		arr3.add(5);
		ArrayList<Integer> arr3_sorted = quickSort(arr3);
		printIntArrayList(arr3_sorted);

	}

}
