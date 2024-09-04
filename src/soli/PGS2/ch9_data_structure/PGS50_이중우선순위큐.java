package soli.PGS2.ch9_data_structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS50_이중우선순위큐 {

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



}
