package soli.PGS.ch3_recursion;

public class PGS_cola {

    public int solution(int n, int a, int b){

        // 만약에 가지고 온 수가 a 보다 작으면
        if(n < a) {
            return 0;
        }
        // 아니면
        int cola = (n / a) * b;

        return cola + solution(cola + (n % a), a, b);
    }

    public static void main(String[] args) {
        PGS_cola pgsCola = new PGS_cola();

        System.out.println("Test Case 1: " + pgsCola.solution(20, 2, 1));
        System.out.println("Test Case 2: " + pgsCola.solution(20, 3, 1));
        System.out.println("Test Case 3: " + pgsCola.solution(20, 3, 2));
    }
}
