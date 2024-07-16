package soli.ELC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ELC6_빨간선과파란선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N-1 ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Map<List<Integer>, Integer> dp = new HashMap<>();
        dp.put(new ArrayList<>(Collections.nCopies(N, 1)), 0);
        Deque<List<Integer>> q = new ArrayDeque<>();
        q.add(new ArrayList<>(Collections.nCopies(N, 1)));
        while (!q.isEmpty()) {
            List<Integer> v = q.pollFirst();
            for(int i = 0 ; i < v.size() ; i++) {
                for (int j = i +1 ; j < v.size() ; j++) {
                    List<Integer> u = new ArrayList<>();
                    for(int k = 0 ; k < v.size() ; k++) {
                        if(k ==i) {
                            u.add(v.get(i) + v.get(j));
                        } else if(k != j) {
                            u.add(v.get(k));
                        }
                    } Collections.sort(u);
                    if(!dp.containsKey(u)) {
                        q.add(u);
                        dp.put(u, dp.get(v) + (1 - a[N-v.size()])* v.get(i) * v.get(j));

                    } else {
                        dp.put(u, Math.min(dp.get(u), dp.get(v) + (1 - a[N-v.size()]) * v.get(i) * v.get(j)));

                    }
                }
            }
        }
        System.out.println(dp.get(Collections.singletonList(N)));
    }
}
