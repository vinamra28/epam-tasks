package com.epam;

public class MyCalculator {

	/**
	 * Two types of Exceptions are raised:- 1. n or p should not be negative 2. n
	 * and p should not be zero
	 * 
	 * @param {int} n
	 * @param {int} p
	 * @return {long} power of n^p
	 * @throws Exception
	 */
	public long power(int n, int p) throws Exception {
		if (n == 0 && p == 0) {
			throw new Exception("n and p should not be zero.");
		} else if (n < 0 || p < 0) {
			throw new Exception("n or p should not be negative.");
		} else {
			return (long) Math.pow(n, p);
		}
	}
}
