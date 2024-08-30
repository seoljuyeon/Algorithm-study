package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

public class P45_기능개발_2 {
    public static void main(String[] args) {
        P45_기능개발_2 p45 = new P45_기능개발_2();

        System.out.println(Arrays.toString(p45.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}))); // 2, 1
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = computeTime(100 - progresses[i], speeds[i]);
        }

        List<Integer> list = new ArrayList<>();

        int k = arr[0];
        int count = 1;

        for (int i = 1; i < size; i++) {
            if (k >= arr[i]) count++;
            else {
                list.add(count);
                count = 1;
                k = arr[i];
            }
        }

        list.add(count);

        return list.stream().mapToInt(e -> e).toArray();
    }

    private int computeTime(int percent, int speed) {
        int d = percent / speed;
        int m = percent % speed;

        if (m == 0) return d;
        else return d + 1;
    }
}