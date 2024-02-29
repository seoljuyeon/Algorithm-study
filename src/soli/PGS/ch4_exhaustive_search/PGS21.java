package soli.PGS.ch4_exhaustive_search;

import java.util.HashSet;
import java.util.Set;

public class PGS21 {
    public static int solution(String numbers) {
        // 만들 수 있는 모든 숫자를 저장하는 set
        Set<Integer> set = new HashSet<>();
        String num = "";
        recursion(numbers, set, num);
        int answer = 0;
        for(int number : set) {
            if(isPrime(number)){
                answer++;
            }
        }

        return answer;
    }

    // numbers 에서 만들 수 있는 모든 숫자 만들어서 set에 저장
    private static void recursion(String numbers, Set<Integer> set, String num){
        if(!num.isEmpty() && !num.startsWith("0")){
            set.add(Integer.parseInt(num));
        }
        for(int i = 0 ; i < numbers.length() ; i++) {
            recursion(numbers.substring(0, i) + numbers.substring(i+1, numbers.length()),set,num + numbers.charAt(i));
        }
    }

    private static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }
        for(int i = 2 ; i < Math.sqrt(number) ; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }


}
