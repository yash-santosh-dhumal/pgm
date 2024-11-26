package infixtopostfix;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
	
	public static int precedence(char ch) {
        switch (ch) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    
    public static String InfixToPostfix(String expression) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the scanned character is an operand, add it to result
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }
            // If the scanned character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is ')', pop and append until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); // Remove the '(' from the stack
            }
            // If an operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu: ");
            System.out.println("1. Convert Infix to Postfix");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter an infix expression: ");
                    String infixExpression = scanner.nextLine();
                    String postfixExpression = InfixToPostfix(infixExpression);
                    System.out.println("Postfix Expression: " + postfixExpression);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
                    break;
            }

        } while (choice != 2);

        scanner.close();

	}

}
