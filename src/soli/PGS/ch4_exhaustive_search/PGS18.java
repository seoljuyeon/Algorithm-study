package soli.PGS.ch4_exhaustive_search;

import java.util.ArrayList;
import java.util.Arrays;

public class PGS18 {

    public int[] soulution(int[] answers) {

        ArrayList<int[]> arr = new ArrayList<>();

        arr.add(new int[]{ 1, 2, 3, 4, 5});
        arr.add(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        arr.add(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        int[] correct = new int[3];

        for(int i = 0 ; i<arr.size() ; i++) {
            correct[i] = check(answers, arr.get(i));
        }

        int max = Math.max(Math.max(correct[0], correct[1]), correct[2]);

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < correct.length ; i++){
            if(max== correct[i]) {
                result.add(i + 1);
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private static int check(int[] answers, int[] supoja) {

        // 맞춘 문제 count
        int count = 0;

        for(int i = 0 ; i < answers.length ; i++) {
            if(answers[i] == supoja[i % supoja.length]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PGS18 pgs18 = new PGS18();

        System.out.println("Test Case1 : " + Arrays.toString(pgs18.soulution(new int[]{1, 2, 3, 4, 5})));
        System.out.println("Test Case1 : " + Arrays.toString(pgs18.soulution(new int[]{1, 3, 2, 4, 2})));
    }
}
