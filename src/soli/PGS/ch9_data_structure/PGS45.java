package soli.PGS.ch9_data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PGS45 {
    public int[] solution(int[] progresses, int[] speeds){

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < progresses.length ; i++) {
            int n = 1;
            while(progresses[i] + (speeds[i] *n) < 100){
                n++;
            }
            q.add(n);
        }

        while(!q.isEmpty()){
            int head = q.poll();
            int count = 1;
            if(!q.isEmpty() && head > q.peek()) {
                q.poll();
                count++;
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {

    }
}
