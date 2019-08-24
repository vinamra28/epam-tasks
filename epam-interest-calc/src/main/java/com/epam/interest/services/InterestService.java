package com.epam.interest.services;

public interface InterestService {

	/**
	 *
	 * @param {double} principalAmount
	 * @param {double} rate
	 * @param {int} time
	 * @return {double} simpleInterest
	 */
	public double calculateSimpleInterest(double principalAmount, double rate, int time);

	/**
	 *
	 * @param {double} principalAmount
	 * @param {double} rate
	 * @param {int} time
	 * @return {double} compoundInterest
	 */
	public double calculateCompoundInterest(double principalAmount, double rate, int time);

}
