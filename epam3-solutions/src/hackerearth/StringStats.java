package hackerearth;

import java.util.Scanner;

/**
 * 
 * Question URL :- https://www.hackerearth.com/practice/algorithms/
 * string-algorithm/z-algorithm/practice-problems/algorithm/statistics-of-strings-3bec3843/
 *
 */

public class StringStats {

	public static long mem[];

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long m = scan.nextLong();
		long mode = scan.nextLong();
		mem = new long[n];
		long result = 0;
		int r = 1;
		while (r < n) {
			long coff = findCofficient(m, r, mode);
			long tmpResult = 0, pow = 0;
			for (int k = 1; (n - k) > 0 && k <= r; k++) {
				tmpResult += (n - k) * Math.pow(2, pow) % mode;
				pow++;
			}
			result += (coff * tmpResult) % mode;
			pow = 0;
			r++;
		}
		System.out.println(result);
		scan.close();
	}

	public static long findCofficient(long m, int r, long mode) {
		if (mem[r] > 0) {
			return mem[r];
		} else {
			long nom = 1, deno = 1, t1 = m;
			while (t1 > m - r) {
				nom *= t1;
				nom = nom % mode;
				t1--;
			}
			while (r > 1) {
				deno *= r;
				r--;
			}
			return nom / deno;
		}
	}

}
