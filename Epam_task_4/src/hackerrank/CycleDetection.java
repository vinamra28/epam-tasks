package hackerrank;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Vinamra
 *
 *         Question URL :-
 *         https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 */

public class CycleDetection {

	static class Node {
		public int data;
		public Node next;

		public Node(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public Node head;
		public Node tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			Node node = new Node(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(Node node, String sep, BufferedWriter bufferedWriter) throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the hasCycle function below.

	/*
	 * For your reference:
	 *
	 * Node { int data; Node next; }
	 *
	 */
	static boolean hasCycle(Node head) {

		if (head == null) {
			return false;
		}

		Node current = head;
		Node temp = current;
		while (temp != null && temp.next != null) {
			current = current.next;
			temp = temp.next.next;
			if (current == temp) {
				return true;
			}
		}
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			Node extra = new Node(-1);
			Node temp = llist.head;

			for (int i = 0; i < llistCount; i++) {
				if (i == index) {
					extra = temp;
				}

				if (i != llistCount - 1) {
					temp = temp.next;
				}
			}

			temp.next = extra;

			boolean result = hasCycle(llist.head);

			System.out.println(String.valueOf(result ? 1 : 0));
		}

		scanner.close();
	}

}
