package juyeon.BOJ.ch9;

import doitproblems.ch9_tree.P67_11725;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P67_11725_트리의_부모_찾기 implements P67_11725 {
    private static ArrayList<Integer>[] tree;
    private static int[] parent;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            bw.write(Integer.toString(parent[i]));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void DFS(int k) {

        visited[k] = true;

        for (int e : tree[k]) {
            if (!visited[e]) {
                parent[e] = k;
                DFS(e);
            }
        }
    }

}
