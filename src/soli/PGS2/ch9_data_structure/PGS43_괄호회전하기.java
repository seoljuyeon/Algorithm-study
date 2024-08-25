package soli.PGS2.ch9_data_structure;

import soli.PGS.ch9_data_structure.PGS43;

public class PGS43_괄호회전하기 {
    public int solution(String s) {

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        PGS43_괄호회전하기 pgs43 = new PGS43_괄호회전하기();
        System.out.println(pgs43.solution("[](){}")); // 3
        System.out.println(pgs43.solution("}]()[{")); // 2
        System.out.println(pgs43.solution("[)(]")); // 0
        System.out.println(pgs43.solution("}}}")); // 0
    }
}
