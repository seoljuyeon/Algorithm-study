package soli.PGS.ch3_recursion;

public class PGS15 {
    static int[] answer = new int[2];

    public static int[] solution(int[][] arr) {

        quad(arr, 0, 0, arr.length);

        return answer;
    }

    private static void quad(int[][] arr, int x, int y, int size) {

        // 전체 사이즈에서 반 나누기
        if(compression(arr, x, y, size)) {
            // 똑같은 거 있는지 확인하고 있으면 true, 없으면 false
            // 있으면 count
            answer[arr[x][y]]++;
        }
        // 남은 사이즈에서 반 나누기
        else {
            int newsize = size / 2;
            quad(arr, x, y, newsize);
            quad(arr, x, y+newsize, newsize);
            quad(arr, x+newsize, y, newsize);
            quad(arr, x+newsize, y+newsize, newsize);
        }
    }

    private static boolean compression(int[][] arr, int x, int y, int size) {
        // 확인 할 숫자
        int num = arr[x][y];

        for(int i = x ; i < x + size ; i++) {
            for(int j = y ; j  < y + size ; j++) {
                if(arr[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] arr = {
                {1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,1,1,1}
        };
        int[] result = solution(arr);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

}
