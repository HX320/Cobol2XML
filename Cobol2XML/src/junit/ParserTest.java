package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class ParserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		t.setString("program-id. JB-base.");
		
		
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in); //successfully consumes tokens from the input string, so the assembly is not empty
		
		//Test the content of the output assembly
		assertFalse(out.stackIsEmpty()); //Ensure the output assembly is not empty
		System.out.print("Output Assembly Content in first time: ");
		System.out.println(out.toString()); //Print the content of the output assembly
		
		
		Assembly inputAssembly = new TokenAssembly(t);
		Assembly outputAssembly = p.bestMatch(inputAssembly); //same input assembly is used, but since all tokens were consumed in the first part, the assembly remains empty.
		assertTrue(outputAssembly.stackIsEmpty());
		
		System.out.println("Consumed elements: " + outputAssembly.consumed(" "));
		System.out.println("Remaining elements: " + outputAssembly.remainder(" "));
		
		
	}

}
