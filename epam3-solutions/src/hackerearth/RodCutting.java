package hackerearth;

import java.util.Scanner;

/**
 * 
 * Question URL :-
 * https://www.hackerearth.com/problem/algorithm/rod-cutting-problem-7/
 *
 */

public class RodCutting {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int test[] = new int[t];
		for (int i = 0; i < t; i++)
			test[i] = scan.nextInt();

		for (int i = 0; i < t; i++) {
			calculateAnswer(test[i]);
		}
		scan.close();

	}

	static void calculateAnswer(int length) {

		int count = 0;
		int checkLen = 3;
		while (checkLen <= length) {

			count++;
			checkLen = (checkLen * 2) + 1;
		}
		System.out.println(count);
	}

}
