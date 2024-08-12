package soli.PGS2.h7_hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PGS34_전화번호목록 {
    public boolean solution(String[] phone_book) {

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for(String p : phone_book) {
            for(int i = 0 ; i < p.length() ; i++) {
                if(set.contains(p.substring(0,i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PGS34_전화번호목록 pgs34_전화번호목록 = new PGS34_전화번호목록();

        System.out.println(pgs34_전화번호목록.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(pgs34_전화번호목록.solution(new String[]{"123","456","789"}));
        System.out.println(pgs34_전화번호목록.solution(new String[]{"12","123","1235","567","88"}));
    }
}
