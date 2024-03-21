package juyeon;

import java.util.*;

public class PGS_개인정보_수집_유효기간 {
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
