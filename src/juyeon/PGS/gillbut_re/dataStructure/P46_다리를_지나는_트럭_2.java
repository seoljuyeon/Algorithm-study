package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

public class P46_다리를_지나는_트럭_2 {
    public static void main(String[] args) {
        P46_다리를_지나는_트럭_2 p46 = new P46_다리를_지나는_트럭_2();

        System.out.println(p46.solution(2, 10, new int[]{7, 4, 5, 6})); // 8
        System.out.println(p46.solution(100, 100, new int[]{10})); // 101
        System.out.println(p46.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})); // 110
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();

        int time = 0;
        int w = 0;

        for (int truck : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.add(truck);
                    w += truck;
                    time++;
                    break;
                } else if (q.size() == bridge_length) {
                    w -= q.poll();
                } else {
                    if (w + truck <= weight) {
                        q.add(truck);
                        w += truck;
                        time++;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }
                }
            }
        }


        return time + bridge_length;
    }
}
