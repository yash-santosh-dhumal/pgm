package krusalgo;

import java.util.*;


class Edge implements Comparable<Edge> {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
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

    void kruskalMST() {
        Collections.sort(edges);

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;

        for (Edge edge : edges) {
            int rootSource = find(parent, edge.source);
            int rootDestination = find(parent, edge.destination);

            if (rootSource != rootDestination) {
                mst.add(edge);
                totalCost += edge.weight;
                union(parent, rootSource, rootDestination);
            }
        }

        System.out.println("Minimum Spanning Tree edges:");
        for (Edge edge : mst) {
            System.out.println("City " + edge.source + " - City " + edge.destination + " : " + edge.weight);
        }
        System.out.println("Total cost: " + totalCost);
    }

    int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    void union(int[] parent, int root1, int root2) {
        parent[root1] = root2;
    }
}

public class kruskalalgorithm {

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
                    graph.kruskalMST();
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
