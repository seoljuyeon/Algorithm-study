package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

class Node {
    int idx;
    int x;
    int y;
    Node left;
    Node right;

    public Node(int id, int x, int y) {
        this.idx = id;
        this.x = x;
        this.y = y;
    }
}

public class P49_길_찾기_게임 {
    public static void main(String[] args) {
        P49_길_찾기_게임 p49 = new P49_길_찾기_게임();

        int[][] answer = p49.solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});

        System.out.println(Arrays.toString(answer[0]));
        System.out.println(Arrays.toString(answer[1]));

        // {{7,4,6,9,1,8,5,2,3}, {9,6,5,8,1,4,3,2,7}}
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> tree = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            tree.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        // y값이 큰 거 -> 같은 레벨이면 x값이 작은 거
        Collections.sort(tree, ((o1, o2) -> {
            if (o1.y == o2.y) return o1.x - o2.x;
            else return o2.y - o1.y;
        }));

        Node root = tree.get(0);

        // 자식 노드 삽입
        for (int i = 1; i < tree.size(); i++) {
            insertNode(root, tree.get(i));
        }

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        preorder(root, pre);
        postorder(root, post);

        return new int[][] {
                pre.stream().mapToInt(e -> e).toArray(),
                post.stream().mapToInt(e -> e).toArray()
        };
    }

    private void insertNode(Node parent, Node child) {
        // 부모 노드 x > 자식 노드 x -> 자식 노드는 왼쪽 서브트리
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    // 전위 순회
    private void preorder(Node node, List<Integer> pre) {
        pre.add(node.idx);
        if (node.left != null) preorder(node.left, pre);
        if (node.right != null) preorder(node.right, pre);
    }

    // 후위 순회
    private void postorder(Node node, List<Integer> post) {
        if (node.left != null) postorder(node.left, post);
        if (node.right != null) postorder(node.right, post);
        post.add(node.idx);
    }
}