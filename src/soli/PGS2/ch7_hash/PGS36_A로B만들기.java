package soli.PGS2.ch7_hash;

import java.util.HashMap;
import java.util.Map;

public class PGS36_A로B만들기 {
    public int solution(String before, String after) {
        int answer = 0;

        Map<Character, Integer> bmap = new HashMap<>();
        for(Character c : before.toCharArray()) {
            bmap.put(c,bmap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> amap = new HashMap<>();
        for(Character c : after.toCharArray()){
            amap.put(c, amap.getOrDefault(c, 0)+1);
        }

        if(bmap.equals(amap)) return answer= 1;

        return answer;

    }

    public static void main(String[] args) {
        PGS36_A로B만들기 pgs36A로B만들기 = new PGS36_A로B만들기();

        System.out.println(pgs36A로B만들기.solution("olleh","hello"));
        System.out.println(pgs36A로B만들기.solution("aplle", "apple"));
    }
}
