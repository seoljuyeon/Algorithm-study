package juyeon.PGS.drill;

import java.util.*;

public class PGS_의상 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    private static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;

        for(String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }

        // 아무것도 안 입은 경우는 제외니까 -1 해주기
        return answer - 1;
    }
}
