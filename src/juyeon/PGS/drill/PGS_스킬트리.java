package juyeon.PGS.drill;

import java.util.*;

public class PGS_스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"})); // 2
    }

    private static int solution(String skill, String[] skill_trees) {
        int count = 0;

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            set.add(c);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);
                if (set.contains(c)) sb.append(c);
            }

            String str = sb.toString();

            if (skill.startsWith(str)) count++;
        }

        return count;
    }
}
