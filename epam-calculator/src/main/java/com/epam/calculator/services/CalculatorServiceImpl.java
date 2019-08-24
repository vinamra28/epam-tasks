package com.epam.calculator.services;

public class CalculatorServiceImpl implements CalculatorService {

	/**
	 * the following function is used to add two numbers
	 *
	 * @param number1
	 * @param number2
	 * @return sumOfTwoNumbers
	 */

	public int addNumber(int number1, int number2) {

		int sumOfTwoNumbers = number1 + number2;

		return sumOfTwoNumbers;
	}

	/**
	 * the following function is used to multiply two numbers
	 *
	 * @param {int} number1
	 * @param {int} number2
	 * @return {int} multiplyOfTwoNumbers
	 */
	public int multiplyNumbers(int number1, int number2) {

		int multiplyOfTwoNumbers = number1 * number2;

		return multiplyOfTwoNumbers;
	}

	/**
	 * the following function is used to divide two numbers
	 * 
	 * @param {int} number1
	 * @param {int} number2
	 * @return {double} divideTwoNubers
	 */
	public double divideNumbers(int number1, int number2) {

		double divideTwoNubers = 0.0;

		try {
			divideTwoNubers = (double) number1 / number2;
		} catch (ArithmeticException arithmeticException) {
			arithmeticException.printStackTrace();
		}
		return divideTwoNubers;
	}
}