package soli.PGS.ch2_string;

public class PGS9 {

    public int solution(int n) {

        StringBuffer sb = new StringBuffer(Integer.toString(n, 3));
        String s = sb.reverse().toString();

        return Integer.parseInt(s, 3);
    }

    public static void main(String[] args) {
        PGS9 pgs9 = new PGS9();
        System.out.println("Test Case1 : " + pgs9.solution(45));
        System.out.println("Test Case2 : " + pgs9.solution(125));
    }
}
