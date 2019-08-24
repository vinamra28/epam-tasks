package com.epam.junittasks;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PrimitiveIterator.OfDouble;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.xml.stream.events.Characters;

import org.hamcrest.core.Is;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EpamTest {
	
	/**
	 * Remove A from first two characaters of String if present
	 * 1. when length of String is one
	 * 2. when length of String is two
	 * 3. when length of String is four
	 * 4. when length of String is N
	 */

	App app;
	
	@BeforeEach
	void setUp() throws Exception {
		app = new App();
	}

	@Test
	void removeFromOneChar() {
		assertEquals( "",app.removeAChars("A"));
		assertEquals("B",app.removeAChars("B"));
	}

	@Test
	void removeFromTwoChars() {
		assertEquals( "",app.removeAChars("AA"));
		assertEquals("BB",app.removeAChars("BB"));
		assertEquals("B",app.removeAChars("AB"));
	}
	
	@Test
	void removeFromFourChars() {
		assertEquals( "BA",app.removeAChars("AABA"));
		assertEquals("BAB",app.removeAChars("ABAB"));
		assertEquals("AB",app.removeAChars("AAAB"));
	}
	
	@Test
	void removeFromNChars() {
		assertEquals( "CBAA",app.removeAChars("AACBAA"));
		assertEquals("BAB",app.removeAChars("AABAB"));
		assertEquals("BACAB",app.removeAChars("ABACAB"));
		assertEquals("CABAB",app.removeAChars("CAABAB"));
	}
	
}
