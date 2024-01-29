package soli.PGS.ch1_array;

public class PGS4 {

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = checkPlace(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkPlace(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P' && !isSafe(place, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(String[] place, int x, int y) {
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && place[nx].charAt(ny) == 'P') {
                // 붙어있을 때
                if (Math.abs(dx[i]) + Math.abs(dy[i]) == 1) {
                    return false;
                    // 만약 거리 2이면 경로에 X 있는지 확인
                } else if (Math.abs(dx[i]) + Math.abs(dy[i]) == 2) {
                    if (dx[i] == 0 && place[x].charAt((y + ny) / 2) != 'X') {
                        return false;
                    } else if (dy[i] == 0 && place[(x + nx) / 2].charAt(y) != 'X') {
                        return false;
                    } else if (place[x].charAt(ny) != 'X' || place[nx].charAt(y) != 'X') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PGS4 pgs4 = new PGS4();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] result = pgs4.solution(places);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
