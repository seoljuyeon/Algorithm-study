package juyeon.PGS.gillbut_re.kakao;

import java.util.*;

public class P65_신고_결과_받기_2 {
    public static void main(String[] args) {
        P65_신고_결과_받기_2 p65 = new P65_신고_결과_받기_2();

        System.out.println(Arrays.toString(p65.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2))); // [2, 1, 1, 0]
        System.out.println(Arrays.toString(p65.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3))); // [0, 0]
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> count = new LinkedHashMap<>();
        Map<String, Set<String>> map = new HashMap<>();

        for (String id : id_list) {
            count.put(id, 0);
            map.put(id, new HashSet<>());
        }

        for (String str : report) {
            String[] temp = str.split(" ");

            map.get(temp[1]).add(temp[0]);
        }

        for (String id : id_list) {
            Set<String> set = map.get(id);

            if (set.size() >= k) {
                for (String name : set) {
                    count.put(name, count.get(name) + 1);
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i : count.values()) {
            list.add(i);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
