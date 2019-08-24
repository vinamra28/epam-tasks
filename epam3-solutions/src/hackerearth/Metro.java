package hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Question URL :- https://www.hackerearth.com/practice/algorithms
 * /graphs/shortest-path-algorithms/practice-problems/algorithm/metro-6db2ba1b/
 *
 */

public class Metro {

	int x, w, t;
	static int ans = -1;

	Metro(int w, int x, int t) {
		this.w = w;
		this.x = x;
		this.t = t;
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		ArrayList<Metro> list[] = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<Metro>();

		for (int i = 0; i < m; i++) {
			int k = scan.nextInt();
			int t = scan.nextInt();
			int a[] = new int[k];
			for (int j = 0; j < k; j++)
				a[j] = scan.nextInt();

			for (int j = 0; j < k - 1; j++) {
				int w = scan.nextInt();
				list[a[j]].add(new Metro(w, a[j + 1], t));
			}
		}
		boolean visited[] = new boolean[n + 1];
		int start = scan.nextInt();
		int end = scan.nextInt();
		solve(list, start, end, visited, 0);
		System.out.println(ans);
		scan.close();
	}

	public static void solve(ArrayList<Metro>[] list, int start, int end, boolean[] visited, int an) {
		if (start == end) {
			if (ans == -1)
				ans = an;
			else
				ans = Math.min(ans, an);
			return;
		}
		if (visited[start])
			return;
		visited[start] = true;
		for (Metro test : list[start]) {
			if (!visited[test.x])
				solve(list, test.x, end, visited, an + test.w);
		}
	}
}
