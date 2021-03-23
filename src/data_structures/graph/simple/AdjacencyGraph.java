package data_structures.graph.simple;

import java.util.ArrayList;

/**
 * Graph Representations:
 * 
 * 1. Adjacency Matrix is a 2D array of size V x V where V is the number of
 * vertices in a graph. Slot GRAPH[i][j] = 1 indicates that there is an edge
 * from vertex i to vertex j.
 * 
 * 2. Adjacency List is an array of lists. The size of the array is equal to the
 * number of vertices. Let the array be an array[]. An entry array[i] represents
 * the list of vertices adjacent to the i'th vertex.
 */
public class AdjacencyGraph {

	// Adjacency list representation
	private static ArrayList<ArrayList<Integer>> adjacenctEdges;

	public AdjacencyGraph(int nodes) {
		// Create an array list of array lists for maximum no. of nodes
		adjacenctEdges = new ArrayList<>(nodes);
		for (int i = 0; i < nodes; i++) {
			adjacenctEdges.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int u, int v) {
		// Set edges from both u -> v and v -> u vertices
		adjacenctEdges.get(u).add(v);
		adjacenctEdges.get(v).add(u);
	}

	public void print() {
		for (int vert = 0; vert < adjacenctEdges.size(); vert++) {
			for (int adj = 0; adj < adjacenctEdges.get(vert).size(); adj++) {
				System.out.print(vert + " -> " + adjacenctEdges.get(vert).get(adj) + "    ");
			}
			System.out.println();
		}
	}

}
