package juyeon.PGS.gilbut.implementation;

import java.util.*;

public class P56_스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"})); // 2
    }

    private static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        HashSet<Character> set = new HashSet<>();

        for (char c : skill.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);
                if (set.contains(c)) sb.append(c);
            }

            if (skill.startsWith(sb.toString())) answer++;
        }

        return answer;
    }
}
