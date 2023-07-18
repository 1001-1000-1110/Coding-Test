package 백준.벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
    public static void main(String[] args) throws IOException {
        //n,m을 입력받음
        //3차원 visited배열생성 [N][M][[2]  [][][0]인경우, 벽을 부수지 않음 [][][1]인경우 벽을부숨
        //bfs를 통해서 n,m까지 도달이 가능한지 확인함
        //q에 넣을 정보(현재좌표(x,y), 현재 좌표까지 도달한 거리)

        //[0]인경우 벽이 있으면 [1]로 넘어갈 수 있음(방문처리)
        //[1]인경우 벽은 도달하지 못함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }


        int ans = Integer.MAX_VALUE;

        boolean[][][] visited = new boolean[n + 1][m + 1][2];
        visited[1][1][0] = true;
        visited[1][1][1] = true;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(1, 1, 1, 0));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Info now = q.poll();
            if (now.x == n && now.y == m) {
                ans = now.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                //상하좌우 방향의 좌표를 탐색함.
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                //맵을 벗어나지 않는 경우 탐색함.
                if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= m) {
                    if (map[nextX][nextY] == 0) {//벽이 아닌 경우
                        if (visited[nextX][nextY][now.check])continue; //기존에 방문한곳은 다시 방문하지 않음.
                        visited[nextX][nextY][now.check] = true;
                        q.add(new Info(nextX, nextY, now.cnt + 1, now.check));
                    } else { //벽인경우
                        if (now.check == 1 || visited[nextX][nextY][1]) continue;
                        visited[nextX][nextY][1] = true;
                        q.add(new Info(nextX, nextY, now.cnt + 1, 1));
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);

    }

    static class Info {
        int x;
        int y;
        int cnt;
        int check;

        public Info(int x, int y, int cnt, int check) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.check = check;
        }
    }
}
