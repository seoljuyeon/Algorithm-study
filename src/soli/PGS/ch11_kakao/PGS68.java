package soli.PGS.ch11_kakao;

import java.util.Arrays;

public class PGS68 {

    /**
     * 둘 다 0 받을 때, 어피치가 이길 때, 라이언이 이길 때
     * 어피치가 이길 때는 0점 ~ 1점 낮게 돌리면 어피치가 점수 get
     * 모든 경우를 다 돌아야 하기 때문에 dfs 사용
     * ⭐ 가장 큰 점수 차
     * ⭐ 동일한 점수 차일 경우 가장 낮은 점수를 많이 맞힌 경우 선택
     */

    static int[] bestResult = {-1}; // 이길 수 없을 때
    static int[] lion; // 라이언 화살 저장 배열
    static int max = Integer.MIN_VALUE; // 최대 점수 차이

   public void dfs(int[] info, int idx, int remaing, int lionScore, int appeachScore){
       // 모든 점수 다 탐색한 경우
       if(idx == 11) {
           // 다 탐색하고도 화살 남았을 때
           if (remaing > 0) {
               lion[10] += remaing; // 남은 화살 0 에 쏘기 > 작은 값에 넣어야 하니까
           }


           // 점수 차이 계산
           int scoreDifference = lionScore - appeachScore;

           // 만약에 라이언이 어피치보다 높을 때
           if (scoreDifference > 0) {
               // 만약에 max 값보다 score 차 높거나 -> 조건1. 점수차 최대
               // 점수차 똑같을 때 -> 조건2. 낮은 점수에 많이 맞춘 거
               if (scoreDifference > max || (scoreDifference == max && isBetterResult(lion, bestResult))) {
                   bestResult = lion.clone();   // 최적의 결과 복사
                   max = scoreDifference;
               }
           }

           if(remaing > 0) {
               lion[10] -= remaing; // 앞에서 썼던 거 다음 재귀를 위해 다시 복구
           }
           return;  // 재귀 호출에서 반환 X,  현재 함수 실행 종료 후 현재 함수를 부른 곳으로 돌아 가서 다음 절차 진행, 재귀 호출은 계속 일어 난다.
       }

       //라이언이 현재 점수 구간을 이기기 위해 화살 쏠 때
       if(remaing > info[idx]) {
           lion[idx] = info[idx] + 1; // 어피치보다 한 발 더 쏘기
           dfs(info, idx +1, remaing - lion[idx], lionScore + (10-idx), appeachScore);  // 쏜 화살만큼 줄이고 다음 인덱스 넘어 가기
           lion[idx] = 0; // 다음에 불러 올 탐색에 영향을 주지 않기 위해 0으로 초기화
       }

       // 라이언이 현재 점수 포기(지는)하는 경우
       if(info[idx] > 0) {
           dfs(info, idx + 1, remaing, lionScore, appeachScore + (10-idx));
       } else {
           dfs(info, idx + 1, remaing, lionScore, appeachScore); // 0 이면 같이 0이니까
       }
   }

   // 현재 결과가 더 나은지 비교
    public boolean isBetterResult(int[] current, int[] best) {
       // 작은 수가 많은 거 부터 확인해야 하니까 인덱스 거꾸로 탐색
       for(int i = 10 ; i >= 0 ; i-- ) {
           // 현재 best라고 되어 있는 배열값보다 낮은 값 더 많으면 true
           if(current[i] > best[i]) {
               return true;
               // 만약에 더 작으면 false 같을 때는 없으니까 else if로 비교
           } else if (current[i] < best[i]) {
               return false;
           }
       }
       return false;
    }

    public int[] solution(int n, int[] info) {

        lion = new int[11];
        // dfs(info, idx, n - i, lionScore, appeachScore);
        dfs(info, 0, n, 0, 0);

        return bestResult;
    }

    public static void main(String[] args) {
       PGS68 pgs68 = new PGS68();

        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(pgs68.solution(n, info)));

        n = 1;
        info = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(pgs68.solution(n, info)));

        n = 9;
        info = new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(pgs68.solution(n, info)));

        n = 10;
        info = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        System.out.println(Arrays.toString(pgs68.solution(n, info)));
    }
}
