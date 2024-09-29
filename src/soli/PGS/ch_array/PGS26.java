package soli.PGS.ch_array;

import java.util.*;

class PGS26 {
    public String solution(String s) {
        
        char[] c = s.toCharArray();
       
        Arrays.sort(c);
      
        StringBuilder sb = new StringBuilder();
        for(int i = c.length -1 ; i >= 0 ; i--) {
            sb.append(Character.toString(c[i]));
        }
        
        return sb.toString();
        // char[] c = s.toCharArray();
        // Arrays.sort(c);
        // return new StringBuilder(new String(c)).reverse().toString();
    }

  public static void main(String[] args){
    PGS26 pgs26 = new PGS26();

    System.out.println("Test Case1 :" + pgs26.solution("adsaeECdsdEZ"));
    
  }
}
