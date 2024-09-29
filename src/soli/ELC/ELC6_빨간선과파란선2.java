package soli.ELC;

import java.util.*;

public class ELC6_빨간선과파란선2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            a[i] = scanner.nextInt();
        }

        // 초기 상태 설정: 모든 요소가 1인 리스트
        List<Integer> start = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            start.add(1);
        }

        // BFS를 위한 큐와 동적 프로그래밍을 위한 맵 생성
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(start);
        Map<List<Integer>, Integer> dp = new HashMap<>();
        dp.put(start, 0);

        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int currentCost = dp.get(current);

            for (int i = 0; i < current.size(); i++) {
                for (int j = i + 1; j < current.size(); j++) {
                    List<Integer> next = new ArrayList<>(current);
                    next.set(i, current.get(i) + current.get(j));
                    next.remove(j);
                    Collections.sort(next);

                    int idx = N - next.size() - 1; // 인덱스 수정
                    int nextCost = currentCost + (1 - a[idx]) * current.get(i) * current.get(j);

                    if (!dp.containsKey(next) || nextCost < dp.get(next)) {
                        dp.put(next, nextCost);
                        queue.add(next);
                    }
                }
            }
        }

        // 결과를 위한 리스트 생성
        List<Integer> finalState = new ArrayList<>();
        finalState.add(N);

        System.out.println(dp.get(finalState));
    }
}
