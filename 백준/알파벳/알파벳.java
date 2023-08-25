package 백준.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
    static int r,c;
    static boolean[][] visited;
    static boolean[] alpha = new boolean[26];
    static char[][] map;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r ; i++) {
           map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[r][c];

        visited[0][0] = true;
        alpha[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt) {

        if(cnt > max){
            max = cnt;
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( nx >= 0 && nx <r && ny >= 0 && ny < c && !visited[nx][ny] && !alpha[map[nx][ny] - 'A']){
                visited[nx][ny] = true;
                alpha[map[nx][ny] - 'A'] = true;
                dfs(nx, ny,cnt + 1);
                visited[nx][ny] = false;
                alpha[map[nx][ny]- 'A'] = false;
            }
        }
    }
}
