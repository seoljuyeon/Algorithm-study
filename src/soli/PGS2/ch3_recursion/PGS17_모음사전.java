package soli.PGS2.ch3_recursion;

import java.util.ArrayList;
import java.util.List;

public class PGS17_모음사전 {
    static String[] alp;
    static ArrayList<String> A;

    public static int solution(String word) {

        alp = new String[]{"A","E","I","O","U"};
        A = new ArrayList<>();

        String str = "";
        int len = 0;

        recursion(str, len);

        for(int i = 0 ; i < A.size(); i++) {
            if(A.get(i).equals(word)) return i;
        }
        return 0;
    }

    public static void recursion(String str, int len) {

        A.add(str);

        if(len == 5) {
            return;
        }

        for(int i = 0 ; i < alp.length ; i++) {
            recursion(str + alp[i], len + 1);
        }

    }

    public static void main(String[] args) {
        // 테스트 케이스
        String[] testCases = {"AAAAE", "AAAE", "I", "EIO","AE"};
        for (String word : testCases) {
            System.out.println(word + ": " + solution(word));
        }
    }
}
