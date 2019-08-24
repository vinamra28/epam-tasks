package hackerearth;

import java.util.*;

/**
 * 
 * Question URL :- https://www.hackerearth.com/practice/algorithms/
 * greedy/basics-of-greedy-algorithms/practice-problems/algorithm/help-out-the-indian-army/description/
 *
 */

public class IndianArmy {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int s = scan.nextInt();
		int e = scan.nextInt();

		int[] a = new int[e - s];
		for (int i = 0; i < (e - s); i++) {
			a[i] = 0;
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if (x - y <= s) {
				a[0] = -1;
				a[x + y - 1 - s] = 1;
			} else if (x + y > e) {
				a[e - s - 1] = +1;
				a[x - y - 1 - s] = -1;
			} else {
				a[x - y - 1 - s] = -1;
				a[x + y - 1 - s] = 1;
			}

		}

		int k = 0;
		for (int i = 0; i < (e - s); i++) {
			if (k == 0)
				ans++;
			k = k + a[i];
		}
		System.out.println(ans);

		scan.close();
	}

}
