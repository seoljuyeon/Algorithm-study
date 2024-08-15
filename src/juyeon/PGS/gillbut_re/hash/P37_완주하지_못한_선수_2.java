package juyeon.PGS.gillbut_re.hash;

import java.util.*;

public class P37_완주하지_못한_선수_2 {
    public static void main(String[] args) {
        P37_완주하지_못한_선수_2 p37 = new P37_완주하지_못한_선수_2();

        System.out.println(p37.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"})); // "leo"
        System.out.println(p37.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"})); // "vinko"
        System.out.println(p37.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})); // "mislav"
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String part : participant)
            map.put(part, map.getOrDefault(part, 0) + 1);

        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
            if (map.get(comp) == 0) map.remove(comp);
        }

        return map.keySet().iterator().next();
    }
}
