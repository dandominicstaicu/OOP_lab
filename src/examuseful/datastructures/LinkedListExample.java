package examuseful.datastructures;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head; // head of the list

    // Method to insert a new node
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to delete a node at a given position
    public void deleteAtPosition(int position) {
        if (head == null) {
            return;
        }
        Node temp = head;
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }
        // Find the key to be deleted
        for (int i=0; temp!=null && i<position-1; i++) {
            temp = temp.next;
        }
        // If the key is not present
        if (temp == null || temp.next == null) {
            return;
        }
        // Remove the node
        Node next = temp.next.next;
        temp.next = next;
    }

    // Method to print the LinkedList.
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(7);
        list.insert(1);
        list.insert(3);
        list.insert(2);

        System.out.println("Created Linked list is:");
        list.printList();

        list.deleteAtPosition(1); // Delete node at position 1

        System.out.println("\nLinked List after Deletion at position 1:");
        list.printList();
    }
}

