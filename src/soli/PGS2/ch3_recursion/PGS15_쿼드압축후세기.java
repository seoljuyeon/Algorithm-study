package soli.PGS2.ch3_recursion;

public class PGS15_쿼드압축후세기 {


    public static int[] solution(int[][] arr) {

        return new int[]{0,0};
    }

    public static void main(String[] args) {

        int[][] arr = {
                {1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,1,1,1}
        };
        int[] result = solution(arr);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
