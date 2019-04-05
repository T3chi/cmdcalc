import java.util.*;
public interface Eval{
	// evaluates simple expressions
	static double eval(String l, String r, String op){
		if(l == null || r == null)
			throw new NullPointerException("left or right was null");
		double left,right;
		try{
			left = Double.parseDouble(l);
			right = Double.parseDouble(r);
		} catch(Exception e){
			System.out.println(e);
			System.out.println("l or r could not be parsed to double, returning 0");
			return 0;
		}
		switch(op){
			case "*": return left*right;
			case "/": {
						if(right != 0) 
							return left/right; 
						else 
							{
								System.out.println("Attempted divide by 0, returning 0");
								return	0;
							}
					  }
			case "+": return left+right;
			case "-": return left-right;
			default: return 0;
		}
	}

}
