package soli.PGS.ch9_data_structure;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42583
// ✨feat: PGS46_다리를 지나는 트럭
public class PGS46 {
    public int solution (int bridge_length, int weight, int[] truck_weights){

        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int now = 0;

        for(int truck : truck_weights) {
            while (true) {
                // 다리 비어있으면 트럭 보내기
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    now += truck;
                    time++;
                    break;
                }
                // 다리가 다 차면 제일 앞에 빼고 시간 증가
                else if (bridge.size() == bridge_length) {
                    weight -= bridge.poll();
                } else {
                    if (now + truck <= weight) {
                        bridge.add(truck);
                        weight += truck;
                        time++;
                        break;
                    } else {
                        // 더 못알라가면 다리 비워줌
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }

    public static void main(String[] args) {

        PGS46 pgs46 = new PGS46();

        System.out.println("TEST CASE : " + pgs46.solution(2, 4, new int[] {7, 4, 5, 6}));
        System.out.println("TEST CASE : " + pgs46.solution(100, 100, new int[] {10}));
        System.out.println("TEST CASE : " + pgs46.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
    }
}
