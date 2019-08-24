package com.epam.calculation;

import com.epam.calculation.services.CostCalculationService;

/**
 * Hello world!
 *
 */
public class App {
	private CostCalculationService costCalculationService;

	public App(CostCalculationService costCalculationService) {
		this.costCalculationService = costCalculationService;
	}

	/**
	 * 
	 * @param area
	 * @param choiceMaterial
	 * @param choiceAutomation
	 * @return cost to build the house
	 */
	public double calculatePricing(double area, String choiceMaterial, String choiceAutomation) {
		return costCalculationService.calculateCost(area, choiceMaterial, choiceAutomation);
	}
}
