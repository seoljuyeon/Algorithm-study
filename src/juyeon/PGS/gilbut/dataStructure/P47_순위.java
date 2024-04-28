package juyeon.PGS.gilbut.dataStructure;

public class P47_순위 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})); // 2
    }

    /**
     *
     * 플로이드 - 워셜 ( 그래프 최단 거리 구하는 알고리즘)
     * 인데 이제 머냐면~
     * n명의 선수가 있을 때 나를 제외한 `n-1`명과의 경기 결과를 알면 나의 순위를 알 수 있다 => 는 점을 이용하는 거임~
     *
     * 첨엔 arr를 boolean 배열로 쓰려고 했는데,
     * 이긴다 / 진다 를 t / f 로 나눴을 때,
     * 경기 결과를 아예 모를 때에도 기본값이 f로 있어서 안 되겠더라~ 그래서 int 배열로 했습니동
     *
     * */

    private static int solution(int n, int[][] results) {
        int answer = 0;

        int[][] arr = new int[n + 1][n + 1];

        for (int[] res : results) {
            arr[res[0]][res[1]] = 1;
            arr[res[1]][res[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }

                    if (arr[i][k] == -1 && arr[k][j] == -1) {
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != 0) count++;
            }
            if (count == n - 1) answer++;
        }

        return answer;
    }
}
