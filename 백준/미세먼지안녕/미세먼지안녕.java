package 백준.미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
    static int R, C, T;
    static int[][] map;
    static Point topAir;
    static Point downAir;

    static class Point {
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

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (topAir == null) {
                        topAir = new Point(i, j);
                    } else {
                        downAir = new Point(i, j);
                    }
                }
            }
        }

        //문제풀이
        int ans = solve();
        System.out.println(ans);
    }


    private static int solve() {
        for (int i = 0; i < T; i++) {
            //확산
            spread();
            //청소
            refresh();
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }

    private static void refresh() {
        //위쪽
        turnOnUp();
        //아래쪽
        turnOnDown();
    }

    private static void turnOnDown() {
        int[] dx = {1, 0, -1, 0,};
        int[] dy = {0, 1, 0, -1,};
        int x = downAir.x + dx[0];
        int y = downAir.y + dy[0];

        for (int i = 0; i < 4; i++) {

            while (x + dx[i] >= 0 && x + dx[i] < R && y + dy[i] >= 0 && y + dy[i] < C
                    && x + dx[i] >= downAir.x && map[x + dx[i]][y + dy[i]] != -1) {
                map[x][y] = map[x + dx[i]][y + dy[i]];
                map[x + dx[i]][y + dy[i]] = 0;
                x = x + dx[i];
                y = y + dy[i];
            }
        }
    }

    private static void turnOnUp() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = topAir.x + dx[0];
        int y = topAir.y + dy[0];

        for (int i = 0; i < 4; i++) {

            while (x + dx[i] >= 0 && x + dx[i] < R && y + dy[i] >= 0 && y + dy[i] < C
                    && x + dx[i] <= topAir.x && map[x + dx[i]][y + dy[i]] != -1) {
                map[x][y] = map[x + dx[i]][y + dy[i]];
                map[x + dx[i]][y + dy[i]] = 0;
                x = x + dx[i];
                y = y + dy[i];
            }
        }

    }

    private static void spread() {
        int[][] temp = new int[R][C];

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        //모든 구역을 순회하면서(에어컨자리 제외)
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {//먼지가 존재하는 경우
                    //현위치에서 영향받은 곳을 temp에 저장
                    int cnt = 0; //확산된 횟수 //최소0 최대4
                    int value = map[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
                            cnt++;
                            temp[nx][ny] += value;//확산된 곳에 값을 저장함.
                        }
                    }
                    map[i][j] -= value * cnt;
                }
            }
        }
        //결과를 다시 map에 더함
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (temp[i][j] > 0) {
                    map[i][j] += temp[i][j];
                }
            }
        }
    }
}
