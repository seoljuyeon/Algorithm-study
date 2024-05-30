package soli.PGS.ch11_kakao;

public class PGS70 {

    public int solution(int[][] board, int[][] skill){
        int answer = 0;

        for(int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            // 만약에 1이면 파괴
            if (type == 1) {
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        board[i][j] -= degree;
                    }
                }
            } else {
                // 2면 회복
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        board[i][j] += degree;
                    }
                }
            }
        }
        // 1이상인 건물 수 세기
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(board[i][j] > 0) {
                    answer++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        PGS70 pgs70 = new PGS70();

        int[][] board1 = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill1 = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(pgs70.solution(board1, skill1));

        int[][] board2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill2 = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        System.out.println(pgs70.solution(board2, skill2));
    }
}
