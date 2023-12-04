package 백준.별찍기11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기11 {

    private static char[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n * 2];

        drawStar(0, n-1, n);
        printStar();
    }

    private static void printStar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2; j++) {
                char value = ' ';
                if (map[i][j] == '*') {
                    value = '*';
                }
                sb.append(value);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void drawStar(int x, int y, int length) {
        if (length == 3) {
            //정점 별찍기
            map[x][y] = '*';
            // 중간층 별찍기
            map[x + 1][y - 1] = '*';
            map[x + 1][y + 1] = '*';
            // 바닥 별찍기
            for (int i = 0; i < 5; i++) {
                map[x + 2][y - 2 + i] = '*';
            }
            return;
        }
        //상단
        drawStar(x, y, length / 2);
        //좌하단
        drawStar(x + length / 2, y - length / 2, length / 2);
        //우하단
        drawStar(x + length / 2, y + length / 2, length / 2);
    }
}
