package com.epam.interest;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.epam.interest.services.InterestService;

public class App {

	private InterestService interestService;

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Constructor to initialize Service Interface
	 * 
	 * @param interestService
	 */
	public App(InterestService interestService) {
		this.interestService = interestService;
	}

	/**
	 * 
	 * @param {double} principal amount
	 * @param {double} rate of interest
	 * @param {double} time
	 * @param {String} choice {"simple","compound"}
	 * @return {double} finalAmount
	 */
	public double calculateAmount(double principal, double rate, int time, String choice) {

		double finalAmount = 0.0;
		double interest = 0.0;

		if (choice.equalsIgnoreCase("simple")) {
			interest = interestService.calculateSimpleInterest(principal, rate, time);
			finalAmount = principal + interest;
		} else if (choice.equalsIgnoreCase("compound")) {
			finalAmount = interestService.calculateCompoundInterest(principal, rate, time);
		} else {
			LOGGER.log(Level.INFO, "Wrong choice");
		}

		return finalAmount;
	}
}
