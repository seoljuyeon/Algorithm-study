package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P50_이중_우선순위_큐 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))); // 0, 0
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))); // 333, -45
    }

    private static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (String op : operations) {
            String[] arr = op.split(" ");

            if (arr[0].equals("I")) {
                maxQ.add(Integer.parseInt(arr[1]));
                minQ.add(Integer.parseInt(arr[1]));
            } else {
                if (arr[1].equals("1")) {
                    minQ.remove(maxQ.poll());
                } else {
                    maxQ.remove(minQ.poll());
                }
            }
        }

        if (maxQ.isEmpty()) {
            return new int[] {0, 0};
        } else {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }

        return answer;
    }
}
