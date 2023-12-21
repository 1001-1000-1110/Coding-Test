package 백준.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
    static int N, M;
    static int[][] map;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int maxSafetyZone;
    static int safetyZone;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        List<Point> zeros = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
                if (map[i][j] == 0) {
                    zeros.add(new Point(i, j));
                }
            }
        }

        //3가지 경우 선택
        for (int i = 0; i < zeros.size(); i++) {
            Point p1 = zeros.get(i);
            for (int j = i + 1; j < zeros.size(); j++) {
                Point p2 = zeros.get(j);
                for (int k = j + 1; k < zeros.size(); k++) {
                    Point p3 = zeros.get(k);

                    buildAWall(p1);
                    buildAWall(p2);
                    buildAWall(p3);

                    //bfs를 통한 안전구역 확인
                    checkSafetyZone();

                    breakAWall(p1);
                    breakAWall(p2);
                    breakAWall(p3);
                }
            }
        }

        System.out.println(maxSafetyZone);
    }

    private static void printMap() {
        for(int t = 0;  t < N; t++){
            for(int q = 0; q < M; q++){
                System.out.print(map[t][q]+" ");
            }
            System.out.println();
        }
    }

    private static void checkSafetyZone() {
        safetyZone = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        maxSafetyZone = Math.max(safetyZone, maxSafetyZone);

    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Point(x, y));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int safetyZoneCnt = 1;
        boolean isValid = true;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1 && !visited[nx][ny]) {
                    if (map[nx][ny] == 2) {
                        isValid = false;
                    }
                    visited[nx][ny] = true;
                    safetyZoneCnt++;
                    q.add(new Point(nx, ny));
                }
            }
        }
        if(isValid){
            safetyZone += safetyZoneCnt;
        }

    }

    private static void breakAWall(Point point) {
        map[point.x][point.y] = 0;
    }

    private static void buildAWall(Point point) {
        map[point.x][point.y] = 1;
    }
}
