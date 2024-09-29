package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P46_다리를_지나는_트럭 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[] {7, 4, 5, 6})); // 8
        System.out.println(solution(100, 100, new int[] {10})); // 101
        System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10})); // 110
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int w = 0;
        int time = 0;

        for (int t : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.add(t);
                    w += t;
                    time++;
                    break;
                } else if (q.size() == bridge_length) {
                    w -= q.poll();
                } else {
                    if (w + t > weight) {
                        q.add(0);
                        time++;
                    } else {
                        q.add(t);
                        w += t;
                        time++;
                        break;
                    }
                }
            }

        }

        return time + bridge_length;
    }
}
