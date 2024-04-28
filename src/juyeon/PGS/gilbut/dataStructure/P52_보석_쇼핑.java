package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P52_보석_쇼핑 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}))); // 3, 7
        System.out.println(Arrays.toString(solution(new String[]{"AA", "AB", "AC", "AA", "AC"}))); // 1, 3
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XYZ", "XYZ"}))); // 1, 1
        System.out.println(Arrays.toString(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}))); // 1, 5
    }

    private static int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();

        for (String gem : gems) {
            set.add(gem);
        }

        int count = set.size();

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;

        HashMap<String, Integer> map = new HashMap<>();

        while (end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) map.remove(gems[start]);
                start++;
            }

            if (end - start < len && map.size() == count) {
                answer[0] = start + 1;
                answer[1] = end + 1;
                len = end - start;
            }

            end++;
        }

        return answer;
    }
}
