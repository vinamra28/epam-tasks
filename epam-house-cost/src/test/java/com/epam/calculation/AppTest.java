package com.epam.calculation;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.calculation.services.CostCalculationServiceImpl;

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
		app = new App(new CostCalculationServiceImpl());
	}

	/**
	 * Function to test house cost build with standard material
	 */
	@Test
	public void testStandardHouseCost() {
		assertEquals(120000.0, app.calculatePricing(100, "standard", "no"), 0.0);
	}

	/**
	 * Function to test house cost build with above standard material
	 */
	@Test
	public void testAboveStandardHouseCost() {
		assertEquals(150000.0, app.calculatePricing(100, "aboveStandard", "no"), 0.0);
	}

	/**
	 * Function to test house cost build with high standard material
	 */
	@Test
	public void testHighStandardHouseCost() {
		assertEquals(180000.0, app.calculatePricing(100, "full", "no"), 0.0);
	}

	/**
	 * Function to test house cost build with high standard material and full
	 * automation
	 */
	@Test
	public void testHighStandardHouseCostWithAutomation() {
		assertEquals(250000.0, app.calculatePricing(100, "high", "full"), 0.0);
	}
}
