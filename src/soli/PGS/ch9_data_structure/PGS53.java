package soli.PGS.ch9_data_structure;

public class PGS53 {
    public long[] solution(long k, long[] room_number) {

        // 배정되어 있으면 원하는 방보다 크면서 비어있는 방 중 가장 작은 방
        long[] answer = new long[room_number.length];
        boolean[] check = new boolean[(int)k + 1];

        for(int i = 0 ; i < room_number.length ; i++) {
            if(check[(int)room_number[i]] == false) {
                check[(int)room_number[i]] = true;
                answer[i] = room_number[i];
            } else {
                long next = room_number[i];
                while(check[(int)next]) {
                    next++;
                }
                check[(int)next] = true;
                answer[i] = next;
            }
        }

        return answer;
    }
}
