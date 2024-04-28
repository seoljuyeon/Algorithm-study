package juyeon.PGS.drill;

import java.util.*;

public class PGS_주사위_게임_3 {
    public static void main(String[] args) {
        System.out.println(solution(2, 2, 2, 2)); // 2222
        System.out.println(solution(4, 1, 4, 4)); // 1681
        System.out.println(solution(6, 3, 3, 6)); // 27
        System.out.println(solution(2, 5, 2, 6)); // 30
        System.out.println(solution(6, 4, 2, 5)); // 2
    }

    private static int solution(int a, int b, int c, int d) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        int size = map.size();
        int answer = 0;

        if (size == 1) return 1111 * a;

        if (size == 2) {
            if (map.containsValue(3)) {
                for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                    answer += m.getKey() * (m.getValue() == 3 ? 10 : 1);
                }
                return answer * answer;
            } else {
                int n = (a + b + c + d - 2 * a) / 2;
                return (a + n) * Math.abs(a - n);
            }
        }

        if (size == 3) {
            answer = 1;
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                if (m.getValue() == 1) answer *= m.getKey();
            }
            return answer;
        }

        if (size == 4) return Math.min(Math.min(a, b), Math.min(c, d));

        return 0;
    }
}
