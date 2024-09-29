package soli.PGS2.ch9_data_structure;

import java.util.*;

public class PGS46_다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int sum = 0;

        for(int truck : truck_weights) {
            while(true) {
                if(queue.size() == bridge_length) {
                    sum -= queue.poll();
                }

                if(sum + truck <= weight) {
                    queue.add(truck);
                    sum += truck;
                    count++;
                    break;
                } else {
                    // 초과되서 못 올라가는 경우 채우기 위해 0을 추가
                    queue.add(0);
                    count++;
                }
            }
        }
        count+= bridge_length;
        return count;
    }

    public static void main(String[] args) {
        PGS46_다리를지나는트럭 pgs46 = new PGS46_다리를지나는트럭();

        System.out.println("TEST CASE : " + pgs46.solution(2, 4, new int[] {7, 4, 5, 6}));
        System.out.println("TEST CASE : " + pgs46.solution(100, 100, new int[] {10}));
        System.out.println("TEST CASE : " + pgs46.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));

    }
}
