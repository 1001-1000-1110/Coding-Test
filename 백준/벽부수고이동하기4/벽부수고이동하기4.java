package 백준.벽부수고이동하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 벽부수고이동하기4 {

    private static int[][] idMap; //속해있는 그룹을 나타냄
    private static int[][] map; //입력받은 맵
    private static Map<Integer, Integer> groups = new HashMap<Integer, Integer>();//그룹별 개수를 저장함.
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n;
    private static int m;

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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        idMap = new int[n][m];
        //map을 초기화
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        //그룹별로 개수를 저장함.
        int groupId = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && idMap[i][j] == 0) {
                    int cnt = bfs(groupId, i, j);
                    groups.put(groupId, cnt);
                    groupId++;
                }
            }
        }
        //map을 출력하기 위해 값을 구함
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    sb.append(calculateCnt(i, j));
                }else{
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int calculateCnt(int x, int y) {
        Set<Integer> visited = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                visited.add(idMap[nx][ny]);
            }
        }

        int cnt = 0;
        for (int id : visited) {
            if (groups.containsKey(id)) {
                cnt += groups.get(id);
            }
        }

        return (cnt + 1) % 10;
    }

    private static int bfs(int groupId, int startX, int startY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        idMap[startX][startY] = groupId;
        int cnt = 0;

        while (!q.isEmpty()) {
            Point now = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && idMap[nx][ny] == 0) {
                    idMap[nx][ny] = groupId;
                    q.add(new Point(nx, ny));
                }
            }
        }
        return cnt;
    }
}
