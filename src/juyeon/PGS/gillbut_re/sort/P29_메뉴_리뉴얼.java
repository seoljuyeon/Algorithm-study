package juyeon.PGS.gillbut_re.sort;

import java.util.*;

public class P29_메뉴_리뉴얼 {
    public static void main(String[] args) {
        P29_메뉴_리뉴얼 p29 = new P29_메뉴_리뉴얼();

        System.out.println(Arrays.toString(p29.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2, 3, 4})));
        // "AC", "ACDE", "BCFG", "CDE"

        System.out.println(Arrays.toString(p29.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        // "ACD", "AD", "ADE", "CD", "XYZ"

        System.out.println(Arrays.toString(p29.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
        // "WX", "XY"
    }

    Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        int idx = 0;

        for (String str : orders) {
            char[] temp = str.toCharArray();

            Arrays.sort(temp);

            orders[idx++] = String.valueOf(temp);
        }

        for (int i = 0; i < course.length; i++) {
            int n = course[i];

            map = new HashMap<>();

            for (String order : orders) {
                if (order.length() >= n) {
                    combination(order, new StringBuilder(), 0, 0, n);
                }
            }

//            int max = Integer.MIN_VALUE;
//
//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                max = Math.max(max, entry.getValue());
//            }

            int max = map.values().stream().max(Integer::compare).orElse(0);

//            if (max >= 2) {
//                for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                    if (entry.getValue() == max) list.add(entry.getKey());
//                }
//            }

            if (max >= 2) {
                map.entrySet().stream()
                        .filter(e -> e.getValue() == max)
                        .forEach(e -> list.add(e.getKey()));
            }
        }

        Collections.sort(list);

        return list.toArray(String[]::new);
    }

    private void combination(String str, StringBuilder sb, int idx, int count, int n) {
        if (count == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));

            combination(str, sb, i + 1, count + 1, n);

            sb.delete(count, count + 1);
        }
    }
}
