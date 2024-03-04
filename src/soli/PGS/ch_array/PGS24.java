package soli.PGS.ch_array;

import java.util.*;

class PGS24 {
    public int[] solution(int[] numbers) {
        
        Set<Integer> set = new HashSet<>();
        Arrays.sort(numbers);
        
        for(int i = 0 ; i < numbers.length ; i++) {
            for(int j = i + 1 ; j < numbers.length ; j++) {
                if(!set.contains(numbers[i] + numbers[j])) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(answer);
        return answer;
    }

  public static void main(String[] args){
    PGS24 pgs24 = new PGS24;
    System.out.println("Test case1 : " + Arrays.toString(pgs24.solution(new int[]{2,1,3,4,1});
    System.out.println("Test case2 : " + Arrays.toString(pgs24.solution(new int[]{5,0,2,7});
  }
}
