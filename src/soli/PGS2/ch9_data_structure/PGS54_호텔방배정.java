package soli.PGS2.ch9_data_structure;

import java.util.Arrays;

public class PGS54_호텔방배정 {

    public long[] solution(long k, long[] room_nunber) {
        long[] answer = new long[room_nunber.length];

        boolean[] check = new boolean[(int) k + 1];

        for(int i = 0 ; i < room_nunber.length ; i++) {
            if(check[(int)room_nunber[i]] == false) {
                check[(int)room_nunber[i]] = true;
                answer[i] = room_nunber[i];
            } else {
                long next = room_nunber[i];
                while(check[(int)next]) {
                    next++;
                }
                check[(int)next] = true;
                answer[i] = next;
            }
        }

        return answer;

    }

    public static void main(String[] args) {

        PGS54_호텔방배정 pgs54 = new PGS54_호텔방배정();

        System.out.println(Arrays.toString(pgs54.solution(10, new long[]{1, 3, 4, 1, 3, 1}))); // 1, 3, 4, 2, 5, 6
    }



}
