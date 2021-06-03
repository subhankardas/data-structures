package data_structures.graph.problems;

import java.util.ArrayList;

/**
 * A mother vertex in a graph G = (V,E) is a vertex v such that all other
 * vertices in G can be reached by a path from v.
 * 
 * The idea is based on Kosaraju’s Strongly Connected Component Algorithm. If
 * there exist mother vertex (or vertices), then one of the mother vertices is
 * the last finished vertex in DFS. (Or a mother vertex has the maximum finish
 * time in DFS traversal). A vertex is said to be finished in DFS if a recursive
 * call for its DFS is over, i.e., all descendants of the vertex have been
 * visited.
 */
public class MotherVertex {

	// Add edge for vertices u -> v
	static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> graph) {
		graph.get(u).add(v);
	}

	static void DFSUtil(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited) {
		// Mark the current vertex as visited
		visited[v] = true;

		// Loop for all vertices adjacent to current vertex
		for (int x : graph.get(v)) {
			if (!visited[x]) {
				DFSUtil(graph, x, visited);
			}
		}
	}

	static int motherVertex(ArrayList<ArrayList<Integer>> graph, int V) {
		boolean[] visited = new boolean[V];
		int v = -1;

		// Record the last vertex visited in DFS traversal
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFSUtil(graph, i, visited);
				v = i;
			}
		}

		// The last vertex is candidate for mother vertex
		boolean[] check = new boolean[V];

		// So DFS traverse from that vertex
		DFSUtil(graph, v, check);

		// If all vertices are visited, v is the mother vertex
		// Else return -1 i.e. no mother vertex
		for (boolean val : check) {
			if (!val) {
				return -1;
			}
		}
		return v;
	}

	public static void main(String[] args) {
		int V = 7;

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<Integer>());
		}
		addEdge(0, 1, graph);
		addEdge(0, 2, graph);
		addEdge(1, 3, graph);
		addEdge(4, 1, graph);
		addEdge(6, 4, graph);
		addEdge(5, 6, graph);
		addEdge(5, 2, graph);
		addEdge(6, 0, graph);

		System.out.println("Mother Vertex is: " + motherVertex(graph, V));
	}

}
