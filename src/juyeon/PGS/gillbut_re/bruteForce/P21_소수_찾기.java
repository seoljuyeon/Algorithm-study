package juyeon.PGS.gillbut_re.bruteForce;

import java.util.*;

public class P21_소수_찾기 {
    public static void main(String[] args) {
        P21_소수_찾기 p21 = new P21_소수_찾기();

        System.out.println(p21.solution("17")); // 3
        System.out.println(p21.solution("011")); // 2
    }

    Set<Integer> set;

    boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;

        set = new HashSet<>();
        visited = new boolean[numbers.length()];

        DFS("", numbers, 0);

        for (int i : set) {
            if (isPrime(i)) answer++;
        }

        return answer;
    }

    private void DFS(String num, String numbers, int depth) {
        if (depth > numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;

                set.add(Integer.parseInt(num + numbers.charAt(i)));
                DFS(num + numbers.charAt(i), numbers, depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num == 1) return false;

        if (num == 2 || num == 3) return true;

        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
