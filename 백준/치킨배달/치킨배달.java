package 백준.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static List<Point> homes = new ArrayList<>();
    private static List<Point> chickens = new ArrayList<>();
    private static boolean[] visited;
    private static int Min = Integer.MAX_VALUE;

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new Point(i, j));
                }
                if (map[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[chickens.size()];

        solve(0, 0);
        System.out.println(Min);

    }

    private static void solve(int index, int length) {
        if (length == M) {
            findTheShortestPath();
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            //선택o
            visited[i] = true;
            solve(i + 1, length + 1);
            visited[i] = false;
            //선택x
//            solve(i + 1, length);
        }
    }

    private static void findTheShortestPath() {
        //집과 치킨집 사이의 거리
        int totalDist = 0;
        for (Point home : homes) {
            int dist = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (visited[i]) {
                    dist = Math.min(dist, calculateDist(home, chickens.get(i)));
                }
            }
            totalDist += dist;
        }

        Min = Math.min(Min, totalDist);
    }

    private static int calculateDist(Point home, Point chicken) {
        return Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
    }
}
