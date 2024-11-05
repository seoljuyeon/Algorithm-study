package juyeon.PGS.drill.lv1;

import java.util.*;

public class PGS_키패드_누르기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    private static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, int[]> map = new HashMap<>();
        int[] L = new int[]{4, 1};
        int[] R = new int[]{4, 3};

        map.put(1, new int[]{1, 1});
        map.put(2, new int[]{1, 2});
        map.put(3, new int[]{1, 3});
        map.put(4, new int[]{2, 1});
        map.put(5, new int[]{2, 2});
        map.put(6, new int[]{2, 3});
        map.put(7, new int[]{3, 1});
        map.put(8, new int[]{3, 2});
        map.put(9, new int[]{3, 3});
        map.put(0, new int[]{4, 2});

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                L = map.get(numbers[i]);
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                R = map.get(numbers[i]);
            } else {

                // ⭐⭐⭐ 거리 구할 땐 절댓값 !!! ⭐⭐⭐
                int distL = Math.abs(L[0] - map.get(numbers[i])[0]) + Math.abs(L[1] - map.get(numbers[i])[1]);
                int distR = Math.abs(R[0] - map.get(numbers[i])[0]) + Math.abs(R[1] - map.get(numbers[i])[1]);

                if (distL > distR) {
                    sb.append("R");
                    R = map.get(numbers[i]);
                } else if (distL < distR) {
                    sb.append("L");
                    L = map.get(numbers[i]);
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        R = map.get(numbers[i]);
                    } else {
                        sb.append("L");
                        L = map.get(numbers[i]);
                    }
                }
            }

        }
        return sb.toString();
    }
}