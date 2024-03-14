package soli.PGS.ch_array;

import java.util.*;

public class PGS29 {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        for (int courseSize : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                char[] orderChars = order.toCharArray();
                Arrays.sort(orderChars);
                combination(new String(orderChars), new StringBuilder(), 0, map, courseSize);
            }
            int maxFrequency = map.values().stream().max(Integer::compare).orElse(0);
            for (String key : map.keySet()) {
                if (map.get(key) == maxFrequency && maxFrequency > 1) {
                    result.add(key);
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void combination(String str, StringBuilder out, int index, Map<String, Integer> map, int courseSize) {
        if (out.length() == courseSize) {
            String combo = out.toString();
            map.put(combo, map.getOrDefault(combo, 0) + 1);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            out.append(str.charAt(i));
            combination(str, out, i + 1, map, courseSize);
            out.deleteCharAt(out.length() - 1);
        }
    }

}
