package soli.practice.skillcheck;

import java.io.*;
import java.util.*;

public class BOJ13460 {
    static int N, M;
    static char[][] c;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0 , -1, 1};

    static class Ball {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int count;

        public Ball(int redY, int redX, int blueY, int blueX, int count) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        c = new char[N][M];

        for(int i = 0 ; i < N ; i++) {
            c[i] = br.readLine().toCharArray();
        }

        Ball ball = new Ball(0,0,0,0, 0);

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(c[i][j] == 'R' || c[i][j] == 'B') {
                    if(c[i][j] == 'R') {
                        ball.redY = i;
                        ball.redX = j;

                    } else {
                        ball.blueY = i;
                        ball.blueX = j;

                    }
                }
            }
        }
        System.out.println(bfs(ball));
    }

    public static int bfs(Ball ball){
        Queue<Ball> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M]; // 두 구슬이 있는 위치에 갔던 곳인지 확인하기 위해

        queue.offer(ball);
        visited[ball.redY][ball.redX][ball.blueY][ball.blueX] = true;

        while(!queue.isEmpty()) {
            Ball current = queue.poll();

            if(current.count > 10) return -1;

            if(c[current.redY][current.redX] == 'O' && c[current.blueY][current.blueX] != 'O') {
                return current.count;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nextRedY = current.redY;
                int nextRedX = current.redX;
                int nextBlueY = current.blueY;
                int nextBlueX = current.blueX;

                while(c[nextRedY + dy[i]][nextRedX + dx[i]] != '#' && c[nextRedY][nextRedX] != 'O') {
                    nextRedY += dy[i];
                    nextRedX += dx[i];
                }
                while(c[nextBlueY + dy[i]][nextBlueX + dx[i]] != '#' && c[nextBlueY][nextBlueX] != 'O') {
                    nextBlueY += dy[i];
                    nextBlueX += dx[i];
                }
                // 만약에 같은 위치에 놓여진다면
                // 더 멀리서 온 구슬 (더 뒤에 놓여져 있던 구슬을 뒤에 위치 시킨다.)
                if(nextRedY == nextBlueY && nextRedX == nextBlueX) {
                    if(c[nextRedY][nextRedX] == 'O') continue;

                        int redDistance = Math.abs(nextRedY - current.redY) + Math.abs(nextRedX - current.redX);
                        int blueDistance = Math.abs(nextBlueY - current.blueY) + Math.abs(nextBlueX - current.blueX);
                        // 만약 red가 더 뒤에서 왔으면 red를 한칸 뒤로
                        if(redDistance > blueDistance) {
                            nextRedY -= dy[i];
                            nextRedX -= dx[i];
                        } else {    // blue가 뒤에서 왔으면 blue를 한 칸 뒤로
                            nextBlueY -= dy[i];
                            nextBlueX -= dx[i];
                        }

                }
                if(!visited[nextRedY][nextRedX][nextBlueY][nextBlueX]) {
                    visited[nextRedY][nextRedX][nextBlueY][nextBlueX] = true;
                    queue.offer(new Ball(nextRedY, nextRedX, nextBlueY, nextBlueX, current.count + 1));
                }
            }
        }
        return -1;
    }
}