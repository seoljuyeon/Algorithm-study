package soli.PGS.ch3_recursion;

public class PGS17_weights {
    public static int solution(String word) {
        int answer = 0;
        int[] weights = {781, 156, 31, 6, 1};

        char[] letters = {'A', 'E', 'I', 'O', 'U'};

        for(int i = 0 ; i < word.length() ; i++) {
            for(int j = 0 ; j < letters.length ; j++) {
                if(word.charAt(i) == letters[j]) {
                    answer += 1 + j * weights[i]; // 현재 자리의 알파벳에 따른 순서 계산
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        String[] testCases = {"AAAAE", "AAAE", "I", "EIO"};
        for (String word : testCases) {
            System.out.println(word + ": " + solution(word));
        }
    }
}
