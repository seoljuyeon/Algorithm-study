package soli.PGS2.ch9_data_structure;

import java.util.HashMap;
import java.util.Map;

public class PGS55_가사검색 {
    // Trie 노드 정의
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int wordCount = 0;  // 이 노드를 지나가는 단어의 개수
    }

    // Trie 클래스 정의
    class Trie {
        TrieNode root = new TrieNode();

        // 단어 삽입 메서드
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.wordCount++;
            }
        }

        // 패턴에 맞는 단어 개수 찾기
        int countWordsMatching(String pattern) {
            TrieNode node = root;
            for (char c : pattern.toCharArray()) {
                if (c == '?') break;  // 와일드카드는 이후는 의미 없음
                if (!node.children.containsKey(c)) return 0;  // 매칭되지 않으면 0 반환
                node = node.children.get(c);
            }
            return node.wordCount;  // 패턴에 매칭된 단어의 개수 반환
        }
    }

    // 길이에 따른 Trie들을 관리하는 맵
    Map<Integer, Trie> normalTries = new HashMap<>();  // 정방향 Trie
    Map<Integer, Trie> reverseTries = new HashMap<>(); // 역방향 Trie

    public int[] solution(String[] words, String[] queries) {
        // words를 Trie에 삽입
        for (String word : words) {
            int len = word.length();
            // 정방향 Trie 삽입
            normalTries.putIfAbsent(len, new Trie());
            normalTries.get(len).insert(word);

            // 역방향 Trie 삽입 (단어를 뒤집어서 삽입)
            reverseTries.putIfAbsent(len, new Trie());
            reverseTries.get(len).insert(new StringBuilder(word).reverse().toString());
        }

        // queries에 대해 답을 구함
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();

            if (query.charAt(0) == '?') {  // 접두사에 '?'가 있는 경우 -> 역방향 Trie 사용
                String reversedQuery = new StringBuilder(query).reverse().toString();
                result[i] = reverseTries.containsKey(len)
                        ? reverseTries.get(len).countWordsMatching(reversedQuery)
                        : 0;
            } else {  // 접미사에 '?'가 있는 경우 -> 정방향 Trie 사용
                result[i] = normalTries.containsKey(len)
                        ? normalTries.get(len).countWordsMatching(query)
                        : 0;
            }
        }

        return result;
    }
}
