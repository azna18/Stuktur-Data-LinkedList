import java.util.Scanner;

public class LinkedList1 {
    static Scanner input = new Scanner(System.in);
    static class Node {
        String nim;
        String name;
        Node next;

        Node(String nim, String name) {
            this.nim = nim;
            this.name = name;
            this.next = null;
        }
    }

    static Node head = null;
    static int size = 0;
    static final int MAX = 10;

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            System.out.print("SELECT MENU (Pilih menu): ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1 -> insertAtBeginning();
                    case 2 -> insertAtPosition();
                    case 3 -> insertAtEnd();
                    case 4 -> deleteAtBeginning();
                    case 5 -> deleteAtPosition();
                    case 6 -> deleteAtEnd();
                    case 7 -> deleteFirst();
                    case 8 -> showData();
                    case 9 -> System.out.println("PROGRAM COMPLETED.");
                    default -> System.out.println("INVALID MENU!");
                }
            } else {
                System.out.println("INVALID INPUT! ENTER NUMBER 1-9.");
                input.nextLine();
                choice = 0;
            }

        } while (choice != 9);
    }

    static void menu() {
        System.out.println("\n=== STUDENT LINKED LIST MENU ===");
        System.out.println("1. Insert at beginning");
        System.out.println("2. Insert at given position");
        System.out.println("3. Insert at end");
        System.out.println("4. Delete from beginning");
        System.out.println("5. Delete given position");
        System.out.println("6. Delete from end");
        System.out.println("7. Delete first occurrence");
        System.out.println("8. Show data");
        System.out.println("9. Exit");
    }

    static void insertAtBeginning() {
        if (size == 10) {
            System.out.println("DATA FULL!");
            return;
        }
        System.out.print("ENTER NIM: ");
        String nim = input.nextLine();
        System.out.print("ENTER NAME: ");
        String name = input.nextLine();

        Node newNode = new Node(nim, name);
        newNode.next = head;
        head = newNode;

        size++;
    }

    static void insertAtEnd() {
        if (size == MAX) {
            System.out.println("DATA FULL!");
            return;
        }
        System.out.print("ENTER NIM: ");
        String nim = input.nextLine();
        System.out.print("ENTER NAME: ");
        String name = input.nextLine();

        Node newNode = new Node(nim, name);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    static void insertAtPosition() {
        if (size == MAX) {
            System.out.println("DATA FULL!");
            return;
        }
        System.out.print("ENTER POSITION (1-" + (size + 1) + "): ");
        int pos = input.nextInt();
        input.nextLine();

        if (pos < 1 || pos > size + 1) {
            System.out.println("INVALID POSITION!");
            return;
        }
        if (pos == 1) {
            insertAtBeginning();
            return;
        }
        System.out.print("ENTER NIM: ");
        String nim = input.nextLine();
        System.out.print("ENTER NAME: ");
        String name = input.nextLine();

        Node newNode = new Node(nim, name);

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    static void deleteAtBeginning() {
        if (size == 0) {
            System.out.println("EMPTY DATA!");
            return;
        }
        head = head.next;
        size--;
    }

    static void deleteAtEnd() {
        if (size == 0) {
            System.out.println("EMPTY DATA!");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
    }

    static void deleteAtPosition() {
        if (size == 0) {
            System.out.println("EMPTY DATA!");
            return;
        }
        System.out.print("ENTER POSITION (1-" + size + "): ");
        int pos = input.nextInt();

        if (pos < 1 || pos > size) {
            System.out.println("INVALID POSITION!");
            return;
        }
        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    static void deleteFirst() {
        deleteAtBeginning();
    }

    static void showData() {
        if (size == 0) {
            System.out.println("EMPTY DATA!");
            return;
        }
        System.out.println("\n=== STUDENT DATA ===");
        Node temp = head;
        int i = 1;

        while (temp != null) {
            System.out.println(i + ". NIM: " + temp.nim + " | Name: " + temp.name);
            temp = temp.next;
            i++;
        }
    }
}
