public class Reverse {

	// Part 2
	public static void reverse(String[] arr){
		Stack arr_stack = new Stack(); //Create a stack for arr
		
		for (int i = 0; i < arr.length; i++) {
			arr_stack.push(arr[i]);
		} //Populate arr_stack
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (arr_stack.pop()).toString();
		} //Re-populate arr with values reversed
	
	}
	
}
