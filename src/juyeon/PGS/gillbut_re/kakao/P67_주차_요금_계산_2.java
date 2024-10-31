package juyeon.PGS.gillbut_re.kakao;

import java.util.*;

public class P67_주차_요금_계산_2 {
    public static void main(String[] args) {
        P67_주차_요금_계산_2 p67 = new P67_주차_요금_계산_2();

        // [14600, 34400, 5000]
        System.out.println(Arrays.toString(p67.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));

        // [0, 591]
        System.out.println(Arrays.toString(p67.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));

        // [14841]
        System.out.println(Arrays.toString(p67.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})));
    }

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> temp = new HashMap<>();
        HashMap<String, Integer> totalTime = new HashMap<>();

        for (String record : records) {
            String[] rec = record.split(" ");

            int minutes = getMinutes(rec[0]);
            String car = rec[1];
            String io = rec[2];

            if (io.equals("IN")) {
                temp.put(car, minutes);
            } else {
                totalTime.put(car, totalTime.getOrDefault(car, 0) + (minutes - temp.get(car)));
                temp.remove(car);
            }
        }

        for (String car : temp.keySet()) {
            int minutes = 1439 - temp.get(car);

            if (totalTime.containsKey(car)) totalTime.put(car, totalTime.get(car) + minutes);
            else totalTime.put(car, minutes);
        }

        for (String car : totalTime.keySet()) {
            int fee = computeFee(fees, totalTime.get(car));

            temp.put(car, fee);
        }

        List<String> list = new ArrayList<>(temp.keySet());

        Collections.sort(list);

        int[] answer = new int[list.size()];

        int idx = 0;

        for (String car : list) {
            answer[idx++] = temp.get(car);
        }

        return answer;
    }

    private int getMinutes(String hhmm) {
        String[] temp = hhmm.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    private int computeFee(int[] fees, int time) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        int fee = baseFee;

        if (time >= baseTime) {
            time -= baseTime;
            fee += (int) Math.ceil((double) time / unitTime) * unitFee;
        }

        return fee;
    }
}
