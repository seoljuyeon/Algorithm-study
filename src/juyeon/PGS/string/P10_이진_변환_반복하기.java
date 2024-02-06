package juyeon.PGS.string;

public class P10_이진_변환_반복하기 {
    public static void main(String[] args) {
        String testCase1 = "110010101001"; // 3, 8
        String testCase2 = "01110"; // 3, 3
        String testCase3 = "1111111"; // 4, 1

        System.out.println("testCase1 : [" + solution(testCase1)[0] + ", " + solution(testCase1)[1] + "]");
        System.out.println("testCase2 : [" + solution(testCase2)[0] + ", " + solution(testCase2)[1] + "]");
        System.out.println("testCase3 : [" + solution(testCase3)[0] + ", " + solution(testCase3)[1] + "]");
    }

    private static int[] solution(String s) {
        int[] answer = new int[2];

        int count = 0;
        int zero = 0;

//        while (!s.equals("1")) {
//            count++;
//            s = s.replace("0", "");
//            int c = s.length();
//            s = Integer.toString(c, 2);
//        }

        while (!s.equals("1")) {
            count++;
            int one = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    one++;
                } else {
                    zero++;
                }
            }

            s = Integer.toString(one, 2);
        }

        answer[0] = count;
        answer[1] = zero;

        return answer;
    }
}
