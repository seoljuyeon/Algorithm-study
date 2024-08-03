package soli.PGS2.ch6_binary_search;

import java.util.*;

public class PGS30_순위검색 {

    static HashMap<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        map = new HashMap<String, List<Integer>>();

        for(int i = 0 ; i < info.length ; i++) {
            String[] q = info[i].split(" ");
            // dfs 돌면서 info 내 모든 조건을 생성하게 함
            dfs(q, "", 0);
        }

        // 조건 조합에 대해 점수 리스트 정렬
        // 이진탐색을 위해서는 리스트가 정렬되어 있어야 한다.
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        // 쿼리 배열 돌면서 쿼리 처리
        for(int i = 0 ; i < query.length ; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            // 숫자 앞까지 전부 하나로
            String[] q = query[i].split(" ");
            // 조건에 해당하는 리스트 있으면 점수(q[1])를 통해 이진탐색으로 결과 계산, 없으면 0
            answer[i] = map.containsKey(q[0])? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    public static void dfs(String[] q, String s, int depth){
        if(depth == 4) {
            // 조합에 q 가 없으면 추가
            if(!map.containsKey(s)){
                List<Integer> list = new ArrayList<Integer>();
                map.put(s, list);
            }
            // 해당 조건 조합에 점수 추가
            // 왜..?
            map.get(s).add(Integer.parseInt(q[4]));
            return;
        }
        // 단어 + "-" 조합 만들기...
        dfs(q, s+"-", depth+1);
        // 단어 + 단어 조합 만들기
        dfs(q, s+q[depth], depth+1);
    }

    public static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < score) start = mid +1;
            else end = mid - 1;
        }
        // 주어진 점수 이상인 지원자의 수 반환
        return list.size() - start;

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
