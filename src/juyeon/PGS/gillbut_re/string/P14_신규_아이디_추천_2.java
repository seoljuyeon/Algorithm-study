package juyeon.PGS.gillbut_re.string;

public class P14_신규_아이디_추천_2 {
    public static void main(String[] args) {
        P14_신규_아이디_추천_2 p14 = new P14_신규_아이디_추천_2();

        System.out.println(p14.solution("...!@BaT#*..y.abcdefghijklm")); // "bat.y.abcdefghi"
        System.out.println(p14.solution("z-+.^.")); // "z--"
        System.out.println(p14.solution("=.=")); // "aaa"
        System.out.println(p14.solution("123_.def")); // "123_.def"
        System.out.println(p14.solution("abcdefghijklmn.p")); // "abcdefghijklmn"
    }

    public String solution(String new_id) {

        // 1 소문자로
        String id = new_id.toLowerCase();

        // 2 소문자, 숫자, -, _, . 제외 모두 제거
        id = id.replaceAll("[^a-z0-9-_.]", "");

        // 3 마침표 두 개 이상 연속 -> 한 개로
        while (id.contains("..")) {
            id = id.replaceAll("\\.\\.", ".");
        }

        // 4 처음이나 끝이 마침표면 제거
        id = id.replaceAll("^[.]|[.]$", "");

        // 5 빈 문자열이면 "a"
        if (id.isEmpty()) id = "a";

        // 6 길이가 16 이상이라면 자르기
        if (id.length() >= 16) id = id.substring(0, 15);

        // + 마지막 문자가 . 이면 지우기
        id = id.replaceAll("[.]$", "");

        // 7 아이디가 2자 이하면 마지막 문자 반복해 3자로 만들기
        if (id.length() < 3) {
            char c = id.charAt(id.length() - 1);
            while (id.length() < 3) {
                id += c;
            }
        }

        return id;
    }
}
