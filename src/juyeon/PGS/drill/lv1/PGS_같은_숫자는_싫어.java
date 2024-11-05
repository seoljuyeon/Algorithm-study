package juyeon.PGS.drill.lv1;

import java.util.*;

public class PGS_같은_숫자는_싫어 {
    public static void main(String[] args) {
        PGS_같은_숫자는_싫어 pgs_같은_숫자는_싫어 = new PGS_같은_숫자는_싫어();

        System.out.println(Arrays.toString(pgs_같은_숫자는_싫어.solution(new int[]{1, 1, 3, 3, 0, 1, 1}))); // [1,3,0,1]
        System.out.println(Arrays.toString(pgs_같은_숫자는_싫어.solution(new int[]{4, 4, 4, 3, 3}))); // [4,3]
    }

    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i : arr) {
            if (!st.isEmpty() && st.peek() == i) continue;
            else st.push(i);
        }

        int idx = 1;
        int size = st.size();

        int[] answer = new int[size];

        while (!st.empty()) {
            answer[size - idx] = st.pop();
            idx++;
        }

        return answer;

        // stream~
//        Stack<Integer> st = new Stack<>();
//
//        for (int i : arr) {
//            if (st.isEmpty() || st.peek() != i) {
//                st.push(i);
//            }
//        }
//
//        List<Integer> list = new ArrayList<>(st);
//
//        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class PGS_개인정보_수집_유효기간 {
        public static void main(String[] args) {
            System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
        }

        private static int[] solution(String today, String[] terms, String[] privacies) {
            ArrayList<Integer> answer = new ArrayList<>();

            String[] t = today.split("\\.");
            int todayDate = Integer.parseInt(t[0])*12*28 + Integer.parseInt(t[1])*28 + Integer.parseInt(t[2]);

            HashMap<String, Integer> termsMap = new HashMap<>();

            for (int i = 0; i < terms.length; i++) {
                termsMap.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
            }

            for (int i = 0; i < privacies.length; i++) {
                String[] temp = privacies[i].split(" ");
                String[] date = temp[0].split("\\.");

                int year = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]) + termsMap.get(temp[1]);
                int day = Integer.parseInt(date[2]);

                int update = year*12*28 + month*28 + day;

                if (todayDate >= update) answer.add(i + 1);
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
