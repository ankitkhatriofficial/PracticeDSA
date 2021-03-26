import java.util.*;

/* Structure of the Node of generic tree */
class Node {
    public int data;
    public ArrayList<Node> children;

    public Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class GenericTreeDemo {

    /* Root of the Generic Tree */
    public static Node root;

    /* This function will construct the generic tree with given inputs */
    public void constructTree(int[] input) {
        /* If the input is empty => do nothing */
        if (input == null || input.length == 0)
            return;

        System.out.println("Constructing the Generic Tree..!");
        /* Create a stack to store the previous node */
        Stack<Node> st = new Stack<>();
        for (int val : input) {
            /* if the stack size is zero => create root */
            if (st.size() == 0) {
                root = new Node(val);
                st.push(root);
            }
            /* If input is -1 => pop out from stack */
            else if (val == -1) {
                st.pop();
            }
            /*
             * create a node with given input and make it the child of stack's peek node and
             * then push the node into the stack
             */
            else {
                Node peek = st.peek();
                Node child = new Node(val);
                peek.children.add(child);
                st.push(child);
            }
        }
        System.out.println("Generic tree constucted successfully..!");
    }

    /* This function is to display the generic tree */
    public void display(Node root) {
        /* if the root of the tree is null -> do nothing */
        if (root == null)
            return;

        String str = root.data + " -> ";
        for (Node child : root.children) {
            str += child.data + ", ";
        }
        /* Printing the data(root) and data(root.children) */
        System.out.println(str + ".");

        /* recursive call for the each child of the root */
        for (Node child : root.children)
            display(child);
    }

    /* function to return the size of the tree i.e no of nodes in thr tree */
    public int size(Node root) {
        /* if the root is null -> size = 0 */
        if (root == null)
            return 0;
        int size = 0;
        /*
         * find the size for each child of root via recursive call and find their
         * Summation
         */
        for (Node child : root.children) {
            size += size(child);
        }
        /* Add one extra to the size i.e the root node */
        return size + 1;
    }

    /* function to find the node which have the maximum value */
    public Node max(Node root) {
        /* If root of tree is null -> do nothing */
        if (root == null) {
            System.out.println("Generic Tree is Empty..!");
            return null;
        }

        /* create a new node with -Infinity value */
        Node max = new Node(Integer.MIN_VALUE);
        /* Iterate through all the child of root */
        for (Node child : root.children) {
            /* Find out the max of each child of root via recursive call */
            Node cmax = max(child);
            /* If maximum found, update the max Node */
            if (cmax.data > max.data)
                max = cmax;
        }
        /* return the maximum of root node and the maximum of all the child nodes */
        return (max.data > root.data ? max : root);
    }

    /* function to find the node which have the minimum value */
    public Node min(Node root) {
        /* If root of tree is null -> do nothing */
        if (root == null) {
            System.out.println("Generic Tree is Empty..!");
            return null;
        }

        /* create a new node with +Infinity value */
        Node min = new Node(Integer.MAX_VALUE);
        /* Iterate through all the child of root */
        for (Node child : root.children) {
            /* Find out the max of each child of root via recursive call */
            Node cmax = min(child);
            /* If minimum found, update the min Node */
            if (cmax.data < min.data)
                min = cmax;
        }
        /* return the minimum of root node and the minimum of all the child nodes */
        return (min.data < root.data ? min : root);
    }

    /* This function will return the height of the generic tree */
    public int height(Node root) {
        if (root == null) {
            System.out.println("Generic Tree is Empty..!");
            return 0;
        }
        int height = -1;
        for (Node child : root.children) {
            height = Math.max(height, height(child));
        }
        return (height + 1);
    }

    public static void main(String[] args) {
        /* Object of GenericTreeDemo class */
        GenericTreeDemo gt = new GenericTreeDemo();
        /* input */
        int[] inputs = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };

        /* Constructing the generic tree */
        gt.constructTree(inputs);

        /* displaying the generic tree */
        System.out.println("Displaying the generic tree");
        gt.display(root);

        /* Printing the root node and its value */
        System.out.println("Root node is ==> " + root + " -> " + root.data);

        /* Finding the Size of the generic tree */
        int size = gt.size(root);
        System.out.println("The size of the tree is ==> " + size);

        /* Finding the node of maximum value */
        Node max = gt.max(root);
        System.out.println("Maximum node is ==> " + max + " -> " + max.data);

        /* Finding the node of minimum value */
        Node min = gt.min(root);
        System.out.println("Minimum node is ==> " + min + " -> " + min.data);

        /* Finding the height of the generic tree */
        int height = gt.height(root);
        System.out.println("The height of the tree is ==> " + height);
    }
}
