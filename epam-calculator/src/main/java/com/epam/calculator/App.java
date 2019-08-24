package com.epam.calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.epam.calculator.services.CalculatorService;

public class App {

	private CalculatorService calculatorService;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public App(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	/**
	 *
	 * @param {int} number1
	 * @param {int} number2
	 * @param {character} operator
	 * @return {double} result
	 */
	double performCalculation(int number1, int number2, char operator) {

		double result = 0.0;

		switch (operator) {

		case '+':
			result = calculatorService.addNumber(number1, number2);
			break;
		case '*':
			result = calculatorService.multiplyNumbers(number1, number2);
			break;
		case '/':
			result = calculatorService.divideNumbers(number1, number2);
			break;
		default:
			LOGGER.log(Level.INFO, "Wrong operator");
		}

		return result;
	}
}
