package com.epam.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.calculator.services.CalculatorServiceImpl;

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
		app = new App(new CalculatorServiceImpl());
	}

	/**
	 * Test method to test the addition of two numbers
	 */
	@Test
	public void testAddition() {
		assertEquals(4.0, app.performCalculation(2, 2, '+'), 0.0);
		// assertEquals (8.0,app.performCalculation(2,3,'+'),0.0);
	}

	/**
	 * Test method to test the multiplication of two numbers
	 */
	@Test
	public void testMultiplication() {
		assertEquals(12.0, app.performCalculation(3, 4, '*'), 0.0);
		// assertEquals(48.0,app.performCalculation(4,8,'*'),0.0);
	}

	/**
	 * Test method to test the division of two numbers
	 */
	@Test
	public void testDivision() {
		assertEquals(12.0, app.performCalculation(36, 3, '/'), 0.0);
		// assertEquals(12.0,app.performCalculation(36,2,'/'),0.0);
	}

	/**
	 * Test method to check if we provide another operator other then specified
	 */
	@Test
	public void testDifferentOperator() {
		assertEquals(0.0, app.performCalculation(5, 6, '-'), 0.0);
	}
}
