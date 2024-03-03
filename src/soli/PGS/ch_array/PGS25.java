package soli.PGS.ch_array;

import java.util.*;

class PGS25 {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int answer = 0;
        int n = citations.length;
        
        for(int i = n ; i >= 0 ; i--) {
            int count = 0;
            for(int j = 0 ; j < n ; j++){
                if(i <= citations[j]){
                    count++;
                }
            }
            if(count >= i) {
                answer = i;
                return answer;
            }
        }
        
        return answer;
    }

  public static void main(String[] args) {
    PGS25 pgs25 = new PGS25();
    
    System.out.println("Test case1 :" + pgs25.solution(new int[]{3, 0, 6, 1, 5}));
  }
}
