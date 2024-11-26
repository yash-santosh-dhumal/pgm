package maxheap1;

import java.util.Scanner;

public class MaxHeap1 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        // Input: Number of students and their marks
	        System.out.print("Enter the number of students: ");
	        int n = scanner.nextInt();

	        if (n <= 0) {
	            System.out.println("Number of students must be greater than 0.");
	            return;
	        }

	        int[] marks = new int[n];
	        System.out.println("Enter the marks of the students:");

	        // Read marks and initialize min and max variables
	        
	        int maxMarks = Integer.MIN_VALUE;

	        for (int i = 0; i < n; i++) {
	            marks[i] = scanner.nextInt();
	           
	            if (marks[i] > maxMarks) {
	                maxMarks = marks[i]; // Update maximum marks
	            }
	        }

	        // Output
	       
	        System.out.println("Maximum marks: " + maxMarks);
	}

}
