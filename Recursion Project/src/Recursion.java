public class Recursion {

	// Part 1: complete
	public static int sum(int n){
		if (n <= 1) //BASE CASE
			return n;
		else //RECURSIVE CASE
			return n + sum(n - 1);
	}

	// Part 1 complete
	public static int multiply(int m, int n){
		if (n == 0) //BASE CASE
			return 0;
		//RECURSIVE CASES:
		else if (n > 0) //for positive values
			return (m + multiply(m, n-1));
		else //for negative values
			return -(multiply(m, -n));
	}
	
	// Part 1: complete
	public static int Fibonacci(int n){
		if (n < 2) //BASE CASE
			return n;
		else //RECURSIVE CASE
			return Fibonacci(n - 1) + Fibonacci(n - 2);
	}


}