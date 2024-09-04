package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Edge {
    Point start;
    Point end;

    public Edge(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(start, edge.start) && Objects.equals(end, edge.end) ||
                Objects.equals(start, edge.end) && Objects.equals(end, edge.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end) + Objects.hash(end, start);
    }
}

public class P48_방의_개수 {
    public static void main(String[] args) {
        P48_방의_개수 p48 = new P48_방의_개수();

        System.out.println(p48.solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0})); // 3
    }

    public int solution(int[] arrows) {
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        Set<Point> visitedNodes = new HashSet<>();
        Set<Edge> visitedEdges = new HashSet<>();

        int x = 0, y = 0;
        visitedNodes.add(new Point(x, y));

        int count = 0;

        for (int arrow : arrows) {
            // 간선 교차 대비 스케일업
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[arrow];
                int ny = y + dy[arrow];

                Point curP = new Point(x, y);
                Point nextP = new Point(nx, ny);
                Edge curE = new Edge(curP, nextP);

                if (visitedNodes.contains(nextP) && !visitedEdges.contains(curE)) {
                    count++;
                }

                visitedEdges.add(curE);
                visitedEdges.add(new Edge(nextP, curP)); // 역방향 간선 추가

                visitedNodes.add(nextP);

                x = nx;
                y = ny;
            }
        }

        return count;
    }
}