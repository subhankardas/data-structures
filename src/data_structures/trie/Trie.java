package data_structures.trie;

import java.util.Arrays;

/**
 * Trie is an efficient information reTrieval data structure. Using Trie, search
 * complexities can be brought to optimal limit (key length). If we store keys
 * in binary search tree, a well balanced BST will need time proportional to M *
 * log N, where M is maximum string length and N is number of keys in tree.
 * Using Trie, we can search the key in O(M) time. However the penalty is on
 * Trie storage requirements.
 * 
 * Applications: Auto-complete/word suggestions
 * 
 *   					root
 *                   /   \    \
 *                   t   a     b
 *                   |   |     |
 *                   h   n     y
 *                   |   |  \  |
 *                   e   s  y  e
 *                /  |   |
 *                i  r   w
 *                |  |   |
 *                r  e   e
 *                       |
 *                       r
 * 
 * Time complexity: Insert/search/delete = O(K)             [ K=Key length ]
 * Space complexity: O(ALPHABET_SIZE * K * N)               [ ALPHABET_SIZE=26, K=Key length, N=No. of keys in the trie ]
 */
public class Trie {

	static final int ALPHABET_SIZE = 26;
	static Node root;

	public class Node {
		// Possible nodes array for all 26 characters
		Node[] children = new Node[ALPHABET_SIZE];

		// Indicates end of word
		boolean isEndOfWord = false;

		// Set all possible children nodes as null
		public Node() {
			Arrays.fill(children, null);
		}
	}

	public Trie() {
		root = new Node();
	}

	public void insert(String key) {
		int len = key.length();
		Node currnode = root;

		// Loop through all characters of the key to insert
		for (int idx = 0; idx < len; idx++) {
			// Insert a new node for this character index
			int charIdx = key.charAt(idx) - 'a';

			if (currnode.children[charIdx] == null)
				currnode.children[charIdx] = new Node();

			// Set next level node as this newly inserted child node
			currnode = currnode.children[charIdx];
		}

		// After storing all characters, mark current node as end of word
		currnode.isEndOfWord = true;
	}

	public boolean search(String key) {
		int len = key.length();
		Node currnode = root;

		// Loop through all characters of the key to search
		for (int idx = 0; idx < len; idx++) {
			// If any node has no child node for a key character, not found return false
			int charIdx = key.charAt(idx) - 'a';

			if (currnode.children[charIdx] == null)
				return false;

			// Set next level node as the child node
			currnode = currnode.children[charIdx];
		}

		// If last read node is end of word, found else not found
		return currnode.isEndOfWord;
	}

	public boolean isEmpty(Node currnode) {
		// Read through children array and check if no children exists
		for (int i = 0; i < ALPHABET_SIZE; i++)
			if (currnode.children[i] != null)
				return false;
		return true;
	}

	public void remove(String key) {
		remove(root, key, 0);
	}

	private Node remove(Node currnode, String key, int depth) {
		// If trie is empty, return null
		if (currnode == null)
			return null;

		// If current node is last character of key
		if (depth == key.length()) {
			// Is end of word and is empty set null and return
			if (currnode.isEndOfWord)
				currnode.isEndOfWord = false;

			if (isEmpty(currnode))
				currnode = null;

			return currnode;
		}

		// Current node not last character of key, recur for child node
		int charIdx = key.charAt(depth) - 'a';
		currnode.children[charIdx] = remove(currnode.children[charIdx], key, depth + 1);

		// If not end of word and is empty, return null
		if (isEmpty(currnode) && currnode.isEndOfWord == false)
			return null;

		return currnode;
	}

}
