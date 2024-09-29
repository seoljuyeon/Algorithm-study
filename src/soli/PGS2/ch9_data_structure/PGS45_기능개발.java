package soli.PGS2.ch9_data_structure;

import java.util.*;

public class PGS45_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answerList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        int day = 1;

        for(int i = 0 ; i < progresses.length ; i++) {
            while(100 > progresses[i] + speeds[i]*day) {
                day++;
            }
            queue.add(day);
        }

        while(!queue.isEmpty()) {
            int first = queue.poll();
            int count = 1;

            while(!queue.isEmpty() && first >= queue.peek()) {
                count++;
                queue.poll();
            }
            answerList.add(count);
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0 ; i < answerList.size() ; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        PGS45_기능개발 pgs45 = new PGS45_기능개발();

//        System.out.println(Arrays.toString(pgs45.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
        System.out.println(Arrays.toString(pgs45.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
    }
}
