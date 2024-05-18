package soli.PGS.ch10_implement;

import java.util.*;

public class PGS65 {

    public static void main(String[] args) {
        PGS65 pgs65 = new PGS65();

        System.out.println(pgs65.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2));
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String, String> map = new HashMap<>();
        for(String r : report) {
            String[] arr = r.split(" ");
            String key = arr[0];
            String value = arr[1];

            map.put(key, value);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for(String key : map.keySet()) {
            map2.put(map.get(key), map2.getOrDefault(map.get(key), 0) +1);
        }

        for(String key : map2.keySet()) {
            if(map2.get(key) >=2) {
                for(String key2 : map.keySet()) {
                    if(map.get(key2).equals(key)) {
                        for(int i = 0 ; i < id_list.length ; i++) {
                            if(id_list[i].equals(key2)) {
                                answer[i]++;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

}
