package juyeon.PGS.hash;

import java.util.HashMap;

public class P34_중복된_문자_제거 {
    public static void main(String[] args) {
        System.out.println(solution("people")); // "peol"
        System.out.println(solution("We are the world")); // "We arthwold"
    }

    private static String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < my_string.length(); i++) {
            Character c = my_string.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
