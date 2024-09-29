package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P54_호텔_방_배정 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1}))); // 1, 3, 4, 2, 5, 6
    }

    private static long[] solution(long k, long[] room_number) {
        // 시간 초과임 당연함 T.T
//        List<Long> list = new ArrayList<>();
//
//        Set<Long> set = new HashSet<>();
//
//        for (long l : room_number) {
//            while (true) {
//                if (!set.contains(l)) {
//                    list.add(l);
//                    set.add(l);
//                    break;
//                } else {
//                    l++;
//                }
//            }
//        }
//
//        // return list.stream().mapToLong(e -> e).toArray();
//
//        long[] answer = new long[room_number.length];
//
//        for (int i = 0; i < room_number.length; i++) {
//            answer[i] = list.get(i);
//        }
//
//        return answer;

        // map 활용하기~
        long[] answer = new long[room_number.length];

        map = new HashMap<>();

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    private static HashMap<Long, Long> map;

    private static long findRoom(long n) {
        if (!map.containsKey(n)) {
            map.put(n, n + 1);
            return n;
        }

        long empty = findRoom(map.get(n));
        map.put(n, empty);
        return empty;
    }

}
