package soli.PGS2.ch2_str;

import soli.PGS.ch2_string.PGS12;

public class PGS12_숫자문자열과영단어 {

    public int solution(String s) {

        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i= 0 ; i < nums.length ; i++) {
            if(s.contains(nums[i])) {
                s = s.replace(nums[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        PGS12_숫자문자열과영단어 pgs12 = new PGS12_숫자문자열과영단어();

        System.out.println("Test Case 1 : " + pgs12.solution("one4seveneight"));
        System.out.println("Test Case 2 : " + pgs12.solution("23four5six7"));
        System.out.println("Test Case 3 : " + pgs12.solution("2three45sixseven"));
        System.out.println("Test Case 2 : " + pgs12.solution("123"));
    }
}
