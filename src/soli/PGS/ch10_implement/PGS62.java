package soli.PGS.ch10_implement;

public class PGS62 {

    public int solution(int n, int[] lost, int[] reserve) {

        int[] students = new int[n];

        int answer = 0;

        for(int r : reserve){
            students[r-1] = 1;
        }
        for(int l : lost){
            students[l - 1] = students[l-1] - 1;
        }

        for(int i = 0 ; i < n ; i++) {
            if(i == 0) {
                if(students[i] == -1 && students[i+1] == 1) {
                    students[i] = 0;
                    students[i] = 0;
                }
            } else if (i == n - 1) {
                if (students[i] == -1 && students[i - 1] == 1) {
                    students[i] = 0;
                    students[i - 1] = 0;
                }
            } else {
                if(students[i] == -1 && students[i-1] == 1) {
                    students[i-1] = 0;
                    students[i] = 0;
                }
                if (students[i] == -1 && students[i+1] == 1 && i+1 < n) {
                    students[i+1] = 0;
                    students[i] = 0;
                }
            }

        }

        for(int i = 0 ; i < n ; i++) {
            if(students[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        PGS62 pgs62 = new PGS62();

        System.out.println(pgs62.solution(5, new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(pgs62.solution(5, new int[]{2,4}, new int[]{3}));
        System.out.println(pgs62.solution(3, new int[]{3}, new int[]{1}));

    }
}
