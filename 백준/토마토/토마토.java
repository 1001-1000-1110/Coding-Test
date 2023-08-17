package 백준.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토 {
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //bfs를 통해 상하좌우로 이동시킴,
        //-1을 반환하는 경우는 어떻게 판단할 것인가?
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());//열
        n = Integer.parseInt(st.nextToken());//행

        map = new int[n][m];

        int zeroCnt = 0;
        ArrayList<Info> onePoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroCnt++;
                }
                if (map[i][j] == 1){
                    onePoints.add(new Info(i,j,0));
                }
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
            return;
        }


        visited = new boolean[n][m];
        bfs(onePoints, zeroCnt);


        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static void bfs(ArrayList<Info> onePoints, int zeroCnt) {
        Queue<Info> q = new LinkedList<>();

        for (Info point : onePoints) {
            q.add(new Info(point.x, point.y, 0));
            visited[point.x][point.y] = true;
        }


        int max = 0;
        while (!q.isEmpty()) {
            Info now = q.poll();

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        q.add(new Info(nx, ny, now.cnt + 1));
                        max = Math.max(max, now.cnt + 1);
//                        System.out.println(now.cnt + 1);
                        zeroCnt--;
                    }
                }
            }
        }

//        System.out.println("zeroCnt = " + zeroCnt);
        if (zeroCnt == 0) {
            result = Math.min(result, max);
        }

    }

    static class Info {
        int x;
        int y;
        int cnt; //몇번 이동했는지

        public Info(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
