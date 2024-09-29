package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P53_섬_연결하기 {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})); // 4
    }

    private static int[] parent;

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    private static int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> (o1[2] - o2[2]));

        for (int i = 0; i < costs.length; i++) {
            int x = costs[i][0];
            int y = costs[i][1];
            int cost = costs[i][2];

            if (find(x) != find(y)) {
                union(x, y);
                answer += cost;
            }
        }
        return answer;
    }
}
