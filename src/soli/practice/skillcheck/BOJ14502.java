package soli.practice.skillcheck;

import java.io.*;
import java.util.*;

public class BOJ14502 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<int[]> arr;

    public static void main(String[] arags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(board[i][j] == 0) {
                    arr.add(new int[]{i, j});
                }
            }
        }

        int max = 0;

        for(int i = 0 ; i < arr.size() ; i++) {
            int[] first = arr.get(i);
            for(int j = 0 ; j < i ; j++) {
                int[] second = arr.get(j);
                for(int k = 0 ; k < j ; k++) {
                    int[] third = arr.get(k);
                    board[first[0]][first[1]] = 1;
                    board[second[0]][second[1]] = 1;
                    board[third[0]][third[1]] = 1;

                    int safe = countSafe(board);

                    max = Math.max(max, safe);

                    board[first[0]][first[1]] = 0;
                    board[second[0]][second[1]] = 0;
                    board[third[0]][third[1]] = 0;
                }
            }
        }
        System.out.println(max);
    }
    public static int countSafe(int[][] map){
        int safe = 0;

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] == 0) {
                    safe++;
                }
                if(map[i][j] == 2) {
                    spreadVirus(i, j, map);
                }

            }
        }
        return safe;
    }

    public static int spreadVirus(int x , int y, int[][] map) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0 , -1, 1};

        for(int i = 0 ; i < 4 ; i++) {
            for(int j = 0 ; j < 4 ; j++) {
                int nx = x + dx[i];
                int ny = y + dy[j];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(map[nx][ny] == 0) {

                    return map[nx][ny] = 2;
                }
            }
        }
        return x;
    }
}
