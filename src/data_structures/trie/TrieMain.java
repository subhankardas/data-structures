package data_structures.trie;

import java.util.Arrays;

public class TrieMain {

	public static void main(String[] args) {

		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		Trie trie = new Trie();

		for (int idx = 0; idx < keys.length; idx++) {
			trie.insert(keys[idx]);
		}

		System.out.println("Trie : " + Arrays.toString(keys) + "\n");

		System.out.println("Found the       : " + trie.search("the"));
		System.out.println("Found there     : " + trie.search("there"));
		System.out.println("Found theres    : " + trie.search("theres"));
		System.out.println("Found a         : " + trie.search("a"));
		System.out.println("Found an        : " + trie.search("an"));
		System.out.println("Found their     : " + trie.search("their"));

		System.out.println();
		System.out.println("Removing keys [the, a] from trie... \n");

		trie.remove("the");
		trie.remove("a");

		System.out.println("Found the       : " + trie.search("the"));
		System.out.println("Found there     : " + trie.search("there"));
		System.out.println("Found theres    : " + trie.search("theres"));
		System.out.println("Found a         : " + trie.search("a"));
		System.out.println("Found an        : " + trie.search("an"));
		System.out.println("Found their     : " + trie.search("their"));

	}

}
