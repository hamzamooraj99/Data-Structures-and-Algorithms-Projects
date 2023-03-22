// exception used for Q5
class CalculateException extends RuntimeException{    
	public CalculateException(String err) {
		super(err);
	}
}

public class Calculator {

	/*
	 *  Methods for Part 3
	 */
	public static int calculate(String [] cmds){ //Calculates given array.
		Stack stack = new Stack(100);
		Reverse.reverse(cmds); //Reverse Polish Notation (numbers are first)
		
		for (int i = 0; i < cmds.length; i++) {  //Loop runs through each value in cmds
			if (isNumber(cmds[i])) {
				stack.push(cmds[i]);
			} /*Checks if the value indexed from cmds is a number or not.
				If it is a number, then it is pushed into stack.*/
			
			else {
				String fst = (String) stack.pop();
				String snd = (String) stack.pop();
				stack.push(String.valueOf(applyOp(fst, cmds[i], snd)));
			} /*When loop reaches operators, it uses applyOp method.*/
		}
		
		return (convert((String) stack.pop()));
			//Result will be popped.
	}	

	
	public static int convert(String s) throws NumberFormatException{ //Converts String to integer
		return (Integer.valueOf(s));
	}

	public static boolean isNumber(String s){ //Checks if String value represents a number.
		try {
			int n = Integer.parseInt(s);
		} catch (NumberFormatException nfe) { //If String does not represent a number, an Exception is thrown.
			return false;
		}
		return true;
	}

	// apply the operator after converting the numbers
	public static int applyOp(String fst,String op,String snd){
		int a = convert(fst);
		int b = convert(snd);
		int val = 0;
		
		if (op.equals("+"))			
			val = (a + b);
		else if (op.equals("-"))
			val = (a - b);
		else if (op.equals("*"))
			val = (a * b);
		else if (op.equals("/"))
			val = (a / b);
		/*Above if..else block checks what operator String represents.
		  Completes Arithmetic accordingly.*/
		
		return val;
	}

	// main operation to calculate using Polish notation directly
    public static int calculatePolish(String [] cmds){
    	return -1; // dummy value
    }
}
