package juyeon.PGS.gilbut.sort;

import java.util.*;

public class P27_문자열_마음대로_정렬하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1))); // ["car", "bed", "sun"]
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2))); // ["abcd", "abce", "cdx"]
    }

    private static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {

            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);

            if (c1 == c2) {
                return s1.compareTo(s2);
            } else {
                return c1 - c2;
            }
        });

        return strings;
    }

//    레전드 뻘짓
//    private static String[] solution(String[] strings, int n) {
//        String[] answer = new String[strings.length];
//
//        HashMap<String, Character> map = new HashMap<>();
//
//        for (int i = 0; i < strings.length; i++) {
//            map.put(strings[i], strings[i].charAt(n));
//        }
//
//        List<String> list = new ArrayList<>(map.keySet());
//
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return map.get(o1).compareTo(map.get(o2));
//            }
//        });
//
//        for (int i = 0; i < strings.length; i++) {
//            answer[i] = list.get(i);
//        }
//
//        return answer;
//    }
}
