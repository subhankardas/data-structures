package data_structures.graph.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

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

	public void BFS(int start) {
		// Create array to flag nodes as visited to avoid loop
		boolean visited[] = new boolean[adjacenctEdges.size()];

		// Queue to hold adjacent vertices for a node
		Queue<Integer> queue = new ArrayDeque<Integer>();

		// Start with a node, mark it visited
		queue.add(start);
		visited[start] = true;

		while (queue.size() != 0) {
			// Get next node in queue as current node
			int currentNode = queue.poll();
			ArrayList<Integer> vertices = adjacenctEdges.get(currentNode);

			// Visit all adjacent vertices for current node, mark them as visited
			for (int vert : vertices) {
				if (visited[vert] != true) {
					queue.add(vert);
					visited[vert] = true;
				}
			}

			System.out.print(" -> " + currentNode);
		}
		System.out.println();
	}

	public void DFS(int i) {
		// Create array to flag nodes as visited to avoid loop
		boolean visited[] = new boolean[adjacenctEdges.size()];

		// Visit the starting node
		DFSTraversal(i, visited);
	}

	private void DFSTraversal(int i, boolean[] visited) {
		// Mark the current node as visited
		visited[i] = true;
		System.out.print(" -> " + i);

		// Get connected vertices for the current node
		ArrayList<Integer> vertices = adjacenctEdges.get(i);

		// While there are vertices to visit
		while (vertices != null && vertices.size() > 0) {
			// Get next connected node and remove from list to visit
			int next = vertices.get(0);
			vertices.remove(0);

			// If not visited, visit the next connected node by depth
			if (visited[next] != true) {
				DFSTraversal(next, visited);
			}
		}
		System.out.println();
	}

}
