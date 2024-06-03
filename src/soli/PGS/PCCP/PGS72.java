package soli.PGS.PCCP;

import soli.PGS.ch11_kakao.PGS71;

import java.util.*;

public class PGS72 {
    public String solution(String input_string){

        // 한 번씩 나타나도 외톨이란다...
        // 부분 부분 나눠져 있어도 char 자체를 외톨이라 함
        StringBuilder sb = new StringBuilder();

        Map<Character, Boolean> map = new HashMap<>();

        Set<Character> set = new HashSet<>();

        char[] c = input_string.toCharArray();

        char current = c[0];

        map.put(current, true);

        for(int i = 1 ; i < c.length ; i++) {
            char temp = c[i];
            // 연속인지 아닌지 확인
            if(current != temp) {
                // 연속 아니고 앞에 나온 적 있으면
                if(map.containsKey(temp)) {
                    // 외톨이 추가
                    set.add(temp);
                }
                map.put(temp, true);
                current = temp;
            }
        }

        List<Character> list = new ArrayList<>(set);
        Collections.sort(list);

        for(char ch : list) {
            sb.append(ch);
        }

        if((sb.toString()).equals("")) return "N";

        return sb.toString();
    }

    public static void main(String[] args) {
        PGS72 pgs72 = new PGS72();
        System.out.println(pgs72.solution("edeaaabbccd"));  // Output: "de"
        System.out.println(pgs72.solution("eeddee"));       // Output: "e"
        System.out.println(pgs72.solution("string"));       // Output: "N"
        System.out.println(pgs72.solution("zbzbz"));        // Output: "bz"

    }
}
