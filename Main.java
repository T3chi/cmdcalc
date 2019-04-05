import java.util.*;

public class Main{

	public static void main(String[] args){
		if( args.length != 0 ){
			String s = " ";
			for(String i:args)
				s += i + " ";
			System.out.println(run(s));
		} else {
			System.out.println("starting repl mode");
			Scanner s = new Scanner(System.in);
			while(s.hasNextLine()){
				System.out.println(run(s.nextLine()));
			}
			System.out.println("<Finished Execution>");
		}		
	}
	
	private static double run(String s){
		Lexer l = new Lex();
		Parser p = new Parse();
		// parse the tokens returned from lex and return result 
		return p.parse(l.lex(s));
	}

}

class Lex implements Lexer{
	public ArrayList<String> lex(String s){
		if(s == null) 
			throw new NullPointerException("s was null");
		else{
			ArrayList<String> l = new ArrayList<String>();
			for(String i:s.split(" ")){
				if(!i.isEmpty())
					l.add(i);
			}
			return l;
		}
	}
}

class Parse implements Parser{

	public double parse(ArrayList<String> tokens){
		if(tokens == null) 
			throw new NullPointerException("tokens was null");
		else if(tokens.size() < 3){
			System.out.println("Not enough tokens to evaluate");
			for(String s: tokens)
				System.out.println("Token: " + s);
			return 0;	
		}
		else {
				if(! ((tokens.size() % 2) == 1))
				{
					// the length % 2 should always be 1 (odd)
					// 4 + 3 , 3  % 2  == 1
					// 4 + 3 / 2, 5 % 2 == 1
					System.out.println("tokens size is even, returning 0");
					return 0;
				}
				
				double result = 0;
				
				for(int i = 0; i < tokens.size(); i++)
				{
					// get first three tokens and 
					//String left = tokens[i],right = tokens[i+2],op = tokens[i+1];
					if(i == 0){
						// first iteration, get left num, right num, and operator
						result = Eval.eval(tokens.get(i),tokens.get(i+2),tokens.get(i+1));
						if(tokens.size() == 3)
							return result;
						 i+=2;
					} else {
						result = Eval.eval(Double.toString(result),tokens.get(i+1),tokens.get(i));
						i++;
					}
				}
				
				return result;
			}
			
		}

}
