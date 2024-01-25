package soli.PGS.ch1_array;

import java.util.Arrays;

public class PGS2 {
    public String[] solution(int[][] line) {
        boolean[][] graph = new boolean[1001][1001];

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0 ; i < line.length ; i++) {
            for(int j = i+1 ; j < line.length ; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];

                int A = line1[0];
                int B = line1[1];
                int C = line1[2];
                int D = line2[0];
                int E = line2[1];
                int F = line2[2];

                int divide = A*E - B*D ;
                if(divide != 0) {
                    // 나누기 전 x, y
                    long xNumerator = (long) (-E * C + B * F);
                    long yNumerator = (long) (C * D - A * F);

                    // 교점이 정수인지 확인
                    // 나눠서(교점)에서 0이 나오면 나눠지는 거니까 -> 정수
                    if (xNumerator % divide == 0 && yNumerator % divide == 0) {
                        int x = (int) (xNumerator / divide);
                        int y = (int) (yNumerator / divide);

                        // 좌표 마이너스이면 안되니까 옮겨주기
                        int idx_x = x + 500;
                        int idx_y = y + 500;

                        // 교점 좌표가 배열 범위 내에 있는지 확인
                        if (idx_x >= 0 && idx_x < 1001 && idx_y >= 0 && idx_y < 1001) {

                            // 그래프에 표시
                            graph[idx_x][idx_y] = true;

                            minX = Math.min(minX, idx_x);
                            minY = Math.min(minY, idx_y);
                            maxX = Math.max(maxX, idx_x);
                            maxY = Math.max(maxY, idx_y);
                        }
                    }
                }
            }
        }


        String[] answer = new String[maxY - minY +1];
        for(int i = maxY ; i >= minY ; i--) {
            StringBuilder sb = new StringBuilder();
            for(int j = minX ; j <= maxX ; j++){
                // 그래프 true 이면
                if(graph[j][i]) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            answer[maxY - i] = sb.toString();
        }

        return answer;
    }


    public static void main(String[] args) {
        PGS2 solution = new PGS2();

        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 0, -1000}, {0, 1, -1000}, {1, -1, 0}})));
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 0}, {-1, 1, 0}, {1, -1, 0}})));
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, 0, -1}, {0, 1, -1}, {1, 0, 1}, {0, 1, 1}, {1, -1, 0}})));
        System.out.println(Arrays.toString(solution.solution(new int[][]{{100000, 0, 0}, {0, 100000, 0}, {-100000, 100000, 100000}, {100000, 100000, -100000}})));
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, 1, 1}, {1, 1, 2}, {1, 1, 3}, {1, 1, 4}})));
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, -1, 0}, {2, -1, 0}})));
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}})));
    }
}
