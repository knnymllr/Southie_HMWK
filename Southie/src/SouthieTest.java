import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SouthieTest extends Southie {

	@Test
	void testCheckForVowels() {
		assertTrue(Southie.checkForVowels('a'));
		assertTrue(Southie.checkForVowels('A'));
		assertTrue(Southie.checkForVowels('e'));
		assertTrue(Southie.checkForVowels('E'));
		assertTrue(Southie.checkForVowels('i'));
		assertTrue(Southie.checkForVowels('I'));
		assertTrue(Southie.checkForVowels('o'));
		assertTrue(Southie.checkForVowels('O'));
		assertTrue(Southie.checkForVowels('u'));
		assertTrue(Southie.checkForVowels('U'));
		assertFalse(Southie.checkForVowels('z'));
		assertFalse(Southie.checkForVowels('k'));
		assertFalse(Southie.checkForVowels('x'));
		assertFalse(Southie.checkForVowels('2'));
		assertFalse(Southie.checkForVowels('7'));
		assertFalse(Southie.checkForVowels(' '));
		assertFalse(Southie.checkForVowels('/'));
		assertFalse(Southie.checkForVowels('?'));
	}
	
	@Test
	void testCheckPunct() {
		assertTrue(Southie.checkPunct('.'));
		assertTrue(Southie.checkPunct(','));
		assertTrue(Southie.checkPunct('?'));
		assertTrue(Southie.checkPunct('!'));
		assertTrue(Southie.checkPunct(')'));
		assertTrue(Southie.checkPunct('-'));
		assertTrue(Southie.checkPunct('"'));
		assertFalse(Southie.checkPunct('z'));
		assertFalse(Southie.checkPunct('k'));
		assertFalse(Southie.checkPunct('x'));
		assertFalse(Southie.checkPunct('2'));
		assertFalse(Southie.checkPunct('7'));
		assertFalse(Southie.checkPunct(' '));
		assertFalse(Southie.checkPunct('/'));
	}
	
	@Test
	void testExceptions() {
		assertEquals("", Southie.exceptions(""));
		assertEquals("doowah,", Southie.exceptions("door,"));
		assertEquals("Floors", Southie.exceptions("Floors"));
		assertEquals("\"Floowah\"", Southie.exceptions("\"Floor\""));
		assertEquals("CHEEYAH ", Southie.exceptions("CHEER "));
		assertEquals("jeeyah.", Southie.exceptions("jeer."));
		assertEquals("SeAFloowah!", Southie.exceptions("SeAFloor!"));
		assertEquals("armchaiyah?", Southie.exceptions("armchair?"));
		assertEquals("(Beeyah) on the floowah.", Southie.exceptions("(Beer) on the floor."));
	}
	
	@Test
	void testCheckForR() {
		assertEquals("", Southie.checkForR(""));
		assertEquals("Ahe run aht try red AHM DRY", Southie.checkForR("Are run art try red ARM DRY"));
		assertEquals("razoh", Southie.checkForR("razor"));
		assertEquals("reinCAHnaTIOn", Southie.checkForR("reinCARnaTIOn"));
		
	}
	
	@Test
	void testAppendR() {
		assertEquals("", Southie.appendR(""));
		assertEquals("tunar", Southie.appendR("tuna"));
		assertEquals("tunas", Southie.appendR("tunas"));
		assertEquals("AlPhAR", Southie.appendR("AlPhA"));
		assertEquals("BeTar", Southie.appendR("BeTa"));
		assertEquals("(thetar)", Southie.appendR("(theta)"));
		assertEquals("Omegar, omegar. OmegAR?", Southie.appendR("Omega, omega. OmegA?"));
		assertEquals("Capybarar!", Southie.appendR("Capybara!"));
	}
	
	
}
