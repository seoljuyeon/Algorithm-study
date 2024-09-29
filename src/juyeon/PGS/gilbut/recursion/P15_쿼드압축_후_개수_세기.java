package juyeon.PGS.gilbut.recursion;

public class P15_쿼드압축_후_개수_세기 {
    public static void main(String[] args) {
        int[][] testCase1 =
                {{1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}};

        int[][] testCase2 =
                {{1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1}};

        System.out.println("testCase1 : [" + solution(testCase1)[0] + ", " + solution(testCase1)[1] + "]"); // [4, 9]
        System.out.println("testCase2 : [" + solution(testCase2)[0] + ", " + solution(testCase2)[1] + "]"); // [10, 15]
    }

    private static int[] answer;

    private static int[] solution(int[][] arr) {
        answer = new int[2];

        recursion(arr, 0, 0, arr.length);

        return answer;
    }

    private static void recursion(int[][] arr, int x, int y, int size) {
        if (compress(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        recursion(arr, x, y, size / 2);
        recursion(arr, x + size / 2, y, size / 2);
        recursion(arr, x, y + size / 2, size / 2);
        recursion(arr, x + size / 2, y + size / 2, size / 2);

    }

    private static boolean compress(int[][] arr, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }
}
