package soli.PGS.ch10_implement;

import java.util.*;

public class PGS65 {

    public static void main(String[] args) {
        PGS65 pgs65 = new PGS65();

        System.out.println(pgs65.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2));
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        Set<String> set = new HashSet<>(Arrays.asList(report));

        int[] answer = new int[id_list.length];

        Map<String, Integer> map = new HashMap<>();
        for(String s : set) {
            String[] arr = s.split(" ");
            String key = arr[0];
            String value = arr[1];

            map.put(value, map.getOrDefault(value, 0)+1);
        }


        for(String key : map.keySet()) {
            if(map.get(key) >=2) {
                for(String s : set) {
                    String[] arr = s.split(" ");
                    String a = arr[0];
                    String b = arr[1];
                    if(key.equals(b)) {
                        for(int i = 0 ; i < id_list.length ; i++) {
                            if(id_list[i].equals(a)) {
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
