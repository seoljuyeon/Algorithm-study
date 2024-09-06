package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

public class P52_보석_쇼핑_2 {
    public static void main(String[] args) {
        P52_보석_쇼핑_2 p52 = new P52_보석_쇼핑_2();

        System.out.println(Arrays.toString(p52.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}))); // 3, 7
        System.out.println(Arrays.toString(p52.solution(new String[]{"AA", "AB", "AC", "AA", "AC"}))); // 1, 3
        System.out.println(Arrays.toString(p52.solution(new String[]{"XYZ", "XYZ", "XYZ"}))); // 1, 1
        System.out.println(Arrays.toString(p52.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}))); // 1, 5
    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();

        for (String gem : gems) {
            set.add(gem);
        }

        int kind = set.size();

        int start = 0;
        int end = 0;
        int len = 100001;

        Map<String, Integer> map = new HashMap<>();

        while (end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if (map.size() == kind && end - start < len) {
                answer[0] = start + 1;
                answer[1] = end + 1;
                len = end - start;
            }

            end++;
        }

        return answer;
    }
}