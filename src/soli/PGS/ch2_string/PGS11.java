package soli.PGS.ch2_string;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class PGS11 {
    boolean solution(String s) {

        s = s.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++ ) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'y') {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        if(map.get('p') ==  map.get('y')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        PGS11 pgs11 = new PGS11();

        System.out.println("Test Case1 " + pgs11.solution("pPoooyY"));
        System.out.println("Test Case1 " + pgs11.solution("Pyy"));

    }
}
