public class ASearch {


	private Entry[] catalogue;
	private int current;
	
	/*
	 * Assume 10 entries
	 */
	public ASearch(){
		catalogue = new Entry[10];
		current = 0;
	}
	
	/*
	 * Ignores adding if full (should really be handled by exception...)
	 */
	public void addEntry(Entry e){
		if(current < 10){
			catalogue[current++] = e;
		}
	}
	
	/**
	 * Q2
	 * 
	 * @param name - Name to Search
	 * @return - Number associated with name
	 * 
	 * Time Complexity = O(n)
	 * 		Due to FOR loop traversing through array one element at a time, complexity is O(n)
	 * 		Worst Case - Last element in array is value to be found
	 */
	public int linearSearch(String name){
		for(int count = 0; count < current; count++) { //Uses FOR loop to traverse through array
			if(catalogue[count].getName().equals(name)) {//.equals() comparison for Strings - To compare names
				return catalogue[count].getNumber();
			}
			else {
				continue; //If name is not found in current iteration, continue sends program to next iteration
			}
		}
		//If return as not been called after FOR Loop, then name does not exist in array, thus...
		return -1; 
	}

	/**
	 * Q4
	 * 
	 * @param first - 0th element of elements to search - Used to separate base and recursive case
	 * @param last - Last element of elements to search - Used to separate base and recursive case
	 * @param name - Name to search
	 * @return - Number associated with Name
	 * 
	 * Time Complexity - O(log n)
	 * 		Due to lack of loops and recursiveness, and idea of splitting array into two and searching significant half, complexity is O(log n)
	 * 		Worst Case - Value to be found is at either extremity of the array OR is not in the array at all
	 */
	private int binarySearch(int first,int last,String name){
		
		if(first > last) { //BASE CASE - @param name is not in the array
			return -1;
			
		}
		else { //RECURSIVE CASE - @param name is in the array
			int middle = (first+last) / 2; //Find the middle index of the array, so search field can be split into two
			
			//Recording middle element's values to be used for comparison later on
			String middle_name = catalogue[middle].getName();
			int middle_number = catalogue[middle].getNumber();
			
			if(middle_name.equals(name)) //BEST CASE - @param name is found at the middle element
				return middle_number;
			
			//y.compareTo(x) returns a positive integer if y comes after x alphabetically
			else if(middle_name.compareTo(name) > 0) //name comes before middle_name alphabetically
				return binarySearch(first, middle-1, name);
				//Sets last as middle-1 to limit search area into left-most half of array
				//Disregards middle-th as check for that is already done
			
			else //middle_name comes before name alphabetically
				return binarySearch(middle+1, last, name);
				//Sets last as middle+1 to limit search area into right-most half of array
				//Disregards middle-th as check for that is already done
		}
	}

	// helper method exposed to the programmer
	public int binarySearch(String name){
		return binarySearch(0,current-1,name);
	}
	
	
}
