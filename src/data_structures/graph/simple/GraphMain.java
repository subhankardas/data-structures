package data_structures.graph.simple;

public class GraphMain {

	public static void main(String[] args) {
		adjacencyGraphFunctions();
	}

	public static void adjacencyGraphFunctions() {
		AdjacencyGraph graph = new AdjacencyGraph(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.print();
		
		System.out.print("BFS:");
		graph.BFS(2);
		
		System.out.print("DFS:");
		graph.DFS(2);
	}

}
