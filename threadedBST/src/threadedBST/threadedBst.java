package threadedBST;

import java.util.Scanner;


class Node {
    int data; // Node value
    Node left, right; // Left and right child pointers
    boolean leftThread, rightThread; // Flags to indicate threading

    // Constructor to initialize the node
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
        this.leftThread = this.rightThread = false;
    }
}

// Class to represent the Threaded Binary Tree
class ThreadedBinaryTree {
    private Node root; // Root of the tree

    // Method to insert a new node into the tree
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) { // If the tree is empty
            root = newNode;
            return;
        }

        Node parent = null;
        Node current = root;

        // Traverse the tree to find the correct position for the new node
        while (current != null) {
            parent = current;
            if (data < current.data) {
                if (!current.leftThread) {
                    current = current.left;
                } else {
                    break;
                }
            } else {
                if (!current.rightThread) {
                    current = current.right;
                } else {
                    break;
                }
            }
        }

        // Insert the new node as a child and update threading
        if (data < parent.data) {
            newNode.left = parent.left;
            newNode.right = parent;
            parent.leftThread = false;
            parent.left = newNode;
        } else {
            newNode.right = parent.right;
            newNode.left = parent;
            parent.rightThread = false;
            parent.right = newNode;
        }
    }

    // Method to perform in-order traversal of the tree
    public void inorder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        // Start from the leftmost node
        Node current = root;
        while (!current.leftThread) {
            current = current.left;
        }

        // Perform in-order traversal using threading
        while (current != null) {
            System.out.print(current.data + " ");
            if (current.rightThread) {
                current = current.right; // Move to in-order successor
            } else {
                current = current.right;
                while (current != null && !current.leftThread) {
                    current = current.left; // Move to the leftmost node in the right subtree
                }
            }
        }
        System.out.println();
    }
}

public class threadedBst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        ThreadedBinaryTree tbt = new ThreadedBinaryTree(); // Create a threaded binary tree object
        int choice, data;

        while (true) {
            // Display the menu
            System.out.println("Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Insert a new node
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    tbt.insert(data);
                    break;
                case 2: // Perform in-order traversal
                    tbt.inorder();
                    break;
                case 3: // Exit the program
                    scanner.close();
                    return;
                default: // Handle invalid input
                    System.out.println("Invalid choice. Please try again.");
            }
        }   
	}

}
