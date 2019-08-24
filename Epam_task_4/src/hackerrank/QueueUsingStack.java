package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Vinamra
 *
 *         Question URL :-
 *         https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 */

public class QueueUsingStack {

	Stack<Integer> stk1 = new Stack<>();
	Stack<Integer> stk2 = new Stack<>();

	void enqueue(int number) {
		stk1.push(number);
	}

	Integer dequeue() {
		if (size() == 0) {
			return null;
		}
		if (stk2.isEmpty()) {
			shiftStacks();
		}
		return stk2.pop();
	}

	public void shiftStacks() {
		if (stk2.isEmpty()) {
			while (!stk1.isEmpty()) {
				stk2.push(stk1.pop());
			}
		}
	}

	public int size() {
		return stk1.size() + stk2.size();
	}

	void displayElement() {
		if (size() == 0) {
		}
		if (stk2.isEmpty()) {
			shiftStacks();
		}
		System.out.println(stk2.peek());
	}

	public static void main(String[] args) {

		System.out.println();

		Scanner scan = new Scanner(System.in);
		QueueUsingStack queueStacks = new QueueUsingStack();

		int queries = scan.nextInt();

		while (queries-- > 0) {
			int type = scan.nextInt();

			switch (type) {
			case 1:
				int x = Math.abs(scan.nextInt());
				queueStacks.enqueue(x);
				break;
			case 2:
				queueStacks.dequeue();
				break;
			case 3:
				queueStacks.displayElement();
				break;
			}

		}
		scan.close();

	}

}
