package com.epam.calculation.services;

public class CostCalculationServiceImpl implements CostCalculationService {

	/**
	 * Function to calculate cost to build house per square feet area
	 * 
	 * @param {double} area
	 * @param {String} choiceMaterial
	 * @param {String} choiceAutomation
	 * @return {double} cost to build house
	 */
	@Override
	public double calculateCost(double area, String choiceMaterial, String choiceAutomation) {

		double costHouse = 0.0;
		if (choiceAutomation.equalsIgnoreCase("full")) {
			if (choiceMaterial.equalsIgnoreCase("high")) {
				costHouse = area * 2500;
			}
		} else {
			if (choiceMaterial.equalsIgnoreCase("full")) {
				costHouse = area * 1800;
			} else if (choiceMaterial.equalsIgnoreCase("aboveStandard")) {
				costHouse = area * 1500;
			} else if (choiceMaterial.equalsIgnoreCase("standard")) {
				costHouse = area * 1200;
			} else {
				costHouse = 0.0;
			}
		}
		return costHouse;
	}

}
