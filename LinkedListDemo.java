/* 
@author : Ankit Khatri,
@Title : Custom Implementation of LinkedList in Java,
#Instagram : @me_ankit_khatri,
#Twiiter : @me_ankit_khatri,
#Github : @khatri09
*/

public class LinkedListDemo {

    /* Structure class of the node */
    public static class Node {
        int data;
        Node next;
    }

    /* Custom Implementation of LinkedList */
    public static class LinkedList {

        // Data members
        private Node head;
        private Node tail;
        private int size;

        // Setting Default values to initiate LinkedList
        public LinkedList() {
            head = tail = null;
            size = 0;
        }

        /* Function to return the size of the List */
        public int size() {
            return size;
        }

        /* Function to add element at First in List */
        public void addFirst(int val) {
            Node node = new Node();
            node.data = val;

            // If List is empty, make node -> head else add Node before Head
            if (head == null) {
                node.next = null;
                head = node;
                tail = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        /* Function to add element at Last in List */
        public void addLast(int val) {
            Node node = new Node();
            node.data = val;
            node.next = null;

            tail.next = node;
            tail = node;

            size++;
        }

        /* Function to add element at specific index */
        public void addAt(int idx, int val) {
            if (idx < 0) {
                throw new IndexOutOfBoundsException("Index underflow in \"addAt(int idx, int val)\"");
            } else if (idx > size) {
                throw new IndexOutOfBoundsException("Index overflow in \"addAt(int idx, int val)\"");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                /* Finding given position to insert the Node */
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }

                /* Inserting the Node at given position */
                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }

        /* Function to return the element at First in List */
        public int getFirst() {
            if (head == null) {
                throw new RuntimeException("\"getFirst()\" operation is performed on Empty LinkedList");
            }
            return head.data;
        }

        /* Function to return the element at Last in List */
        public int getLast() {
            if (head == null) {
                throw new RuntimeException("\"getLast()\" is called on Empty LinkedList");
            }
            return tail.data;
        }

        /* Function to return the element at specific index */
        public int getAt(int idx) {
            if (head == null) {
                throw new RuntimeException("\"getAt()\" is called on Empty LinkedList");
            } else if (idx < 0) {
                throw new IndexOutOfBoundsException("Index underflow in \"getAt(int idx)\"");
            } else if (idx >= size) {
                throw new IndexOutOfBoundsException("Index overflow in \"getAt(int idx)\"");
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        /* Function to remove the element at First in List */
        public void removeFirst() {
            if (head == null) {
                throw new RuntimeException("\"removeFirst()\" is called on Empty LinkedList");
            }
            head = head.next;
            size--;
        }

        /* Function to remove the element at Last in List */
        public void removeLast() {
            if (head == null) {
                throw new RuntimeException("\"removeLast()\" is called on Empty LinkedList");
            } else if (head == tail) {
                head = tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            size--;
        }

        /* Function to remove element at specific index */
        public void removeAt(int idx) {
            if (head == null) {
                throw new RuntimeException("\"removeAt()\" is called on Empty LinkedList");
            } else if (idx < 0) {
                throw new IndexOutOfBoundsException("Index underflow in \"removeAt(int idx)\"");
            } else if (idx >= size) {
                throw new IndexOutOfBoundsException("Index overflow in \"removeAt(int idx)\"");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

        /* Function to Display the List */
        public void display() {
            Node temp = head;
            System.out.print("[ ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("]");
        }

        /* Helper Function to display the list in reverse using recursion */
        private void displayReverseHelper(Node node) {
            if (node == null) {
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
        }

        /* Function to display the list in reverse */
        public void displayReverse() {
            System.out.print("[ ");
            displayReverseHelper(head);
            System.out.println("]");
        }

        /* Helper Function to reverse the List using recursion */
        private void reverseHelper(Node node) {
            if (node == null) {
                return;
            }
            reverseHelper(node.next);
            if (node != tail) {
                node.next.next = node;
            }
        }

        /* Function to reverse the Actual List */
        public void reverse() {
            reverseHelper(head);
            /* Making head -> tail & tail -> head */
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }
    }

    /* Main Method to run the program */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst(10);
        list.addLast(30);
        list.addAt(1, 20);
        list.addAt(3, 40);

        list.display();
        System.out.println("Size = " + list.size());

        list.reverse();

        list.display();

        list.removeAt(1);

        list.display();
        System.out.println("Size = " + list.size());
        list.displayReverse();
    }
}
