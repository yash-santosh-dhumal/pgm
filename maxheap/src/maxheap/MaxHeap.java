package maxheap;

import java.util.*;

public class MaxHeap {
	
	
	    private PriorityQueue<Integer> maxHeap;

	    public MaxHeap() {
	      
	        maxHeap = new PriorityQueue<>((a, b) -> b - a);
	    }

	    public void addMarks(int marks) {
	        
	        maxHeap.add(marks);
	    }

	    public int getMaxMarks() {
	        return maxHeap.peek();
	    }


	public static void main(String[] args) {
		  MaxHeap marksHeap = new MaxHeap();
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the number of students: ");
	        int n = scanner.nextInt();

	        System.out.println("Enter the marks of " + n + " students:");
	        for (int i = 0; i < n; i++) {
	            int marks = scanner.nextInt();
	            marksHeap.addMarks(marks);
	        }

	        System.out.println("Maximum marks obtained: " + marksHeap.getMaxMarks());
	       
	    }
	}


