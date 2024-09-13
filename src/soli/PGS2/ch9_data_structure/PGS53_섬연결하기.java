package soli.PGS2.ch9_data_structure;

import java.util.Arrays;

public class PGS53_섬연결하기 {

    public int solution(int n, int[][] costs) {

        int[] islands = new int[n];

        int sum = 0;

        for(int i = 0 ; i <  n ; i++) {
            islands[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for(int i = 0 ; i < costs.length ; i++) {
            // 연결 됐는지 확인
            if(find(islands, costs[i][0]) != find(islands, costs[i][1])) {
                union(islands, costs[i][0], costs[i][1]);
                sum += costs[i][2];
            }
        }
        return sum;
    }

    private int find(int[] islands, int x) {
        // 루트 찾을 때 까지 반복
        if(islands[x] == x) return x;
        return find(islands, islands[x]);
    }

    private void union(int[] islands, int x, int y) {
        // 집합 하나로 합치기
        int a = find(islands, x);
        int b = find(islands, y);
        islands[a] = b;
    }

    public static void main(String[] args) {

        PGS53_섬연결하기 pgs53_섬연결하기 = new PGS53_섬연결하기();

        System.out.println(pgs53_섬연결하기.solution(4, new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})); // 4
    }


}
