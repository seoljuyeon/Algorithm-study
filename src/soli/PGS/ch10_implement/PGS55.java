package soli.PGS.ch10_implement;

public class PGS55 {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {

        PGS55 pgs55 = new PGS55();

        System.out.println(pgs55.solution( new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5} , "right"));
        System.out.println(pgs55.solution( new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2} , "left"));
        System.out.println(pgs55.solution( new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0} , "right"));
    }
}
