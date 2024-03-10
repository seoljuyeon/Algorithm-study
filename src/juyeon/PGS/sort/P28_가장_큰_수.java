package juyeon.PGS.sort;

import java.util.Arrays;

public class P28_가장_큰_수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2})); // 6210
        System.out.println(solution(new int[]{3, 30, 34, 5, 9})); // 9534330
    }

    private static String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(nums, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });

        StringBuilder sb = new StringBuilder();

        for (String num : nums) {
            sb.append(num);
        }

        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }

    // 이렇게 풀면 3, 30, 35 일 때 제대로 큰 수 못 만들더라고요~
//    private static String solution(int[] numbers) {
//        String answer = "";
//
//        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
//
//        Arrays.sort(nums, (o1, o2) -> {
//            char c1 = o1.charAt(0);
//            char c2 = o2.charAt(0);
//
//            if (c1 == c2) {
//                return o2.compareTo(o1);
//            } else {
//                return c2 - c1;
//            }
//        });
//
//        for (int i = 0; i < nums.length; i++) {
//            answer += nums[i];
//        }
//
//        return answer;
//    }
}
