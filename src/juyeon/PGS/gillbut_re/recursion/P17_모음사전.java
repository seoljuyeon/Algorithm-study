package juyeon.PGS.gillbut_re.recursion;

public class P17_모음사전 {
    public static void main(String[] args) {
        P17_모음사전 p17 = new P17_모음사전();

//        System.out.println(p17.solution("AAAAE")); // 6
//        System.out.println(p17.solution("AAAE")); // 10
        System.out.println(p17.solution("I")); // 1563
//        System.out.println(p17.solution("EIO")); // 1189
    }

    char[] AEIOU = {'A', 'E', 'I', 'O', 'U'};

    public int count = 0, answer = 0;

    public int solution(String word) {
        dfs("", word);

        return answer;
    }

    public void dfs(String cur, String word) {
        if (cur.length() == 5 || cur.equals(word)) {
            if (cur.equals(word)) {
                answer = count;
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            count++;
            dfs(cur + AEIOU[i], word);
        }
    }
}

