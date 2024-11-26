package dijkstraalgo;

import java.util.*;

class CourierService {

    private int vertices;
    private int[][] adjMatrix;

    public CourierService(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }
    }

    public void addRoad(int source, int destination, int distance) {
        adjMatrix[source][destination] = distance;
        adjMatrix[destination][source] = distance;
    }

    public void dijkstra(int startVertex) {
        boolean[] visited = new boolean[vertices];
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < vertices; i++) {
            int u = getMinimumDistanceVertex(visited, distances);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && adjMatrix[u][v] != Integer.MAX_VALUE && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + adjMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjMatrix[u][v];
                }
            }
        }

        printSolution(distances, startVertex);
    }

    private int getMinimumDistanceVertex(boolean[] visited, int[] distances) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && distances[v] < minDistance) {
                minDistance = distances[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void printSolution(int[] distances, int startVertex) {
        System.out.println("Shortest distances from location " + startVertex + ":");
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("To location " + i + " - Distance: INF");
            } else {
                System.out.println("To location " + i + " - Distance: " + distances[i]);
            }
        }
    }
}

public class dijkstraAlgorithm {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        CourierService service = null;
        int choice;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create City Map");
            System.out.println("2. Add Road");
            System.out.println("3. Find Shortest Path (Dijkstra)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of locations: ");
                    int locations = scanner.nextInt();
                    service = new CourierService(locations);

                    System.out.println("City map created with " + locations + " locations.");
                    break;

                case 2:
                    if (service == null) {
                        System.out.println("City map not created yet.");
                        break;
                    }
                    System.out.print("Enter source location, destination location, and distance: ");
                    int source = scanner.nextInt();
                    int destination = scanner.nextInt();
                    int distance = scanner.nextInt();
                    service.addRoad(source, destination, distance);
                    System.out.println("Road added.");
                    break;

                case 3:
                    if (service == null) {
                        System.out.println("City map not created yet.");
                        break;
                    }
                    System.out.print("Enter starting location: ");
                    int startLocation = scanner.nextInt();
                    service.dijkstra(startLocation);
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
