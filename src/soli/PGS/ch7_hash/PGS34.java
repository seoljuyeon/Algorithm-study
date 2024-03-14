package soli.PGS.ch7_hash;

import java.util.HashSet;
import java.util.Set;

public class PGS34 {

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

    }

}
