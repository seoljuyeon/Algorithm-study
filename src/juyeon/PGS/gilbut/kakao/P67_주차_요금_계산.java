package juyeon.PGS.gilbut.kakao;

import java.util.*;

public class P67_주차_요금_계산 {
    public static void main(String[] args) {
        // [14600, 34400, 5000]
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));

        // [0, 591]
        System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));

        // [14841]
        System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})));
    }

    private static int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> totalTime = new HashMap<>();

        for (String str : records) {
            String[] temp = str.split(" ");

            int time = getMinutes(temp[0]);
            String car = temp[1];
            String io = temp[2];

            if (io.equals("IN")) {
                map.put(car, time);
            } else {
                int minutes = time - map.get(car);

                if (totalTime.containsKey(car)) {
                    totalTime.replace(car, totalTime.get(car) + minutes);
                    map.remove(car);
                } else {
                    totalTime.put(car, minutes);
                    map.remove(car);
                }
            }
        }

        // 🚨🚨🚨 keySet() 이랑 remove를 같이 썼더니 런타임 에러가! 당연함
        for (String car : map.keySet()) {
            int minutes = 1439 - map.get(car);

            if (totalTime.containsKey(car)) {
                totalTime.replace(car, totalTime.get(car) + minutes);
//                map.remove(car);
            } else {
                totalTime.put(car, minutes);
//                map.remove(car);
            }
        }

        for (String car : totalTime.keySet()) {
            int fee = computeFee(fees, totalTime.get(car));

            map.put(car, fee);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        int[] answer = new int[list.size()];

        int idx = 0;

        for (String car : list) {
            answer[idx] = map.get(car);
            idx++;
        }

        return answer;
    }

    private static int getMinutes(String hhmm) {
        String[] temp = hhmm.split(":");

        int hh = Integer.parseInt(temp[0]);
        int mm = Integer.parseInt(temp[1]);

        return hh * 60 + mm;
    }

    private static int computeFee(int[] fees, int minutes) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        int fee = baseFee;

        if (minutes > baseTime) {
            minutes -= baseTime;

            fee += (int) Math.ceil((double) minutes / unitTime) * unitFee;
        }

        return fee;
    }
}
