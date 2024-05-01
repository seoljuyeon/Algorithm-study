package juyeon.PGS.gilbut.implementation;

import java.util.*;

public class P57_키패드_누르기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); // "LRLLLRLLRRL"
    }

    private static String solution(int[] numbers, String hand) {
        HashMap<Integer, int[]> keypad = new HashMap<>();

        keypad.put(1, new int[]{1, 1});
        keypad.put(2, new int[]{1, 2});
        keypad.put(3, new int[]{1, 3});
        keypad.put(4, new int[]{2, 1});
        keypad.put(5, new int[]{2, 2});
        keypad.put(6, new int[]{2, 3});
        keypad.put(7, new int[]{3, 1});
        keypad.put(8, new int[]{3, 2});
        keypad.put(9, new int[]{3, 3});
        keypad.put(0, new int[]{4, 2});

        int[] L = new int[]{4, 1};
        int[] R = new int[]{4, 3};

        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                L = keypad.get(num);
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                R = keypad.get(num);
            } else {
                int distL = Math.abs(L[0] - keypad.get(num)[0]) + Math.abs(L[1] - keypad.get(num)[1]);
                int distR = Math.abs(R[0] - keypad.get(num)[0]) + Math.abs(R[1] - keypad.get(num)[1]);

                if (distL > distR) {
                    sb.append("R");
                    R = keypad.get(num);
                } else if (distL < distR) {
                    sb.append("L");
                    L = keypad.get(num);
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        R = keypad.get(num);
                    } else {
                        sb.append("L");
                        L = keypad.get(num);
                    }
                }
            }
        }

        return sb.toString();
    }
}
