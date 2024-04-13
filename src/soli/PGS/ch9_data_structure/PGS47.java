package soli.PGS.ch9_data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Node {
    int x;  // x좌표
    int y;  // y좌표
    int id;
    Node left;   // 왼쪽 자식 -> 자식 노드를 가짐
    Node right;  // 오른쪽 자식 -> 자식 노드를 가짐

    public Node(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.left = null;
        this.right = null;
    }
}

public class PGS47 {

    Node node;

    public int[][] solution(int[][] nodeinfo) {

        List<Node> nodes = new ArrayList<>();

        // 노드 입력
        for(int i = 0 ; i < nodeinfo.length ; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }

        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return 0;
            }
        });


        int answer[][] = {};
        return answer;
    }

    public static void main(String[] args) {
        PGS47 pgs47 = new PGS47();

        System.out.println("TEST CASE : " + pgs47.solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}}));
    }
}
