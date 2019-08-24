package hackerearth;

import java.util.*;

/**
 * Question URL :- https://www.hackerearth.com/practice/
 * algorithms/sorting/bucket-sort/practice-problems/algorithm/sort-the-array-5/
 *
 */

public class DescendingWeights {

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		long N = scan.nextLong();
		long K = scan.nextLong();
		ArrayList<Long> numbers = new ArrayList<>();
		for (long iterArray = 0; iterArray < N; iterArray++)
			numbers.add(scan.nextLong());

		Collections.sort(numbers, (a, b) -> {
			if (a % K == b % K)
				return (int) (a - b);
			else
				return (int) (b % K - a % K);
		}

		);
		for (long iterArray : numbers)
			System.out.print(iterArray + " ");
		scan.close();
	}

}
