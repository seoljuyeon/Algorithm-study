package soli.PGS.ch6_binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PGS30 {

    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    static ArrayList<Integer> score = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        for(String i : info) {
            dfs(0, "", i.split(" "));
        }

        for(ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }

        answer = new int[query.length];
        int i = 0 ;
        for(String q : query) {
            String[] data = q.split(" and ");

            String[] s = data[3].split(" ");
            int target = Integer.parseInt(s[1]);
            data[3] = s[0];

            String key = String.join("", data);

            if(map.containsKey(key)){
                ArrayList<Integer> list = map.get(key);

                int start = 0;
                int end = list.size() - 1;

                while(start <= end) {
                    int mid = (start + end) / 2;

                    if(list.get(mid) < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                answer[i] = list.size()-start;
            }
            i++;
        }
        return answer;
    }

    static void dfs(int depth, String query, String[] info) {
        if(depth == 4) {
            if(!map.containsKey(query)) {
                score = new ArrayList<>();
                score.add(Integer.parseInt(info[4]));   // 점수 추가
                map.put(query, score);
            } else {
                map.get(query).add(Integer.parseInt(info[4]));
            } return;
        }
        dfs(depth + 1, query + "-", info);
        dfs(depth + 1, query + info[depth], info);
    }

    public static void main(String[] args) {

    }
}
