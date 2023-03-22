import java.util.Arrays;

public class DummyMain {
	
	public static void loopRecursive(int[] thisArray) {
		  if (thisArray.length <= 0) {
		    return;
		  }
		  System.out.println(thisArray[0]);
		  loopRecursive(Arrays.copyOfRange(thisArray, 1, thisArray.length));
		}

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7};
		
		loopRecursive(arr);

	}

}
