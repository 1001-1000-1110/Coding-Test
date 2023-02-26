package 백준.미로탐색;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[][] map;
    static int[][] depthArr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0;  j < m; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        depthArr = new int[n][m];
        bfs(0,0);
        bw.write(depthArr[n-1][m-1]+"");
        bw.flush();
        bw.close();

    }

    private static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        visited[row][col] = true;
        depthArr[row][col] = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowRow = now[0];
            int nowCol = now[1];
            for(int i = 0; i <4; i++){
                int nextRow = nowRow + dx[i];
                int nextCol = nowCol + dy[i];
                if(nextRow>=0 && nextRow < n && nextCol >=0 && nextCol<m){
                    if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                        visited[nextRow][nextCol] = true;
                        q.add(new int[]{nextRow, nextCol});
                        depthArr[nextRow][nextCol] = depthArr[nowRow][nowCol] + 1;
                    }
                }
            }
        }
    }
}
