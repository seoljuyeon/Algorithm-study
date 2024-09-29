package soli.ELC;

import java.util.*;
import java.io.*;

class ELC4_트리위의게임 {
    static ArrayList<Integer>[] tree;
    static int[] answer;
    static boolean[] visited;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        answer = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N ; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);

        }

        dfs(1);

        for(int i = 1 ; i <= N ; i++) {
            System.out.println(answer[i]);
        }

    }

    public static int dfs(int node) {

        visited[node] = true;

        int childcnt = 1;

        for(int child : tree[node]) {
            if(!visited[child]) {
                childcnt += dfs(child);

            }
        }

        if(childcnt % 2 == 1) {
            answer[node] = 1;
        } else {
            answer[node] = 0;
        }
        return childcnt;
    }
}


