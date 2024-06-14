package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS7;

public class PGS7_이상한문자만들기 {
    public String solution(String s) {

        String[] words = s.split(" ", -1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < words.length ; i++){
            for(int j = 0 ; j < words[i].length() ; j++){
                if(j%2==0){
                    sb.append(Character.toUpperCase(words[i].charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(words[i].charAt(j)));
                }
            }
            if(i < words.length -1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PGS7 pgs7 = new PGS7();

        System.out.println("Test Case1 : " + pgs7.solution("try hello world"));
        System.out.println("Test Case2 : " + pgs7.solution("space  bar  here  "));
    }
}
