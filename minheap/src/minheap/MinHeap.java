package minheap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinHeap {
	
    private PriorityQueue<Integer> minHeap;
    

    public MinHeap() {
        minHeap = new PriorityQueue<>();
        
    }

    public void addMarks(int marks) {
        minHeap.add(marks);
    }

    public int getMinMarks() {
        return minHeap.peek();
    }

	public static void main(String[] args) {
		MinHeap marksHeap = new MinHeap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = scanner.nextInt();

        System.out.println("Enter the marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            int marks = scanner.nextInt();
            marksHeap.addMarks(marks);
        }

        System.out.println("Minimum marks obtained: " + marksHeap.getMinMarks());
	}

}
