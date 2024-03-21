package soli.practice.skillcheck;

import java.util.*;

public class PGS_테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (a, b) -> {
            if(a[col-1] == b[col-1]) {
                return Integer.compare(b[0], a[0]); // 내림차순
            }   else {
                return Integer.compare(a[col-1], b[col-1]); // col 번째 기준 정렬
            }
        });

        int hash = 0;
        for(int i = row_begin ; i <= row_end ; i++) {
            int si = 0;
            for(int j = 0 ; j < data[i-1].length ; j++) {
                si += data[i-1][j] % i;
            }
            hash ^= si;  // 누적해서 hash XOR 계산
        }

        return hash;
    }
}
