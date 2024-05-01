package soli.PGS.ch9_data_structure;

import java.util.*;

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

        while(!q.isEmpty()) {
            int head = q.poll();
            int count = 1;
            while(!q.isEmpty() && head >= q.peek()) {
                q.poll();
                count++;
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        PGS45 pgs45 = new PGS45();

//        System.out.println(Arrays.toString(pgs45.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
        System.out.println(Arrays.toString(pgs45.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
    }
}
