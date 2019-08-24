package hackerrank;

import java.util.Scanner;

/**
 * Program to find the middle element of the linked list
 * 
 * @author Vinamra
 *
 */

class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

public class MiddleElement {

	static int count = 0;
	static Node head = null;

	public Node insertAtBeginning(int data) {

		Node temp = head;
		Node newNode = new Node(data);

		if (temp == null) {
			temp = newNode;
		} else {
			newNode.next = temp;
			temp = newNode;
		}
		count++;
		return temp;
	}

	public Node insertAtLast(int data) {
		Node start = head;
		Node newNode = new Node(data);

		if (start == null) {
			start = newNode;
		} else if (start.next == null) {
			start.next = newNode;
		} else {
			Node temp = start;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		count++;
		return start;
	}

	public int findMiddle() {

		Node temp = head;
		int counter = 0, midPosition = (int) Math.ceil(count / 2);

		while (counter != midPosition) {
			counter++;
			temp = temp.next;
		}

		return temp.data;
	}

	public void displayList() {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();

	}

	void loadElementsIntoLinkedList(int[] list) {

		for (int iterator : list) {

			head = insertAtLast(iterator);
		}

	}

	public static void main(String... args) {

		MiddleElement middleElement = new MiddleElement();

		Scanner scan = new Scanner(System.in);

		int sizeList = scan.nextInt();

		int[] numbers = new int[sizeList];

		for (int i = 0; i < sizeList; i++) {
			numbers[i] = scan.nextInt();
		}

		middleElement.loadElementsIntoLinkedList(numbers);

		System.out.println(middleElement.findMiddle());

		scan.close();
	}
}
