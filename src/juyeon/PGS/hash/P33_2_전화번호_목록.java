package juyeon.PGS.hash;

import java.util.Arrays;
import java.util.HashMap;

public class P33_2_전화번호_목록 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"119", "97674223", "1195524421"})); // f
        System.out.println(solution(new String[] {"123","456","789"})); // t
        System.out.println(solution(new String[] {"12","123","1235","567","88"})); // f
    }

    private static boolean solution(String[] phone_book) {
        // 대충 해보기
//        Arrays.sort(phone_book);
//
//        for (int i = 0; i < phone_book.length - 1; i++)
//            if (phone_book[i + 1].startsWith(phone_book[i]))
//                return false;
//
//        return true;

        // 효율성 테스트
//        테스트 1 〉	통과 (16.72ms, 56.1MB)
//        테스트 2 〉	통과 (19.35ms, 56.8MB)
//        테스트 3 〉	통과 (697.12ms, 98.9MB)
//        테스트 4 〉	통과 (317.78ms, 96.9MB)

        // 해시로 풀어보기
        HashMap<String, Integer> map = new HashMap<>();

        for (String phoneNum : phone_book) {
            map.put(phoneNum, 1);
        }

//        for (int i = 0; i < phone_book.length; i++) {
//            if (map.containsKey(phone_book[i])) return false;
//        }

        for (String phoneNum : phone_book) {
            for (int i = 0; i < phoneNum.length(); i++) {
                if (map.containsKey(phoneNum.substring(0,i))) return false;
            }
        }

        return true;

        // 효율성 테스트
//        테스트 1 〉	통과 (3.36ms, 56.3MB)
//        테스트 2 〉	통과 (3.68ms, 57.2MB)
//        테스트 3 〉	통과 (270.12ms, 218MB)
//        테스트 4 〉	통과 (201.49ms, 134MB)

    }
}
