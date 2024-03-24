package juyeon.PGS.drill;

import java.util.*;

public class PGS_단어_변환 {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"})); // 4
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"})); // 0
    }

    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;

    private static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        // target 이 words 에 없다면
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        if (!set.contains(target)) return 0;

        DFS(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private static void DFS(String current, String target, String[] words, int count) {
        if (current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canTransform(current, words[i])) {
                visited[i] = true;
                DFS(words[i], target, words, count + 1);

                // 백트래킹
                visited[i] = false;
            }
        }
    }

    private static boolean canTransform(String from, String to) {
        int k = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                k++;
            }
        }

        return k == 1;
    }
}
