package juyeon.PGS.drill.lv3;

import java.util.*;

public class PGS_여행경로 {
    public static void main(String[] args) {
        PGS_여행경로 pgs_여행경로 = new PGS_여행경로();

        // "ICN", "JFK", "HND", "IAD"
        System.out.println(Arrays.toString(pgs_여행경로.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));

        // "ICN", "ATL", "ICN", "SFO", "ATL", "SFO"
        System.out.println(Arrays.toString(pgs_여행경로.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }

    List<String> list;
    boolean[] used;

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        used = new boolean[tickets.length];

        // StringBuilder
        DFS(0, "ICN", new StringBuilder("ICN"), tickets);

        // String
//        DFS(0, "ICN", "ICN", tickets);

        Collections.sort(list);

        // String
//        return list.get(0).split(" ");

        // StringBuilder
        return list.get(0).split(" ");
    }

    // StringBuilder
    private void DFS(int depth, String from, StringBuilder sb, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(from)) {
                used[i] = true;

                int len = sb.length();
                sb.append(" ").append(tickets[i][1]);

                DFS(depth + 1, tickets[i][1], sb, tickets);

                used[i] = false;
                sb.setLength(len);
            }
        }
    }

    // String
//    private void DFS(int depth, String from, String route, String[][] tickets) {
//        if (depth == tickets.length) {
//            list.add(route);
//            return;
//        }
//
//        for (int i = 0; i < tickets.length; i++) {
//            if (!used[i] && tickets[i][0].equals(from)) {
//                used[i] = true;
//                DFS(depth + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
//                used[i] = false;
//            }
//        }
//    }
}

// String
// 테스트 1 〉	통과 (111.91ms, 109MB)
// 테스트 2 〉	통과 (13.52ms, 82.4MB)
// 테스트 3 〉	통과 (10.08ms, 75.3MB)
// 테스트 4 〉	통과 (13.17ms, 78.4MB)

// StringBuilder
// 테스트 1 〉	통과 (65.44ms, 105MB)
// 테스트 2 〉	통과 (0.38ms, 80MB)
// 테스트 3 〉	통과 (0.41ms, 73.2MB)
// 테스트 4 〉	통과 (0.39ms, 75.6MB)