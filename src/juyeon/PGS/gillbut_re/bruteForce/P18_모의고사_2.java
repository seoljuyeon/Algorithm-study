package juyeon.PGS.gillbut_re.bruteForce;

import java.util.*;

public class P18_모의고사_2 {
    public static void main(String[] args) {
        P18_모의고사_2 p18 = new P18_모의고사_2();

        System.out.println(Arrays.toString(p18.solution(new int[]{1, 2, 3, 4, 5}))); // [1]
        System.out.println(Arrays.toString(p18.solution(new int[]{1, 3, 2, 4, 2}))); // [1, 2, 3]
    }

    public int[] solution(int[] answers) {
        int[] fst = new int[] {1, 2, 3, 4, 5};
        int[] sec = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] trd = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<int[]> list = new ArrayList<>();

        list.add(fst);
        list.add(sec);
        list.add(trd);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int[] temp = list.get(i);
            int count = 0;
            int idx = 0;
            for (int k : answers) {
                if (k == temp[idx % temp.length]) count++;
                idx++;
            }
            map.put(i, count);
        }

        int max = Math.max(map.get(0), Math.max(map.get(1), map.get(2)));

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (map.get(i) == max) ans.add(i + 1);
        }

        return ans.stream().mapToInt(e -> e).toArray();
    }
}
