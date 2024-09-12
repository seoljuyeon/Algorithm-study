package soli.PGS2.ch9_data_structure;

import java.util.Collections;
import java.util.PriorityQueue;

public class PGS50_이중우선순위큐 {

    public int[] solution(String[] operations) {

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int size = 0;

        for(String operation : operations) {
            if(operation.startsWith("I ")) {

                int num = Integer.parseInt(operation.substring(2));

                max.add(num);
                min.add(num);
                size++;

            } else if(operation.equals("D -1")){
                if(size > 0) {
                    int minnum = min.poll();
                    max.remove(minnum);
                    size--;
                }
            } else {
                if(!max.isEmpty()) {
                    int maxnum = max.poll();
                    min.remove(maxnum);
                    size--;
                }
            }
        }

        return size>0 ? new int[]{max.peek(), min.peek()} : new int[]{0, 0};

    }
}
