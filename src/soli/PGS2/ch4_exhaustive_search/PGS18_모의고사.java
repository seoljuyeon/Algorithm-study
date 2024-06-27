package soli.PGS2.ch4_exhaustive_search;
import java.util.*;
public class PGS18_모의고사 {

    public int[] solution(int[] answers) {

        int[] grading = new int[3];

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < answers.length ; i++) {
            if(answers[i] == one[i % one.length]) grading[0]++;
            if(answers[i] == two[i % two.length]) grading[1]++;
            if(answers[i] == three[i % three.length]) grading[2]++;
        }

        int max = Math.max(Math.max(grading[0], grading[1]), grading[2]);

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < 3 ; i++) {
            if(max == grading[i])  {
                result.add(i+1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

}
