package soli.PGS2.ch8_dp;

public class PGS40_정수삼각형 {

    public static int solution(int[][] triangle) {
        int[][] tri = new int[triangle.length][triangle.length];
        tri[0][0] = triangle[0][0];

        for(int i = 1 ; i < tri.length ; i++) {
            tri[i][0] =  tri[i-1][0] + triangle[i][0];

            for(int j = 1 ; j <= i ; j++) {
                tri[i][j] = Math.max(tri[i-1][j], tri[i-1][j-1]) + triangle[i][j];
            }
            tri[i][i] = tri[i-1][i-1] + triangle[i][i];
        }

        int answer = 0;

        for(int i = 0 ; i <  triangle.length ; i++) {
            answer = Math.max(answer, tri[triangle.length - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})); // 30
    }
}
