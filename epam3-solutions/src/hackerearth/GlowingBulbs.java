package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Question URL :- https://www.hackerearth.com/practice/algorithms/
 * searching/binary-search/practice-problems/algorithm/glowing-bulbs/
 *
 */

public class GlowingBulbs {
	static List<Integer> switchBulbs;
	static int sizeList;

	public static void main(String args[]) throws Exception {

		StringBuilder sbr = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switchBulbs = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		long N, lb, ub, m, c, ans;
		for (int test = 0; test < T; test++) {

			String S = br.readLine();
			N = Long.parseLong(br.readLine());
			switchBulbs.clear();
			for (int i = 0; i < 40; i++) {
				if (S.charAt(i) == '1')
					switchBulbs.add(i + 1);
			}
			lb = 1;
			sizeList = switchBulbs.size();
			ub = N * switchBulbs.get(sizeList - 1);
			m = 0;
			ans = 0;

			while (lb <= ub) {
				m = (lb + ub) >> 1;
				c = paramSearch(m);
				if (c >= N) {
					ub = m - 1;
					ans = m;
				} else {
					lb = m + 1;
				}

			}
			sbr.append(ans + "\n");

		}

		System.out.println(sbr);

	}

	static long paramSearch(long value) {
		long size = 1 << sizeList;
		long sum;
		long K = 0;
		for (int i = 1; i < size; i++) {
			sum = 1;
			for (int j = 0; j < sizeList; j++) {
				if ((i & (1 << j)) == (1 << j)) {
					sum *= switchBulbs.get(j);
				}
			}
			if ((Integer.bitCount(i) & 1) == 1)
				K += value / sum;
			else
				K -= value / sum;
		}
		return K;
	}
}