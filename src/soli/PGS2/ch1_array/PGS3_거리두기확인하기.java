package soli.PGS2.ch1_array;

public class PGS3_거리두기확인하기 {

    public int[] solution(String[][] places) {
        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        PGS3_거리두기확인하기 pgs3 = new PGS3_거리두기확인하기();

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] result = pgs3.solution(places);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
