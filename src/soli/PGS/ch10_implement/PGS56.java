package soli.PGS.ch10_implement;

public class PGS56 {

    int answer = 0;
    public int solution(int[] numbers, int target){

        dfs(numbers, target, 0,0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(sum == target) answer++;
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]);
            dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
    }


    public static void main(String[] args) {

        PGS56 pgs56 = new PGS56();

        System.out.println(pgs56.solution(new int[]{1,1,1,1,1}, 3));
        System.out.println(pgs56.solution(new int[]{4,1,2,1}, 4));

    }
}
