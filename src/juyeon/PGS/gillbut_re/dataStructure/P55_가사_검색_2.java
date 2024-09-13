package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
    int count = 0;
}

class Trie {
    TrieNode front = new TrieNode();
    TrieNode back = new TrieNode();

    void insert(String word) {
        TrieNode frontNode = front;
        for (int i = 0; i < word.length(); i++) {
            frontNode.count++;
            frontNode = frontNode.child.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        TrieNode backNode = back;
        for (int i = word.length() - 1; i >= 0; i--) {
            backNode.count++;
            backNode = backNode.child.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
    }

    public int getCount(String query) {
        if (query.charAt(0) == '?') return getCountFromBack(query);
        else return getCountFromFront(query);
    }

    private int getCountFromFront(String query) {
        TrieNode node = front;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == '?') break;
            if (!node.child.containsKey(query.charAt(i))) return 0;
            node = node.child.get(query.charAt(i));
        }
        return node.count;
    }

    private int getCountFromBack(String query) {
        TrieNode node = back;
        for (int i = query.length() - 1; i >= 0; i--) {
            if (query.charAt(i) == '?') break;
            if (!node.child.containsKey(query.charAt(i))) return 0;
            node = node.child.get(query.charAt(i));
        }
        return node.count;
    }
}

public class P55_가사_검색_2 {
    public int[] solution(String[] words, String[] queries) {
        Trie[] tries = new Trie[100001];

        for (String word : words) {
            int len = word.length();

            if (tries[len] == null) tries[len] = new Trie();
            tries[len].insert(word);
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();

            if (tries[len] == null) answer[i] = 0;
            else answer[i] = tries[len].getCount(queries[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        P55_가사_검색_2 p55 = new P55_가사_검색_2();

        System.out.println(Arrays.toString(p55.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}))); // 3, 2, 4, 1, 0
    }
}
