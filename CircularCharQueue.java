
import java.util.Random;


// CircularCharQueue.java
// fall 2025
// lehman

public class CircularCharQueue {

    // data
    private Node back;
    private int size;

    // constructor
    public CircularCharQueue() {
        back = null;
        size = 0;
    }

    // add item
    public void enqueue(char c) {
        // special case - empty queue
        if (back == null) {
            back = new Node();
            back.data = c;
            back.next = back;
            size++;
        } else {
            Node temp = new Node();
            temp.data = c;
            temp.next = back.next;
            back.next = temp;
            back = temp;
            size++;
        }

    }

    // remove item
    public void dequeue() {
        if (this.size == 1) {
            back = null;
            size = 0;
        } else if (back != null) {
            // System.out.println("in deq");
            Node temp = back.next;
            back.next = back.next.next;
            temp = null;
            size--;
        }
    }

    // is Empty?
    public boolean isEmpty() {
        return back == null;
    }

    // get front item (if it exists)
    public char front() {
        if (back != null) {
            return back.next.data;
        } else
            return '?';
    }

    // get back item (if it exists)
    public char back() {
        if (back != null) {
            return back.data;
        } else
            return '?';
    }

    // front item goes to back
    public void next() {
        if (back != null)
            back = back.next;
    }

    // get size
    public int size() {
        return size;
    }

    // *** add code for lab5 **
    // simulate "spinning" the queue so that
    // queue rotates a random number of times
    public void spin() {
        Random rand = new Random();
        int r = rand.nextInt(size);

        for(int x= 0; x <= r; x++) {
            this.next();
        }

        System.out.println("Spin value: " + r);

    }

    // ASCII version
    public String toString() {
        String result = "CQ: ";

        int count = 0;
        while (count < this.size) {
            result += this.front() + " ";

            this.next();

            count++;
        }
        return result;
    }

}// class