package 백준.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 스도쿠 {
    static int N = 9;
    static int[][] map = new int[N][N];
    static List<Point> zeroPoints = new ArrayList<>(); //채워야 하는 좌표를 저장함.
    static boolean isEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //9*9맵 필요
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 0) { //0인경우 숫자를 채워야하는 point이므로 저장
                    zeroPoints.add(new Point(i, j));
                }
            }
        }
        dfs(0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    private static void dfs(int index) {
        if (index == zeroPoints.size()) {
            isEnd = true;  //스도쿠가 처음 완성되면 더이상 재귀를 반복하지 않고 종료함.
            return;
        }
        Point now = zeroPoints.get(index);
        for (int i = 1; i <= N; i++) {
            map[now.x][now.y] = i;
            if (checkCol(now.x, now.y) && checkRow(now.x, now.y) && checkSquare(now.x, now.y)) {
                dfs(index + 1);
            }
            if (isEnd) { //스도쿠가 처음 완성되면 더이상 재귀를 반복하지 않고 종료함.
                return;
            }
            map[now.x][now.y] = 0;
        }
    }

    //[][][]
    //[][][]
    //[][][] 처럼 좌표(point)가 포함된 3*3 크기의 구간에 중복되는 값이 없는지 확인함.
    private static boolean checkSquare(int x, int y) {
        //각 좌표의 작은 3*3 사각형 구간의 시작지점을 정함.
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (startX + i == x && startY + j == y) continue;
                if (map[startX + i][startY + j] == map[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    //가로에 동일한 값이 있는지 확인
    private static boolean checkRow(int x, int y) {
        for (int i = 0; i < N; i++) {
            if (i == y)
                continue;
            if (map[x][y] == map[x][i]) {
                return false;
            }
        }
        return true;
    }

    //세로에 동일한 값이 있는지 확인
    private static boolean checkCol(int x, int y) {
        for (int i = 0; i < N; i++) {
            if (i == x)
                continue;
            if (map[x][y] == map[i][y]) {
                return false;
            }
        }
        return true;
    }


    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
