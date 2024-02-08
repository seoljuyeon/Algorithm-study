package soli.PGS.ch2_string;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class PGS12 {
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
        PGS12 pgs12 = new PGS12();

        System.out.println("Test Case 1 : " + pgs12.solution("one4seveneight"));
        System.out.println("Test Case 2 : " + pgs12.solution("23four5six7"));
        System.out.println("Test Case 3 : " + pgs12.solution("2three45sixseven"));
        System.out.println("Test Case 2 : " + pgs12.solution("123"));
    }
}
