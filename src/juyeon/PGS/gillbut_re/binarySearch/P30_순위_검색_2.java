package juyeon.PGS.gillbut_re.binarySearch;

import java.util.*;

public class P30_순위_검색_2 {
    public static void main(String[] args) {
        P30_순위_검색_2 p30 = new P30_순위_검색_2();

        System.out.println(Arrays.toString(p30.solution(    // [1,1,1,1,2,4]
                new String[]{"java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"})));
    }

    private HashMap<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++)
            DFS(info[i].split(" "), "", 0);

        for (List<Integer> list : map.values())
            Collections.sort(list);

        for (int i = 0; i < query.length; i++)
            answer[i] = binarySearch(query[i]);

        return answer;
    }

    private void DFS(String[] info, String str, int depth) {
        if (depth == 4) {
            int score = Integer.parseInt(info[depth]);

            if (map.containsKey(str)) map.get(str).add(score);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(score);
                map.put(str, list);
            }

            return;
        }

        DFS(info, str + "-", depth + 1);
        DFS(info, str + info[depth], depth + 1);
    }

    private int binarySearch(String query) {
        String[] q = query.split(" and ");
        query = q[0] + q[1] + q[2] + q[3].split(" ")[0];
        int score = Integer.parseInt(q[3].split(" ")[1]);

        if (!map.containsKey(query)) return 0;

        List<Integer> list = map.get(query);

        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (score <= list.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return list.size() - start;
    }
}
