import java.util.*;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

/*
 * [Structure of pair] Here state 1 means to add the new node into the left of
 * (pair.node) and state 2 means to add the new node into the right of
 * (pair.node) and state 3 means to pop out the pair from the stack.
 */
class Pair {
    Node node;
    int state;

    public Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class BinaryTreeDemo {

    /* Root of the Binary Tree */
    public static Node root;

    /* This function will construct the Binary tree with given inputs */
    public void constructTree(Integer[] input) {
        /* If the input is empty => do nothing */
        if (input == null || input.length == 0)
            return;

        System.out.println("Constructing the Binary Tree..!");
        /* Create a stack to store the previous node */
        Stack<Pair> st = new Stack<>();
        /* making the first node as root */
        root = new Node(input[0], null, null);
        /* Pushing the root with state 1 */
        st.push(new Pair(root, 1));

        /* starting the index from 1 onwards for input */
        int idx = 1;

        /* Repeat the process the until the stack is having element */
        while (st.size() > 0) {
            /* hold the peek of the stack */
            Pair peek = st.peek();
            /* check if peek == 1 i.e to insert the new node into the left of (pair.node) */
            if (peek.state == 1) {
                /* if input is null -> insert null to the left of (pair.node) */
                if (input[idx] == null) {
                    peek.node.left = null;
                } else {
                    /*
                     * insert the new node to the left of (pair.node) and push the new node with
                     * state 1 into the stack
                     */
                    peek.node.left = new Node(input[idx], null, null);
                    st.push(new Pair(peek.node.left, 1));
                }
                /*
                 * increment the index of the input and increment the peek that is holding (not
                 * the current peek of the stack)
                 */
                idx++;
                peek.state++;
            }
            /*
             * check if peek == 2 i.e to insert the new node into the right of (pair.node)
             */
            else if (peek.state == 2) {
                /* if input is null -> insert null to the right of (pair.node) */
                if (input[idx] == null) {
                    peek.node.right = null;
                } else {
                    /*
                     * insert the new node to the right of (pair.node) and push the new node with
                     * state 1 into the stack
                     */
                    peek.node.right = new Node(input[idx], null, null);
                    st.push(new Pair(peek.node.right, 1));
                }
                /*
                 * increment the index of the input and increment the peek that is holding (not
                 * the current peek of the stack)
                 */
                idx++;
                peek.state++;
            } else if (peek.state == 3) {
                /* pop the pair from the stack if the state changes to 3 */
                st.pop();
            }
        }
    }

    /* This function is to display the Binary tree */
    public void display(Node root) {
        /* Do nothing if the root node is null */
        if (root == null)
            return;

        String str = root.data + " -> ";
        str += root.left == null ? "." : root.left.data;
        str += ",";
        str += root.right == null ? "." : root.right.data;
        /* Printing the root and its left and right child's data */
        System.out.println(str);

        /* Recursive call for the root.left */
        display(root.left);
        /* Recursive call for the root.right */
        display(root.right);
    }

    public static void main(String[] args) {
        /* Object of GenericTreeDemo class */
        BinaryTreeDemo gt = new BinaryTreeDemo();
        /* input */
        Integer[] input = { 50, 25, 12, null, null, 37, 30, null, null, null, 62, null, 70, null, null, 87, null,
                null };

        gt.constructTree(input);
        gt.display(root);

    }
}
