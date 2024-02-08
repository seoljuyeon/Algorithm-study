package soli.PGS.ch2_string;

public class PGS7 {
    public String solution(String s) {
        // 문자열 끝에 공백 처리
        String[] arr = s.split(" ", -1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < arr.length ; i++) {
            if(i>0) sb.append(" ");
            for(int j = 0 ; j < arr[i].length() ; j++) {
                if(j%2 == 0) {
                    sb.append(Character.toUpperCase(arr[i].charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(arr[i].charAt(j)));
                }
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
