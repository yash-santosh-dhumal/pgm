package pizzaparlour;

import java.util.Scanner;

public class PizzaParlour {
	
	private int front, rear, size;
    private int[] queue;

    public PizzaParlour(int N) {
        size = N;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void placeOrder(int order) {
        if (isFull()) {
            System.out.println("Order queue is full. Cannot place more orders.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = order;
            System.out.println("Order " + order + " placed.");
        }
    }

    public void serveOrder() {
        if (isEmpty()) {
            System.out.println("No orders to serve.");
        } else {
            System.out.println("Order " + queue[front] + " served.");
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
        }
    }

    public void displayOrders() {
        if (isEmpty()) {
            System.out.println("No pending orders.");
        } else {
            System.out.print("Current orders: ");
            int i = front;
            while (i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % size;
            }
            System.out.println(queue[rear]);
        }
    }

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter maximum number of orders (N): ");
	        int N = scanner.nextInt();
	        PizzaParlour pizzaParlour = new PizzaParlour(N);

	        int choice;
	        do {
	            System.out.println("\nMenu: ");
	            System.out.println("1. Place Order");
	            System.out.println("2. Serve Order");
	            System.out.println("3. Display Orders");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter order number: ");
	                    int order = scanner.nextInt();
	                    pizzaParlour.placeOrder(order);
	                    break;
	                case 2:
	                    pizzaParlour.serveOrder();
	                    break;
	                case 3:
	                    pizzaParlour.displayOrders();
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please choose again.");
	            }
	        } while (choice != 4);

	        scanner.close();

	}

}
