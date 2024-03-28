package soli.PGS.ch7_hash;

import java.util.*;

public class PGS_hash42578 {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for(String[] s : clothes) {
            map.put(s[1], map.getOrDefault(s[1], 0)+1);
        }


        int answer = 1;
        for(int i : map.values()) {
            answer *= (i+1);
        }

        return answer -1 ;
    }
}
