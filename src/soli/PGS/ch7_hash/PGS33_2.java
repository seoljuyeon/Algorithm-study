package soli.PGS.ch7_hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PGS33_2 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for(String p : phone_book) {
            for(int i = 0 ; i < p.length() ; i++) {
                if(set.contains(p.substring(0, i))){
                    return false;
                }
            }
        }
        return true;
    }
}
