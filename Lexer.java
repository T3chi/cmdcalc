import java.util.ArrayList;

public interface Lexer{
	// returns a list of tokens for parsing
	// ex "4+3-2/7*(3+2)" => [4,+,3,-,2,/,7,*,(,3,+,2,)]
	ArrayList<String> lex(String s);

}
