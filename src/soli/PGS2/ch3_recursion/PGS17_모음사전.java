package soli.PGS2.ch3_recursion;

import java.util.ArrayList;
import java.util.List;

public class PGS17_모음사전 {
    static String[] arr;
    static List<String> list;
    public static int solution(String word) {
        int answer = 0;

        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        // 완전탐색 메서드 호출
        recursion(word, "", 0);

        // 선형 탐색
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static void recursion(String word, String str, int depth) {
        list.add(str);

        if(depth == 5) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            recursion(word, str + arr[i], depth + 1);
        }
    }
}
