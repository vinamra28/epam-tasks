package hackerrank;

/**
 * 
 * @author Vinamra
 *
 *         Question URL :-
 *         https://www.hackerrank.com/challenges/primsmstsub/problem
 */

import java.util.*;

class Graph {

	static class Pair {

		int to;
		int weight;

		Pair(int to, int weight) {

			this.to = to;
			this.weight = weight;
		}
	}

	List<List<Pair>> adjacencyList;
	int vertices;

	Graph(int vertices) {

		this.vertices = vertices;
		adjacencyList = new ArrayList<List<Pair>>(vertices * vertices);

		for (int i = 0; i < vertices; i++) {

			adjacencyList.add(new ArrayList<Pair>());
		}
	}

	public void addEdge(int from, int to, int weight) {

		adjacencyList.get(from).add(new Pair(to, weight));
		adjacencyList.get(to).add(new Pair(from, weight));
	}

	public int prims(int startVertex) {

		if (vertices <= 0) {

			return 0;
		}

		// visited array
		boolean visited[] = new boolean[vertices];

		int[] dist = new int[vertices];

		// fill distance default values
		dist[startVertex] = 0;
		for (int i = 1; i < dist.length; i++) {

			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < vertices; i++) {

			int currentVertex = findMinDist(dist, visited);
			visited[currentVertex] = true;

			// get neighbours of current vertex
			for (int j = 0; j < adjacencyList.get(currentVertex).size(); j++) {

				int neighbour = adjacencyList.get(currentVertex).get(j).to;
				int weight = adjacencyList.get(currentVertex).get(j).weight;

				if (visited[neighbour] == false && dist[neighbour] > weight) {

					dist[neighbour] = weight;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < dist.length; i++) {

			result += dist[i];
		}

		return result;
	}

	public int findMinDist(int[] dist, boolean[] visited) {

		int minWeight = Integer.MAX_VALUE;
		int minVertex = -1;

		for (int i = 0; i < vertices; i++) {

			if (visited[i] == false && dist[i] < minWeight) {

				minWeight = dist[i];
				minVertex = i;
			}
		}

		return minVertex;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int vertices = input.nextInt();
		int edges = input.nextInt();

		Graph graph = new Graph(vertices);

		for (int i = 0; i < edges; i++) {

			int from = input.nextInt();
			int to = input.nextInt();
			int weight = input.nextInt();

			graph.addEdge(from - 1, to - 1, weight);
		}

		int startVertex = input.nextInt();

		input.close();

		System.out.println(graph.prims(startVertex - 1));
	}
}
