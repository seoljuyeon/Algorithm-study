package juyeon.PGS.drill.lv1;

import java.util.*;

public class PGS_폰켓몬 {
    public static void main(String[] args) {
        PGS_폰켓몬 pgs_폰켓몬 = new PGS_폰켓몬();

        System.out.println(pgs_폰켓몬.solution(new int[]{3, 1, 2, 3})); // 2
        System.out.println(pgs_폰켓몬.solution(new int[]{3, 3, 3, 2, 2, 4})); // 3
        System.out.println(pgs_폰켓몬.solution(new int[]{3, 3, 3, 2, 2, 2})); // 2
    }

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);

//        if (nums.length / 2 <=  set.size()) return nums.length / 2;
//        else return  set.size();

        return Math.min(nums.length / 2, set.size());
    }
}
