package juyeon.PGS.gilbut.implementation;

public class P58_타켓_넘버 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
//        System.out.println(solution(new int[]{4, 1, 2, 1}, 4)); // 2
    }

    private static int count = 0;
    private static int solution(int[] numbers, int target) {
        DFS(0, numbers, target, 0);

        return count;
    }

    private static void DFS(int idx, int[] numbers, int target, int num) {
        int len = numbers.length;

        if (idx == len) {
            if (num == target) count++;
        } else {
            DFS(idx + 1, numbers, target, num + numbers[idx]);
            DFS(idx + 1, numbers, target, num - numbers[idx]);
        }
    }
}
