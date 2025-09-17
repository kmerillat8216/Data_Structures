/*
 * QueueCharArray.java
 * fall 2025
 * Karissa.Merillat
 * prof. lehman
 * 
 * Queue approach has first and last point
 * to first and last elements in array.
 * The variable size is used to denote
 * an empty vs. full queue
 */
public class QueueCharArray {

	// data
	private char data[];
	private int front;
	private int back;
	private int size;
	private int MAX;

	// default constructor
	public QueueCharArray() {
		this(5);

	}

	// alternate constructor
	public QueueCharArray(int max) {
		MAX = max;
		data = new char[MAX];
		front = 0;
		back = -1;
		size = 0;
	}

	// delete all items in queue
	public void clear() {
		front = 0;
		back = -1;
		size = 0;
	}

	// add to back of queue
	public void add(char v) {
		if (full()) {
			System.out.println("Queue is full. Cannot add '" + v + "'.");
			return;
		}
		back = (back + 1) % MAX;
		data[back] = v;
		size++;
	}

	// see if queue is empty
	public boolean empty() {
		return size == 0;
	}

	// see if queue is full
	public boolean full() {
		return size == MAX;
	}

	// return element from front of queue
	public char front() {
		if (empty()) {
			return '?';
		}
		return data[front];
	}

	// remove element from front of queue
	public boolean remove() {
		if (empty()) {
			System.out.println("Queue is empty. Nothing to remove.");
			return false;
		}
		front = (front + 1) % MAX;
		size--;
		return true;
	}

	public int size() {
		return size;
	}

	 /**
     * use with println to display queue
     * 
     * @return set as a String
     */
    public String toString() {
		if (empty()) return "Queue is empty.";

		StringBuilder sb = new StringBuilder();
		sb.append("Queue: ");
		for (int i = 0; i < size; i++){
			int index = (front + i) % MAX;
			sb.append(data[index]).append(" ");
		}
	}
		return sb.toString();
}
}// class
