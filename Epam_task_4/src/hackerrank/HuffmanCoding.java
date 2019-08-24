package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author Vinamra
 *
 *         Question URL :-
 *         https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 */

abstract class NodeHuff implements Comparable<NodeHuff> {
	public int frequency; // the frequency of this tree
	public char data;
	public NodeHuff left, right;

	public NodeHuff(int freq) {
		frequency = freq;
	}

	public int compareTo(NodeHuff tree) {
		return frequency - tree.frequency;
	}
}

class HuffmanLeaf extends NodeHuff {

	public HuffmanLeaf(int freq, char val) {
		super(freq);
		data = val;
	}
}

class HuffmanNode extends NodeHuff {

	public HuffmanNode(NodeHuff l, NodeHuff r) {
		super(l.frequency + r.frequency);
		left = l;
		right = r;
	}

}

class Decoding {

	void decode(String s, NodeHuff root) {
		StringBuilder result = new StringBuilder();
		NodeHuff curr = root;
		for (char ch : s.toCharArray()) {
			curr = ch == '0' ? curr.left : curr.right;
			if (curr.data != '\0') {
				result.append(curr.data);
				curr = root;
			}
		}
		System.out.println(result);
	}

}

public class HuffmanCoding {

	public static NodeHuff buildTree(int[] charFreqs) {

		PriorityQueue<NodeHuff> trees = new PriorityQueue<NodeHuff>();

		for (int i = 0; i < charFreqs.length; i++)
			if (charFreqs[i] > 0)
				trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

		assert trees.size() > 0;

		while (trees.size() > 1) {

			NodeHuff a = trees.poll();
			NodeHuff b = trees.poll();

			// put into new node and re-insert into queue
			trees.offer(new HuffmanNode(a, b));
		}

		return trees.poll();
	}

	public static Map<Character, String> mapA = new HashMap<Character, String>();

	public static void printCodes(NodeHuff tree, StringBuffer prefix) {

		assert tree != null;

		if (tree instanceof HuffmanLeaf) {
			HuffmanLeaf leaf = (HuffmanLeaf) tree;

			mapA.put(leaf.data, prefix.toString());

		} else if (tree instanceof HuffmanNode) {
			HuffmanNode node = (HuffmanNode) tree;

			prefix.append('0');
			printCodes(node.left, prefix);
			prefix.deleteCharAt(prefix.length() - 1);

			prefix.append('1');
			printCodes(node.right, prefix);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String test = input.next();

		int[] charFreqs = new int[256];

		for (char c : test.toCharArray())
			charFreqs[c]++;

		NodeHuff tree = buildTree(charFreqs);

		printCodes(tree, new StringBuffer());
		StringBuffer s = new StringBuffer();

		for (int i = 0; i < test.length(); i++) {
			char c = test.charAt(i);
			s.append(mapA.get(c));
		}

		Decoding d = new Decoding();
		d.decode(s.toString(), tree);

		input.close();

	}

}
