package stackusingLL;

import java.util.Scanner;

class StackusingLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public StackusingLL() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed " + data + " to the stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No elements to pop.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        Node currentNode = top;
        System.out.println("Stack elements:");
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}


public class stackusingLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackusingLL stack = new StackusingLL();
        Scanner scanner = new Scanner(System.in);
        int choice, element;

        do {
            System.out.println("\nStack Operations Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Check if Stack is Empty");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    element = stack.pop();
                    if (element != -1) {
                        System.out.println("Popped element: " + element);
                    }
                    break;
                case 3:
                    element = stack.peek();
                    if (element != -1) {
                        System.out.println("Top element: " + element);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
	}

}
