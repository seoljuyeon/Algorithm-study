package soli.PGS.ch1_array;

public class PGS4 {

    public int[] solution(String[][] places) {

        int[] answer = new int[5];

        // places 길이만큼(모든 방 방문)
        for(int i = 0 ; i < places.length ; i++) {
            String[] now = places[i];
            boolean check = false;
            // places[i][j] 의 문자 확인
            for(int j = 0 ; j < 5 ; j++) {
                for(int k = 0 ; k < 5 ; k++) {
                    if(now[j].charAt(k) == 'P') {
                        // search 가 true면
                        // check = true
                        if(search(j, k, now)){
                            check = true;
                        }
                    }
                }
            }
            // check가 true 면 0 false면 1
            answer[i] = check ? 0 : 1 ;
        }
        return answer;
    }

    static private boolean search(int x, int y, String[] temp) {

        // x 좌표
        int[] dx = {-1, 1, 0, 0};
        // y 좌표
        int[] dy = {0, 0, -1, 1};

        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx>= 5 || ny >= 5) continue;

            // 상하좌우 확인했는데 P면 check
            if(temp[nx].charAt(ny) == 'P') {
                return true;
            }
        }

        int[] dx2 = {-2, 2, 0, 0};
        int[] dy2 = {0, 0, -2, 2};

        for(int i = 0 ; i< 4 ; i++) {
            int nx = x + dx2[i];
            int ny = y + dy2[i];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

            // 만약 거리가 2일 때
            // 경로가 X 가 아니면
            // 경로 = x + dx 반, y + dy 반
            // check 하기
            if(temp[nx].charAt(ny) == 'P') {
                if(temp[x + dx2[i] / 2].charAt(y + dy2[i] / 2) != 'X') {
                    return true;
                }
            }
        }
        // 대각선 확인
        int[] dx3 = {-1, -1, 1, 1};
        int[] dy3 = {-1, 1, -1, 1};

        for(int i = 0 ; i < 4 ; i ++) {
            int nx = x + dx3[i];
            int ny = y + dy3[i];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

            if(temp[nx].charAt(ny) == 'P'){
                // 만약 둘 사이 경로에 X가 없으면
                // 둘다 만족해야 함
                // check 하기
                if(!(temp[x].charAt(ny) =='X' && temp[nx].charAt(y) == 'X')) {
                    return true;
                }
            }
        }
        return false;
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
