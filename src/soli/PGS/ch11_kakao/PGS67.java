package soli.PGS.ch11_kakao;

import java.util.HashMap;
import java.util.Map;

public class PGS67 {

    public static void main(String[] args) {
        PGS67 pgs67 = new PGS67();
        System.out.println(pgs67.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }

    public int[] solution(int[] fees, String[] records) {

        //  fee[] = {기본 시간, 기본 요금, 단위 시간, 단위 요금};
        // records[] = {시각 차량번호 내역}; 공백으로 구분
        // 입차된 차량이 다음날 출차되는 경우 입력 X
        // 결과 return x

        // 입차
        Map<String, String> in = new HashMap<>();

        // 출차
        Map<String, String> out = new HashMap<>();


        for(String record : records) {
            // {시각, 번호, 내역}
            String[] arr = record.split(" ");



        }
        int[] answer = {};
        return answer;
    }


}
