package juyeon.PGS.gillbut_re.string;

public class P12_숫자_문자열과_영단어_2 {
    public static void main(String[] args) {
        P12_숫자_문자열과_영단어_2 p12 = new P12_숫자_문자열과_영단어_2();

        System.out.println(p12.solution("one4seveneight")); // 1478
        System.out.println(p12.solution("23four5six7")); // 234567
        System.out.println(p12.solution("2three45sixseven")); // 234567
        System.out.println(p12.solution("123")); // 123
    }

    public int solution(String s) {
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            if (s.contains(eng[i])) {
                s = s.replaceAll(eng[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }
}