import java.util.Scanner;

public class LinkedList1 {

    static class Node {
        String nim, name;
        int order;
        Node next;

        Node(String nim, String name, int order) {
            this.nim = nim;
            this.name = name;
            this.order = order;
        }
    }

    static Node head = null;
    static int size = 0;
    static int counter = 0;
    static final int MAX = 10;
    static Scanner input = new Scanner(System.in);

    static void menu() {
        System.out.println("\n=== STUDENT MENU ===");
        System.out.println("1. Insert at beginning");
        System.out.println("2. Insert at given position");
        System.out.println("3. Insert at end");
        System.out.println("4. Delete from beginning");
        System.out.println("5. Delete given position");
        System.out.println("6. Delete from end");
        System.out.println("7. Delete first occurence");
        System.out.println("8. Show data");
        System.out.println("9. Exit");
    }

    static String inputNIM() {
        while (true) {
            System.out.print("ENTER NIM: ");
            String nim = input.nextLine();
            if (nim.matches("\\d+")) return nim;
            System.out.println("NIM MUST BE NUMBERS ONLY!");
        }
    }

    static String inputName() {
        while (true) {
            System.out.print("ENTER NAME: ");
            String name = input.nextLine();
            if (name.matches("[a-zA-Z ]+")) return name;
            System.out.println("NAME MUST BE LETTERS ONLY!");
        }
    }

    static Node createNode() {
        if (size == MAX) {
            System.out.println("DATA IS FULL!");
            return null;
        }
        counter++;
        return new Node(inputNIM(), inputName(), counter);
    }

    static void insertAtBeginning() {
        Node newNode = createNode();
        if (newNode == null) return;

        newNode.next = head;
        head = newNode;
        size++;
    }

    static void insertAtEnd() {
        Node newNode = createNode();
        if (newNode == null) return;

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    static void insertAtPosition() {
        if (size == MAX) {
            System.out.println("DATA IS FULL!");
            return;
        }

        System.out.print("ENTER POSITION (1-" + (size + 1) + "): ");
        if (!input.hasNextInt()) {
            System.out.println("POSITION MUST BE NUMBER!");
            input.nextLine();
            return;
        }

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

        Node newNode = createNode();
        if (newNode == null) return;

        Node temp = head;
        for (int i = 1; i < pos - 1; i++)
            temp = temp.next;

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
            while (temp.next.next != null)
                temp = temp.next;
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
        if (!input.hasNextInt()) {
            System.out.println("POSITION MUST BE NUMBER!");
            input.nextLine();
            return;
        }

        int pos = input.nextInt();
        input.nextLine();

        if (pos < 1 || pos > size) {
            System.out.println("INVALID POSITION!");
            return;
        }
        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++)
            temp = temp.next;

        temp.next = temp.next.next;
        size--;
    }

    static void deleteFirstInserted() {
        if (size == 0) {
            System.out.println("EMPTY DATA!");
            return;
        }

        Node temp = head;
        Node prev = null;
        Node target = head;
        Node targetPrev = null;

        int smallest = head.order;

        while (temp != null) {
            if (temp.order < smallest) {
                smallest = temp.order;
                target = temp;
                targetPrev = prev;
            }
            prev = temp;
            temp = temp.next;
        }

        if (targetPrev == null)
            head = target.next;
        else
            targetPrev.next = target.next;

        size--;
        System.out.println("FIRST INSERTED DATA DELETED.");
    }

    static void showData() {
        if (size == 0) {
            System.out.println("EMPTY DATA!");
            return;
        }

        Node temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println(i + ". NIM: " + temp.nim + " | Name: " + temp.name);
            temp = temp.next;
            i++;
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            menu();
            System.out.print("SELECT MENU: ");

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
                    case 7 -> deleteFirstInserted();
                    case 8 -> showData();
                    case 9 -> System.out.println("PROGRAM COMPLETED.");
                    default -> System.out.println("INVALID MENU!");
                }
            } else {
                System.out.println("INPUT MUST BE NUMBER!");
                input.nextLine();
                choice = 0;
            }

        } while (choice != 9);
    }
}
