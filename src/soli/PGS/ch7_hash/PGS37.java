package soli.PGS.ch7_hash;

import java.util.*;

public class PGS37 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for(String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1) ;
        }

        for(String str : completion) {
            map.put(str, map.get(str)-1);
        }

        for(String str : map.keySet()) {
            // 0이 아니면 완주 못한 거
            if(map.get(str) != 0) {
                answer = str;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        PGS37 pgs37 = new PGS37();

        System.out.println("Test code : " + pgs37.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println("Test code : " + pgs37.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println("Test code : " + pgs37.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
