package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

public class P50_이중_우선순위_큐_2 {
    public static void main(String[] args) {
        P50_이중_우선순위_큐_2 p50 = new P50_이중_우선순위_큐_2();

        System.out.println(Arrays.toString(p50.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))); // 0, 0
        System.out.println(Arrays.toString(p50.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))); // 333, -45
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> rQ = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            String[] temp = op.split(" ");

            if (temp[0].equals("I")) {
                q.add(Integer.parseInt(temp[1]));
                rQ.add(Integer.parseInt(temp[1]));
            } else {
                if (temp[1].equals("1")) q.remove(rQ.poll());
                else rQ.remove(q.poll());
            }
        }

        if (q.isEmpty()) return new int[]{0, 0};
        else {
            answer[0] = rQ.peek();
            answer[1] = q.peek();

            return answer;
        }
    }
}