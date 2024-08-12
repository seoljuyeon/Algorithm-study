package soli.PGS2.h7_hash;

import java.util.*;

public class PGS35_중복된문자제거 {

    public String solution(String my_string) {

        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i < my_string.length() ; i++) {
            if(!set.contains(my_string.charAt(i))){
                set.add(my_string.charAt(i));
                sb.append(my_string.charAt(i));
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PGS35_중복된문자제거 pgs35_중복된문자제거 = new PGS35_중복된문자제거();

        System.out.println(pgs35_중복된문자제거.solution("people"));
        System.out.println(pgs35_중복된문자제거.solution("We are the world"));
    }
}
