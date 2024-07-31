package soli.PGS2.ch6_binary_search;

import java.util.*;

public class PGS30 {

    static HashMap<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        map = new HashMap<String, List<Integer>>();

        for(int i = 0 ; i < info.length ; i++) {
            String[] s = info[i].split(" ");
            dfs(s, "", 0);
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for(int i = 0 ; i < query.length ; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;

    }

    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return list.size() - start;
    }


    public static void dfs(String[] s, String q, int depth) {
        if(depth == 4) {
            if(!map.containsKey(q)){
                List<Integer> list = new ArrayList<Integer>();
                map.put(q, list);
            }
            map.get(q).add(Integer.parseInt(s[4])); // 점수
            return;
        }
        dfs(s, q+"-" , depth+1);
        dfs(s, q+s[depth], depth+1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(    // [1,1,1,1,2,4]
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


}
