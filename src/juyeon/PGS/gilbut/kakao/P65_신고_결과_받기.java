package juyeon.PGS.gilbut.kakao;

import java.util.*;

public class P65_신고_결과_받기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2))); // [2, 1, 1, 0]
        System.out.println(Arrays.toString(solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3))); // [0, 0]
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> idList = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();

        int idx = 0;

        for (String id : id_list) {
            idList.put(id, idx);
            map.put(id, new HashSet<>());
            idx++;
        }

        for (String str : report) {
            String[] temp = str.split(" ");
            map.get(temp[1]).add(temp[0]);
        }

        for (String id : id_list) {
            Set<String> set = map.get(id);

            if (set.size() >= k) {
                for (String name : set) {
                    answer[idList.get(name)]++;
                }
            }
        }

        return answer;
    }
}
