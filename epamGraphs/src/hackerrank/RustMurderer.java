package hackerrank;

/**
 * 
 * @author Vinamra
 *
 *         Question URL :-
 *         https://www.hackerrank.com/challenges/rust-murderer/problem
 */

//approach :- One small optimization is to sort each of the 
//adjacency lists: this way when we are doing BFS and 
//iterating through all N nodes that may potentially be in the complement 
//of the adjacency list, the check for membership in the 
//adjacency list can be done in O(1) time, since both the list and our 
//iteration is in increasing order. Additionally, 
//we increment a counter every time a node is discovered, 
//and immediately return when that counter hits N 
//(if we don't, there will still be a lot of garbage in the queue which we would waste time iterating over).

import java.util.*;

public class RustMurderer {

	static int[][] adjacency(int n, int[] x, int[] y) {
		int[] count = new int[n];
		for (int i : x)
			++count[i];
		for (int i : y)
			++count[i];
		int[][] adj = new int[n][];
		for (int i = 0; i < n; ++i)
			adj[i] = new int[count[i]];
		for (int i = 0; i < x.length; ++i) {
			adj[x[i]][--count[x[i]]] = y[i];
			adj[y[i]][--count[y[i]]] = x[i];
		}
		for (int i = 0; i < n; ++i)
			Arrays.sort(adj[i]);
		return adj;
	}

	static int[] distance(int s, int[][] adj) {
		int n = adj.length, dist[] = new int[n];
		Queue<Integer> bfs = new ArrayDeque<>();
		bfs.add(s);
		int count = 1;
		while (count != n) {
			int x = bfs.remove(), i = 0;
			for (int j = 0; j < n; ++j) {
				if (i != adj[x].length && j == adj[x][i])
					++i;
				else if (j != s && dist[j] == 0) {
					++count;
					dist[j] = dist[x] + 1;
					bfs.add(j);
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- != 0) {
			int n = sc.nextInt(), m = sc.nextInt();
			int[] x = new int[m], y = new int[m];
			for (int i = 0; i < m; ++i) {
				x[i] = sc.nextInt() - 1;
				y[i] = sc.nextInt() - 1;
			}
			int[][] adj = adjacency(n, x, y);
			int s = sc.nextInt() - 1;
			int[] dist = distance(s, adj);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; ++i) {
				if (i != s)
					sb.append(dist[i] + " ");
			}
			System.out.println(sb);
		}
		sc.close();
	}

}
