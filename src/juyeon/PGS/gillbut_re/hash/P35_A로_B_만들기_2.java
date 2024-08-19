package juyeon.PGS.gillbut_re.hash;

import java.util.*;

public class P35_A로_B_만들기_2 {
    public static void main(String[] args) {
        P35_A로_B_만들기_2 p35 = new P35_A로_B_만들기_2();

        System.out.println(p35.solution("olleh", "hello")); // 1
        System.out.println(p35.solution("allpe", "apple")); // 0
    }

    public int solution(String before, String after) {
        // 정렬해서 풀기~
//        char[] b = before.toCharArray();
//        Arrays.sort(b);
//
//        char[] a = after.toCharArray();
//        Arrays.sort(a);
//
//        return new String(b).equals(new String(a)) ? 1 : 0;

        // 해시로 풀기~
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : before.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : after.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) == 0) map.remove(c);
        }

        return map.size() == 0 ? 1 : 0;
    }
}
