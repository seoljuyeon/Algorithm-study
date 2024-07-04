package juyeon.PGS.gillbut_re.sort;

import java.util.*;

public class P28_가장_큰_수_2 {
    public static void main(String[] args) {
        P28_가장_큰_수_2 p28 = new P28_가장_큰_수_2();

        System.out.println(p28.solution(new int[] {6, 10, 2})); // "6210"
        System.out.println(p28.solution(new int[] {3, 30, 34, 5, 9})); // "9534330"
    }

    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        int idx = 0;

        for (int i : numbers) {
            nums[idx] = String.valueOf(i);
            idx++;
        }

//        Arrays.sort(nums, (o1, o2) -> {
//            String s1 = o1 + o2;
//            String s2 = o2 + o1;
//
//            return s2.compareTo(s1);
//        });

        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        StringBuilder sb = new StringBuilder();

        for (String str : nums) {
            sb.append(str);
        }

        if (sb.charAt(0) == '0') return "0";
        else return sb.toString();
    }
}
