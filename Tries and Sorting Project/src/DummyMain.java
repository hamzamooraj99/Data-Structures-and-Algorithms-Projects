import java.util.ArrayList;
import java.util.Iterator;

public class DummyMain {
	
	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {

		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> L = new ArrayList<Integer>();
		ArrayList<Integer> E = new ArrayList<Integer>();
		ArrayList<Integer> G = new ArrayList<Integer>();
		
		L.add(2); L.add(3); L.add(4);
		E.add(5);
		G.add(6); G.add(7); G.add(8);
		
		System.out.println("L:"); printIntArrayList(L);
		
		System.out.println("");
		
		System.out.println("E:"); printIntArrayList(E);
		
		System.out.println("");
		
		System.out.println("G:"); printIntArrayList(G);
		
		S.addAll(L); S.addAll(E); S.addAll(G);
		
		System.out.println("");
		
		System.out.println("S:"); printIntArrayList(S);
		
		if(S.get(1) > S.get(0)) {
			System.out.println("FUCK");
		}
		
		
		
		
	}

}
