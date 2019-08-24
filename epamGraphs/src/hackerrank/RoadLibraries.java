package hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//used the disjoint set technique

public class RoadLibraries {

	public static int getRoot(int[] map, int ind) {
		if (map[ind] < 0)
			return ind;
		else
			return getRoot(map, map[ind]);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			long x = in.nextLong();
			long y = in.nextLong();
			int[] map = new int[n];
			Arrays.fill(map, -1);
			for (int a1 = 0; a1 < m; a1++) {
				int city_1 = in.nextInt() - 1;
				int city_2 = in.nextInt() - 1;
				int root_1 = getRoot(map, city_1);
				int root_2 = getRoot(map, city_2);
				if (root_1 != root_2) {
					if (map[root_1] < map[root_2]) {
						map[root_1] = map[root_1] + map[root_2];
						map[root_2] = root_1;
					} else {
						map[root_2] = map[root_1] + map[root_2];
						map[root_1] = root_2;
					}
				}
			}
			// get sets
			Queue queue = new LinkedList();
			for (int i = 0; i < n; i++) {
				if (map[i] < 0)
					queue.add(map[i]);
			}
			// build library: size*x
			// build route: (size-1)*y+x
			if (x > y) {
				long sum = 0;
				while (!queue.isEmpty()) {
					sum += ((int) queue.poll() + 1) * y - x;
				}
				System.out.println(-sum);
			} else {
				long sum = 0;
				while (!queue.isEmpty()) {
					sum += ((int) queue.poll()) * x;
				}
				System.out.println(-sum);
			}
		}
		in.close();
	}

}
