/* 
@author : Ankit Khatri,
@Title : Custom Implementation of Stack in Java,
#Instagram : @me_ankit_khatri,
#Twiiter : @me_ankit_khatri,
#Github : @khatri09
*/

public class StackDemo {

    /* Custom Implementation of Stack */
    public static class Stack {

        // Data Members
        int tos; // tos -> top of the stack
        int[] data;

        // Setting Default values to initiate Stack
        public Stack() {
            tos = -1;
            data = new int[15];
        }

        /* Function to return the size of Stack */
        public int size() {
            return tos + 1;
        }

        /* Push function of Stack */
        public void push(int val) {
            /*
             * If array is full, then create another array and copy all the data and then
             * push the element & set the refernce of new array to old one.
             */
            if (tos == data.length - 1) {
                int[] newData = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }
                data = newData;
            }
            tos++;
            data[tos] = val;
        }

        /* Pop function of Stack */
        public int pop() {
            if (tos == -1) {
                throw new RuntimeException("Stack underflow");
            } else {
                return data[tos--];
            }
        }

        /* Top function of Stack */
        public int top() {
            if (tos == -1) {
                throw new RuntimeException("Stack underflow");
            } else {
                return data[tos];
            }
        }

        /* Custom Implementation of toString method to display Stack */
        public String toString() {
            StringBuilder res = new StringBuilder("[ ");
            for (int i = 0; i < tos + 1; i++) {
                res.append(data[i] + " ");
            }
            res.append("]");
            return res.toString();
        }
    }

    /* Main Method to run the program */
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);

        st.pop();
        System.out.println("Stack = " + st + " -->" + " size = " + st.size());

        st.pop();
        System.out.println("Stack = " + st + " -->" + " size = " + st.size());

        System.out.println(st.top());
        System.out.println("Stack = " + st + " -->" + " size = " + st.size());

        st.push(100);
        System.out.println(st);

    }
}
