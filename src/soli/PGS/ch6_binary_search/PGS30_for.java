package soli.PGS.ch6_binary_search;

import java.util.*;

public class PGS30_for {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        // info 배열 파싱 및 저장
        for(String i : info) {
            String[] parts = i.split(" ");
            String[] languages = {parts[0], "-"};
            String[] jobGroups = {parts[1], "-"};
            String[] careers = {parts[2], "-"};
            String[] soulFoods = {parts[3], "-"};
            int score = Integer.parseInt(parts[4]);

            for(String language : languages) {
                for(String jobGroup : jobGroups) {
                    for(String career : careers) {
                        for(String soulFood : soulFoods) {
                            String key = language + " " + jobGroup + " " + career + " " + soulFood;
                            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                            list.add(score);
                            map.put(key, list);
                        }
                    }
                }
            }
        }

        for(String key : map.keySet()) {
            List<Integer> scores = map.get(key);
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        int idx = 0;

        for(String q : query) {
            String[] parts = q.replaceAll(" and ", " ").split(" ");
            String key = parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3];
            int score = Integer.parseInt(parts[4]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            int count = 0;
            for(int s : list) {
                if(s >= score) count++;
            }
            answer[idx++] = count;
        }

        return answer;
    }
}
