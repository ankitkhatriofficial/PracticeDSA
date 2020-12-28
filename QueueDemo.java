/* 
@author : Ankit Khatri,
@Title : Custom Implementation of Queue in Java,
#Instagram : @me_ankit_khatri,
#Twiiter : @me_ankit_khatri,
#Github : @khatri09
*/

public class QueueDemo {

    /* Custom Implementation of Queue */
    public static class Queue {

        // Data Members
        int front, size;
        int[] data;

        // Setting Default values to initiate Queue
        public Queue() {
            front = size = 0;
            data = new int[5];
        }

        /* Function to return the size of Queue */
        public int size() {
            return size;
        }

        /* Add function in Queue */
        public void add(int val) {
            /*
             * If array is full, then create another array and copy all the data and then
             * add the element & set the refernce of new array to old one.
             */
            if (size == data.length) {
                int[] newData = new int[2 * data.length];
                for (int i = 0; i < size; i++) {
                    int idx = (front + i) % data.length;
                    newData[i] = data[idx];
                }
                front = 0;
                newData[size] = val;
                data = newData;
                size++;
            } else {
                int idx = (front + size) % data.length;
                data[idx] = val;
                size++;
            }
        }

        /* remove function in Queue */
        public int remove() {
            if (size == 0) {
                throw new RuntimeException("Queue underflow");
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        /* peek function in Queue */
        public int peek() {
            if (size == 0) {
                throw new RuntimeException("Queue underflow");
            } else {
                return data[front];
            }
        }

        /* Custom Implementation of toString method to display Queue */
        public String toString() {
            StringBuilder res = new StringBuilder("[ ");
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                res.append(data[idx] + " ");
            }
            res.append("]");
            return res.toString();
        }
    }

    /* Main Method to run the program */
    public static void main(String[] args) {

        Queue queue = new Queue();
        System.out.println(queue);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
    }
}
