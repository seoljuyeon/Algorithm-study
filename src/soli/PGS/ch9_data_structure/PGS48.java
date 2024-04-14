package soli.PGS.ch9_data_structure;


import java.util.*;

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


public class PGS48 {

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
                // 같은 레벨이면 x 값 작은 거 부터
                if(o1.y == o2.y) {
                    return o1.x - o2.x;
                }
                // 아니면 y값 큰 거 부터
                return o2.y - o1.y;
            }
        });

        Node root = nodes.get(0);

        for(int i = 1 ; i < nodes.size() ; i++) {
            addNode(root, nodes.get(i));
        }

        List<Integer> preorderResult = new ArrayList<>();
        List<Integer> postorderResult = new ArrayList<>();
        preorder(root, preorderResult);
        postorder(root, postorderResult);

        return new int[][]{
                preorderResult.stream().mapToInt(i->i).toArray(),
                postorderResult.stream().mapToInt(i->i).toArray()
        };
    }

    private void addNode(Node parent, Node child) {
        // 자식 노드 있을 때
        if(child.x < parent.x) {
            // 만약에 부모 노드 왼쪽꺼 null 이면 null, 아니면 추가
            if(parent.left == null) {
                parent.left = child;
            } else {
                addNode(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;
            } else {
                addNode(parent.right, child);
            }
        }
    }

    public void preorder(Node node, List<Integer> result) {
        if(node != null) {
            result.add(node.id);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }

    public void postorder(Node node, List<Integer> result) {
        if(node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.id);
        }
    }

    public static void main(String[] args) {

        PGS48 pgs48 = new PGS48();

        int[][] nodeinfo = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};
        int[][] result = pgs48.solution(nodeinfo);
        System.out.println("Preorder: " + Arrays.toString(result[0]));
        System.out.println("Postorder: " + Arrays.toString(result[1]));

    }
}
