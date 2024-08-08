package juyeon.PGS.gillbut_re.hash;

import java.util.*;

public class P33_2_전화번호_목록_2 {
    public static void main(String[] args) {
        P33_2_전화번호_목록_2 p33 = new P33_2_전화번호_목록_2();

        System.out.println(p33.solution(new String[] {"119", "97674223", "1195524421"})); // f
        System.out.println(p33.solution(new String[] {"123","456","789"})); // t
        System.out.println(p33.solution(new String[] {"12","123","1235","567","88"})); // f
    }

    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        for (String num : phone_book)
            set.add(num);

        for (String num : phone_book) {
            for (int i = 0; i < num.length(); i++) {
                if (set.contains(num.substring(0, i))) return false;
            }
        }

        return true;
    }
}