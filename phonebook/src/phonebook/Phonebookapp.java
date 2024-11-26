package phonebook;

import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

class TreeNode {
    Contact contact;
    TreeNode left, right;

    public TreeNode(Contact contact) {
        this.contact = contact;
        this.left = this.right = null;
    }
}

class PhoneBook {
    private TreeNode root;

    public PhoneBook() {
        this.root = null;
    }

    public void insert(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        root = insertRec(root, newContact);
        System.out.println("Contact added: " + newContact);
    }

    private TreeNode insertRec(TreeNode root, Contact contact) {
        if (root == null) {
            return new TreeNode(contact);
        }

        if (contact.phoneNumber.compareTo(root.contact.phoneNumber) < 0) {
            root.left = insertRec(root.left, contact);
        } else if (contact.phoneNumber.compareTo(root.contact.phoneNumber) > 0) {
            root.right = insertRec(root.right, contact);
        } else {
            System.out.println("Contact with phone number " + contact.phoneNumber + " already exists.");
        }
        return root;
    }

    public void search(String phoneNumber) {
        TreeNode result = searchRec(root, phoneNumber);
        if (result != null) {
            System.out.println("Contact found: " + result.contact);
        } else {
            System.out.println("Contact with phone number " + phoneNumber + " not found.");
        }
    }

    private TreeNode searchRec(TreeNode root, String phoneNumber) {
        if (root == null || root.contact.phoneNumber.equals(phoneNumber)) {
            return root;
        }

        if (phoneNumber.compareTo(root.contact.phoneNumber) < 0) {
            return searchRec(root.left, phoneNumber);
        }
        return searchRec(root.right, phoneNumber);
    }

    public void update(String phoneNumber, String newName) {
        TreeNode result = searchRec(root, phoneNumber);
        if (result != null) {
            result.contact.name = newName;
            System.out.println("Contact updated: " + result.contact);
        } else {
            System.out.println("Contact with phone number " + phoneNumber + " not found.");
        }
    }

    public void delete(String phoneNumber) {
        root = deleteRec(root, phoneNumber);
    }

    private TreeNode deleteRec(TreeNode root, String phoneNumber) {
        if (root == null) {
            System.out.println("Contact with phone number " + phoneNumber + " not found.");
            return root;
        }

        if (phoneNumber.compareTo(root.contact.phoneNumber) < 0) {
            root.left = deleteRec(root.left, phoneNumber);
        } else if (phoneNumber.compareTo(root.contact.phoneNumber) > 0) {
            root.right = deleteRec(root.right, phoneNumber);
        } else {
            if (root.left == null) {
                System.out.println("Contact deleted: " + root.contact);
                return root.right;
            } else if (root.right == null) {
                System.out.println("Contact deleted: " + root.contact);
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.contact = minNode.contact;
            root.right = deleteRec(root.right, minNode.contact.phoneNumber);
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void displayContacts() {
        if (root == null) {
            System.out.println("No contacts in phone book.");
        } else {
            System.out.println("Contacts in phone book:");
            inorderTraversal(root);
        }
    }

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.contact);
            inorderTraversal(root.right);
        }
    }
}

public class Phonebookapp {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        int choice;

        do {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.insert(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter phone number to search: ");
                    phoneNumber = scanner.nextLine();
                    phoneBook.search(phoneNumber);
                    break;
                case 3:
                    System.out.print("Enter phone number to update: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    phoneBook.update(phoneNumber, name);
                    break;
                case 4:
                    System.out.print("Enter phone number to delete: ");
                    phoneNumber = scanner.nextLine();
                    phoneBook.delete(phoneNumber);
                    break;
                case 5:
                    phoneBook.displayContacts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
	}

}
