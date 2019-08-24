package com.epam.calculation.services;

public interface CostCalculationService {

	/**
	 * 
	 * @param {double} area
	 * @param {String} choiceMaterial
	 * @param {String} choiceAutomation
	 * @return {double} cost per Area(square feet)
	 */

	public double calculateCost(double area, String choiceMaterial, String choiceAutomation);
}
