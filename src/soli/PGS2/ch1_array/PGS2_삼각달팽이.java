package soli.PGS2.ch1_array;

import java.util.ArrayList;
import java.util.List;

public class PGS2_삼각달팽이 {
    public int[] solution(int n) {
        // 삼각형을 나타낼 2차원 배열 초기화
        int[][] triangle = new int[n][n];
        int value = 1;
        int x = 0, y = 0;

        // 방향: 아래(0), 오른쪽(1), 위쪽(2)
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int direction = 0;

        while (value <= n * (n + 1) / 2) {
            triangle[x][y] = value++;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 경계를 넘거나 이미 값이 있는 경우 방향 전환
            if (nx >= n || ny >= n || nx < 0 || ny < 0 || triangle[nx][ny] != 0) {
                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;
        }

        // 결과 배열 생성
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                resultList.add(triangle[i][j]);
            }
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}
