package soli.PGS.ch10_implement;

public class PGS66 {
    public static void main(String[] args) {
        PGS66 pgs66 = new PGS66();

        System.out.println(pgs66.solution(437674, 3));  // 3
        System.out.println(pgs66.solution(110011, 10)); //10
    }

    public int solution(int n, int k) {

        String trans = Integer.toString(n, k);

        String[] arr = trans.split("0");

        int answer = 0;

        for(String s : arr) {
            if(!s.isEmpty()) {
                long num = Long.parseLong(s);
//                int num = Integer.parseInt(s);

                if(num != 1) {
                    if(isPrime(num)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

//    public boolean isPrime(int num) {
    public boolean isPrime(long num) {

        if(num < 2) {
            return false;
        }

        for(int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
