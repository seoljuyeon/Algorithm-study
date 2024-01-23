package juyeon.BOJ.ch9;

import doitproblems.ch9_tree.P68_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P68_1068_트리 implements P68_1068 {
    private static ArrayList<Integer>[] tree;
    private static boolean[] visited;
    private static int delete;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());

            if (k != -1) {
                tree[i].add(k);
                tree[k].add(i);
            }
            else root = i;
        }

        delete = Integer.parseInt(br.readLine());

        visited = new boolean[N];

        answer = 0;

        if (root == delete) System.out.println(0);
        else {
            DFS(root);
            System.out.println(answer);
        }

    }

    private static void DFS(int v) {
        visited[v] = true;

        int count = 0;

        for (int e : tree[v]) {
            if (!visited[e] && e != delete) {
                count++;
                DFS(e);
            }
        }

        if (count == 0) answer++;
    }
}