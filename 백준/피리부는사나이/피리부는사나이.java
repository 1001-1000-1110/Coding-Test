package 백준.피리부는사나이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피리부는사나이 {
    static char[][] map;
    static int n,m;
    static int cnt = 0;
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new int[n][m];
        for(int i = 0;  i< n; i++){
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int id = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0){
                    cnt++;
                    dfs(++id, i,j);
                }
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int id, int x, int y) {
        if(visited[x][y] != 0){
            if(visited[x][y] != id){
                cnt--;
            }
            return;
        }
        visited[x][y] = id;
        int dir = getDir(map[x][y]);
        dfs(id, x + dx[dir], y +dy[dir]);
    }

    private static int getDir(char c) {
        if(c == 'U'){
            return 0;
        }else if (c == 'D'){
            return 1;
        }else if (c == 'L'){
            return 2;
        }else{
            return 3;
        }
    }
}
