package soli.PGS2.ch1_array;

public class PGS3_거리두기확인하기 {

    public int[] solution(String[][] places) {

        int[] result = new int[5];

        // 방 5개
        for(int i = 0 ; i < 5 ; i++) {
            // i 번째 대기실
            result[i] = isPossible(places[i]);
        }

        return result;
    }

    public int isPossible(String[] place) {
        // 상하좌우 방향 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 2칸 거리 방향 벡터
        int[] dx2 = {-2, 2, 0, 0};
        int[] dy2 = {0, 0, -2, 2};

        // 대각선 방향 벡터
        int[] dx3 = {-1, -1, 1, 1};
        int[] dy3 = {1, -1, -1, 1};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    // 상하좌우 체크
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && place[nx].charAt(ny) == 'P') {
                            return 0;
                        }
                    }
                    // 2칸 거리 체크
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx2[k];
                        int ny = j + dy2[k];
                        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && place[nx].charAt(ny) == 'P') {
                            if (place[i + dx2[k] / 2].charAt(j + dy2[k] / 2) != 'X') {
                                return 0;
                            }
                        }
                    }
                    // 대각선 체크
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx3[k];
                        int ny = j + dy3[k];
                        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && place[nx].charAt(ny) == 'P') {
                            if (!(place[i].charAt(ny) == 'X' && place[nx].charAt(j) == 'X')) {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
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
