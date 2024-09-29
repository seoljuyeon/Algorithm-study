package soli.PGS.ch7_hash;

public class PGS33 {
    public int solution(int[][] dots) {
        int answer = 0;

        for(int i = 0 ; i < dots.length ; i++) {

            double slope = getSlope(dots[i], dots[(i+1)%4]);
            double slope2 = getSlope(dots[(i+2)%4], dots[(i+3)%4]);

            if(slope == slope2) {
                answer = 1;
            }
        }
        return answer;
    }
    public static double getSlope(int[] dot1, int[] dot2) {
        return (double)(dot1[1] - dot2[1]) / (dot1[0] - dot2[0]);
    }
}
