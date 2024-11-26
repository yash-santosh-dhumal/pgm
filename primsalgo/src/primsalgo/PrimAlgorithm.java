package primsalgo;

import java.util.*;

class Edge {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int vertices;
    List<Edge> edges;

    Graph(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    void primMST() {
        boolean[] inMST = new boolean[vertices];
        Edge[] result = new Edge[vertices - 1];
        int edgeCount = 0;
        int totalCost = 0;
        inMST[0] = true;

        while (edgeCount < vertices - 1) {
            int minWeight = Integer.MAX_VALUE;
            Edge minEdge = null;

            for (Edge edge : edges) {
                if (inMST[edge.source] != inMST[edge.destination]) {
                    if (edge.weight < minWeight) {
                        minWeight = edge.weight;
                        minEdge = edge;
                    }
                }
            }

            if (minEdge != null) {
                result[edgeCount++] = minEdge;
                totalCost += minEdge.weight;
                inMST[minEdge.source] = true;
                inMST[minEdge.destination] = true;
            }
        }

        System.out.println("Minimum Spanning Tree edges:");
        for (Edge edge : result) {
            System.out.println("City " + edge.source + " - City " + edge.destination + " : " + edge.weight);
        }
        System.out.println("Total cost: " + totalCost);
    }
}
public class PrimAlgorithm {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        Graph graph = null;
	        int choice;

	        while (true) {
	            System.out.println("Menu:");
	            System.out.println("1. Create Graph");
	            System.out.println("2. Add Edge");
	            System.out.println("3. Calculate Minimum Spanning Tree (MST)");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter number of cities: ");
	                    int cities = scanner.nextInt();
	                    graph = new Graph(cities);
	                    System.out.println("Graph created with " + cities + " cities.");
	                    break;

	                case 2:
	                    if (graph == null) {
	                        System.out.println("Graph not created yet.");
	                        break;
	                    }
	                    System.out.print("Enter source city, destination city, and weight: ");
	                    int source = scanner.nextInt();
	                    int destination = scanner.nextInt();
	                    int weight = scanner.nextInt();
	                    graph.addEdge(source, destination, weight);
	                    System.out.println("Edge added.");
	                    break;

	                case 3:
	                    if (graph == null) {
	                        System.out.println("Graph not created yet.");
	                        break;
	                    }
	                    graph.primMST();
	                    break;

	                case 4:
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	}

}
