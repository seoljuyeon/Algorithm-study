package soli.PGS.ch7_hash;

import java.util.HashMap;
import java.util.Map;

public class PGS35 {

    public int solution(String before, String after) {
        int answer = 0;

        Map<Character, Integer> beforeMap = new HashMap<>();
        for(Character c : before.toCharArray()) {
            beforeMap.put(c, beforeMap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> afterMap = new HashMap<>();
        for(Character c : after.toCharArray()) {
            afterMap.put(c, afterMap.getOrDefault(c, 0)+1);
        }

        if(beforeMap.equals(afterMap)) {
            answer = 1;
        }

        return answer;
    }


    public static void main(String[] args) {
        PGS35 pgs35 = new PGS35();

        System.out.println("Test Code1 : " + pgs35.solution("olleh", "hello"));
        System.out.println("Test Code2 : " + pgs35.solution("olleh", "hlleo"));
        System.out.println("Test Code3 : " + pgs35.solution("allpe", "apple"));
    }
}
