package juyeon.PGS.gilbut.hash;

import java.util.*;

public class P35_A로_B_만들기 {
    public static void main(String[] args) {
        System.out.println(solution("olleh", "hello")); // 1
        System.out.println(solution("allpe", "apple")); // 0
    }

    private static int solution(String before, String after) {

        // hash 로 풀기
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < before.length(); i++) {
            Character c = before.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < after.length(); i++) {
            Character c = after.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) == 0) map.remove(c);
        }

        if (map.size() == 0) return 1;
        else return 0;

        // 다르게 풀기
//        char[] bef = before.toCharArray();
//        char[] aft = after.toCharArray();
//
//        Arrays.sort(bef);
//        Arrays.sort(aft);
//
//        return new String(bef).equals(new String(aft)) ? 1 : 0;
    }
}
