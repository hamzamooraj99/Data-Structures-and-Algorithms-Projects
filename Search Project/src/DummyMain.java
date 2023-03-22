
public class DummyMain {
	
	public static void testASLinear() {
		ASearch as = new ASearch();
		as.addEntry(new Entry("Andrew",111));
		as.addEntry(new Entry("Ewen",321));
		as.addEntry(new Entry("Peter",123));
		as.addEntry(new Entry("Roger",222));
		
		System.out.println(as.linearSearch("Bob"));
		System.out.println(as.linearSearch("Peter"));
	}
	
	public static void testLSLinear() {
		LSearch ls = new LSearch();
		// doesn't have to be ordered!
		ls.addAtHead(new Entry("Andrew",111));
		ls.addAtHead(new Entry("Ewen",321));
		ls.addAtHead(new Entry("Peter",123));
		ls.addAtHead(new Entry("Roger",222));
		
		System.out.println(ls.linearSearch("Bob"));
		System.out.println(ls.linearSearch("Andrew"));
	}
	
	public static void testASBin() {
		ASearch as = new ASearch();
		as.addEntry(new Entry("Abby", 209));
		as.addEntry(new Entry("Andrew",111));
		as.addEntry(new Entry("Ewen",321));
		as.addEntry(new Entry("Peter",123));
		as.addEntry(new Entry("Roger",222));
		as.addEntry(new Entry("Tanner",345));
		
		System.out.println(as.binarySearch("Bob"));
		System.out.println("");
		System.out.println(as.binarySearch("Andrew"));
		System.out.println(as.binarySearch("Peter"));
		System.out.println(as.binarySearch("Abby"));
		System.out.println(as.binarySearch("Tanner"));
		System.out.println(as.binarySearch("Ewen"));
		System.out.println(as.binarySearch("Roger"));
	}

	public static void main(String[] args) {
		testASBin();
		System.out.println("");
		System.out.println("Peter".compareTo("Andrew"));
		
		
		
		
	}

}
