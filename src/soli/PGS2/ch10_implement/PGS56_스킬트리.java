package soli.PGS2.ch10_implement;


public class PGS56_스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;


        for(int i = 0 ; i < skill_trees.length ; i++) {
            StringBuilder sb = new StringBuilder();

            for(int j = 0 ; j < skill_trees[i].length() ; j++) {

                for(char c : skill.toCharArray()) {
                    if(skill_trees[i].charAt(j) == c){
                        sb.append(c);
                    } else continue;
                }
            }

            if(skill.startsWith(sb.toString())) {
                answer++;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        PGS56_스킬트리 pgs56 = new PGS56_스킬트리();

        System.out.println(pgs56.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
