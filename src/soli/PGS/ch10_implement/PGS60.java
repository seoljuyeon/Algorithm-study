package soli.PGS.ch10_implement;

import java.util.*;

public class PGS60 {
    public int solution(String begin, String target, String[] words) {

        int n = words.length;
        boolean[] visited = new boolean[n];

        if(Arrays.asList(words).contains(target)) {
            return changeword(begin, target, words, visited);
        }

        return 0;
    }

    public int changeword(String begin, String target, String[] words, boolean[] visited){
        int targetchar = 0;

        for(int i = 0 ; i < begin.length() ; i++) {
            if(begin.charAt(i) != target.charAt(i)) {
                targetchar++;
            }
        }

        if(targetchar == 1) {
            return 1;
        }

        for(int i = 0 ;  i < words.length ; i++) {
            if(!visited[i] && check(begin, words[i])) {
                visited[i] = true;
                int answer = changeword(words[i], target, words, visited);
                if(answer > 0) {
                    return answer + 1; // answer++ 하면 나중에 더해져서 안됨
                }
                visited[i] = false;
            }
        }
        return 0;
    }

    public boolean check(String begin, String word) {
        int charcount = 0;

        for(int i = 0 ; i < begin.length() ; i++) {
            if(begin.charAt(i) != word.charAt(i)) {
                charcount++;
                if(charcount > 1) {
                    return false;
                }
            }
        }
        return charcount == 1;
    }

    public static void main(String[] args) {
        PGS60 pgs60 = new PGS60();

        System.out.println(pgs60.solution("hit", "cog", new String[]{"hot",  "dot", "dog", "lot", "log", "cog"}) );
        System.out.println(pgs60.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}) );
    }
}
