package juyeon.PGS.drill;

import java.util.*;

public class PGS_기능개발 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}))); // 2, 1
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            int n = 100 - progresses[i];

            if (n % speeds[i] == 0) arr[i] = n / speeds[i];
            else arr[i] = (n / speeds[i]) + 1;
        }

        ArrayList<Integer> list = new ArrayList<>();

        int k = arr[0];
        int count = 1;

        for (int i = 1; i < len; i++) {
            if (k >= arr[i]) count++;
            else {
                list.add(count);
                count = 1;
                k = arr[i];
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
