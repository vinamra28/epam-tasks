package com.epam.interest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.interest.services.InterestServiceImpl;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static App app;

	/**
	 * Setting up instance of the application class
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		app = new App(new InterestServiceImpl());
	}

	@Test
	public void testSimpleInterest() {
		assertEquals(550.0, app.calculateAmount(500, 5, 2, "simple"), 0.0);
	}

	@Test
	public void testCompoundInterest() {
		System.out.println(app.calculateAmount(500, 5, 2, "compound"));
		assertEquals(551.25, app.calculateAmount(500, 5, 2, "compound"), 0.0);
	}
}
