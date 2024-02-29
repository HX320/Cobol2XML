package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parse.tokens.Token;

public class TokenTest {

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
		String c = "exmaples to exmpanfe";
		Token t = new Token(c);
		assertFalse(t.isNumber());
		assertTrue(t.isWord());
		assertFalse(t.isSymbol());
		assertFalse(t.isQuotedString());
	}

}
