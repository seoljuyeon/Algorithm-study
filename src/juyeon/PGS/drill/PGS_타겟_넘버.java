package juyeon.PGS.drill;

public class PGS_타겟_넘버 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3)); // 5
    }

    private static int count = 0;

    private static int solution(int[] numbers, int target) {

        DFS(0, numbers, target, 0);

        return count;
    }

    private static void DFS(int idx, int[] numbers, int target, int sum) {
        if (idx == numbers.length) {
            if (sum == target) count++;
        } else {
            DFS(idx + 1, numbers, target, sum + numbers[idx]);
            DFS(idx + 1, numbers, target, sum - numbers[idx]);
        }
    }
}
