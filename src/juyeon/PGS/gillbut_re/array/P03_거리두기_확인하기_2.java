package juyeon.PGS.gillbut_re.array;

import java.util.*;

public class P03_거리두기_확인하기_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}))); // [1, 0, 1, 1, 1]
    }

    private static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int k = 0; k < 5; k++) {
            String[] room = places[k];

            boolean isGood = true;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (room[i].charAt(j) == 'P') {
                        isGood = BFS(i, j, room);
                        if (!isGood) break;
                    }
                }
                if (!isGood) break;
            }

            answer[k] = isGood ? 1 : 0 ;
        }

        return answer;
    }

    private static boolean BFS(int x, int y, String[] room) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = point[0] + dx[k];
                int ny = point[1] + dy[k];

                if (OOB(nx, ny) || visited[nx][ny]) continue;

                int d = Math.abs(x - nx) + Math.abs(y - ny);

                if (room[nx].charAt(ny) == 'P' && d <= 2) return false;
                else if (room[nx].charAt(ny) == 'O' && d < 2) {
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return true;
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || y < 0 || x >= 5 || y >= 5;
    }
}
