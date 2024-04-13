package soli.PGS.ch9_data_structure;

import java.util.ArrayList;

public class PGS47 {


    ArrayList<int[]>[] a;

    public int[][] solution(int[][] nodeinfo) {

        int[][] answer = new int[2][nodeinfo.length];


        a = new ArrayList[nodeinfo.length + 1];
        for(int i = 1; i <= nodeinfo.length ; i++){
            a[i] = new ArrayList<int[]>();
        }




        return answer;
    }

    public static void main(String[] args) {
        PGS47 pgs47 = new PGS47();

        System.out.println("TEST CASE : " + pgs47.solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}}));
    }
}
