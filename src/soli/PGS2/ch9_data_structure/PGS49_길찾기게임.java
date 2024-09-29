package soli.PGS2.ch9_data_structure;


import java.util.*;

public class PGS49_길찾기게임 {

    class Node{
        int x;
        int y;
        int num;

        Node left;
        Node right;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.left = null;
            this.right = null;
        }
    }

    Node node;

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();

        for(int i = 0 ; i < nodeinfo.length ; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }

        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // 높이 같으면 x 값 작은 거 부터 (왼쪽)
                if(o1.y == o2.y) {
                    return o1.x - o2.x;
                } return o2.y - o1.y;
            }
        });

        Node root = nodes.get(0);

        for(int i = 1; i < nodes.size() ; i++) {
            addNode(root, nodes.get(i));
        }

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preorder(root, pre);
        postorder(root, post);

        return new int[][]{
                pre.stream().mapToInt(i -> i).toArray(),
                post.stream().mapToInt(i -> i).toArray()
        };
    }

    public void addNode(Node parent, Node child) {
        if(child.x < parent.x) {
            if(parent.left == null) parent.left = child;
            else addNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else addNode(parent.right, child);
        }
    }

    public void preorder(Node node, List<Integer> result) {
        if(node != null) {
            result.add(node.num);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }

    public void postorder(Node node, List<Integer> result) {
        if(node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.num);
        }
    }

    public static void main(String[] args) {
        PGS49_길찾기게임 pgs49 = new PGS49_길찾기게임();

        int[][] nodeinfo = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};
        int[][] result = pgs49.solution(nodeinfo);
        System.out.println("Preorder: " + Arrays.toString(result[0]));
        System.out.println("Postorder: " + Arrays.toString(result[1]));

    }
}
