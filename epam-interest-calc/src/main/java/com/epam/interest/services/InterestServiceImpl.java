package com.epam.interest.services;

public class InterestServiceImpl implements InterestService {

	/**
	 * The following function calculates the simple interest and returns the final
	 * amount paid
	 *
	 * simpleInterest = (principalAmount * rate of Interest * time(years)) /100
	 *
	 * @param {double} principalAmount
	 * @param {double} rate per annum
	 * @param {int} time in year
	 * @return {double} simpleInterest
	 */
	@Override
	public double calculateSimpleInterest(double principalAmount, double rate, int time) {

		double simpleInterest = (principalAmount * time * rate) / 100.0;

		return simpleInterest;
	}

	/**
	 * The following function calculates the compound interest and returns the final
	 * amount paid
	 *
	 * compoundInterest = principalAmount((1+(rate/100.0))^time)
	 *
	 * @param {double} principalAmount
	 * @param {double} rate
	 * @param {int} time
	 * @return {double} compoundInterest
	 */
	@Override
	public double calculateCompoundInterest(double principalAmount, double rate, int time) {

		double compoundInterest = principalAmount * (Math.pow((1 + (rate / 100.0)), time));

		return compoundInterest;
	}

}
