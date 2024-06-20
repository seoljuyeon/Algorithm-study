package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS14;

public class PGS14_신규아이디추천 {

    public String solution(String new_id) {

        new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[^-_.a-z0-9]", "");

        new_id = new_id.replaceAll("[.]{2,}", ".");

        new_id = new_id.replaceAll("^[.]|[.]$", "");


        if(new_id.isEmpty()) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }

    public static void main(String[] args) {
        PGS14_신규아이디추천 pgs14 = new PGS14_신규아이디추천();

        System.out.println("Test Case1 : " + pgs14.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println("Test Case2 : " + pgs14.solution("z-+.^."));
        System.out.println("Test Case3 : " + pgs14.solution("=.="));
        System.out.println("Test Case4 : " + pgs14.solution("123_.def"));
        System.out.println("Test Case5 : " + pgs14.solution("abcdefghijklmn.p"));

    }
}
