package soli.PGS.ch2_string;

public class PGS11_lambda {
    boolean solution(String s) {

        s = s.toLowerCase();

        return s.chars().filter( e -> 'p' == e).count() == s.chars().filter(e -> 'y' == e).count();

    }

    public static void main(String[] args) {

        PGS11 pgs11 = new PGS11();

        System.out.println("Test Case1 " + pgs11.solution("pPoooyY"));
        System.out.println("Test Case1 " + pgs11.solution("Pyy"));

    }
}
