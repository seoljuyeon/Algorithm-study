package soli.PGS2.ch9_data_structure;

import java.util.*;

public class PGS52_보석쇼핑 {
    public int[] solution(String[] gems) {

        int[] answer = new int[2];

        Set<String> set = new HashSet<>();

        for(String gem : gems) {
            set.add(gem);
        }

        Map<String, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;

        while(end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0)+1);

            while(map.size() == set.size()) {
                if(end - start < min) {
                    min = end - start;
                    answer[0] = start +1;
                    answer[1] = end +1;
                }

                map.put(gems[start], map.get(gems[start])-1);
                if(map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
            end++;
        }

        return answer;
    }
        public static void main(String[] args) {

        PGS52_보석쇼핑 pgs52 = new PGS52_보석쇼핑();

        System.out.println(Arrays.toString(pgs52.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}))); // 3, 7
        System.out.println(Arrays.toString(pgs52.solution(new String[]{"AA", "AB", "AC", "AA", "AC"}))); // 1, 3
        System.out.println(Arrays.toString(pgs52.solution(new String[]{"XYZ", "XYZ", "XYZ"}))); // 1, 1
        System.out.println(Arrays.toString(pgs52.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}))); // 1, 5
    }

}
