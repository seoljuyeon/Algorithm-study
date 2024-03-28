package juyeon.PGS.gilbut.array;

import java.util.LinkedList;
import java.util.Queue;

public class P03_거리두기_확인하기 {
    public static void main(String[] args) {
        String[][] places =
                {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] result = solution(places);

        for (int i = 0; i < 5; i++) {
            System.out.print(result[i]);
        }
        // 1, 0, 1, 1, 1
    }

    private static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int k = 0; k < 5; k++) {
            String[] room = places[k];
            boolean isGood = true;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (room[i].charAt(j) == 'P') {
                        if (!BFS(i, j, room)) {
                            isGood = false;
                            break;
                        }
                    }
                }
                if (!isGood) break;
            }

            answer[k] = isGood ? 1 : 0;
        }


        return answer;
    }

    private static boolean BFS(int x, int y, String[] room) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y)) continue;

                int d = Math.abs(nx - x) + Math.abs(ny - y);

                if (room[nx].charAt(ny) == 'P' && d <= 2) return false;
                else if (room[nx].charAt(ny) == 'O' && d < 2) {
                    q.add(new int[]{nx, ny});
                }

            }
        }
        return true;
    }
}
