package soli.PGS.ch9_data_structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PGS49 {
    public int[] solution(String[] operations) {

        int[] answer = new int[2];

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        int queueSize = 0;

        for(String s : operations) {
            if(s.startsWith("I ")) {
                int num = Integer.parseInt(s.substring(2));
                minQ.add(num);
                maxQ.add(num);
                queueSize++;
            } else if(s.startsWith("D -")) {
                if (!minQ.isEmpty()) {
                    int min = minQ.poll();
                    maxQ.remove(min);
                    queueSize--;
                }
            } else if(s.startsWith("D 1")) {
                if(!maxQ.isEmpty()){
                    int max = maxQ.poll();
                    minQ.remove(max);
                    queueSize--;
                }
            }
        }

        if(queueSize > 0) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }


        return answer;
    }

    public static void main(String[] args) {
        PGS49 pgs49 = new PGS49();

        System.out.println("TEST CASE : " + Arrays.toString(pgs49.solution(new String[]{"I 1", "I 2", "D 1", "D -1", "I 3", "I 4", "D 1"})));   // [3,3]
    }
}
