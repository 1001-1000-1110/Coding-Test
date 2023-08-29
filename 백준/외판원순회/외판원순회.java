package 백준.외판원순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회 {
    static int[][] dp;//dp[노드][방문했는지]
    static int[][] map;
    static int N;
    static int visitedAll;
    static int INF = Integer.MAX_VALUE;
    static int MIN = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //한번만 방문할 수 있다...?

        map = new int[N + 1][N + 1];
        //인접리스트 초기화;
        for (int i = 1; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N;  j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visitedAll = (1 << N) - 1;
        dp = new int[N + 1][visitedAll + 1];
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 0 ; j <= visitedAll ; j++) {
                dp[i][j] = INF;
            }
        }
        dp[1][1] = 0;

        tsp(1,1);
        System.out.println(MIN);
    }

    private static void tsp(int now, int visited) {
        if(visited == visitedAll){
            if(map[now][1] == 0)
                return;
            MIN = Math.min(MIN, dp[now][visited] + map[now][1]);
        }

        for(int i = 1; i <= N; i++){
            int nextVisited = (1 << (i - 1)) | visited;
            if(map[now][i] == 0){ //해당 경로로 이동할 수 없는 경우
                continue;
            }
            if(nextVisited == visited){ //이미 방문했던 경우
                continue;
            }
            if(dp[i][nextVisited] > dp[now][visited] + map[now][i]){
                dp[i][nextVisited] = dp[now][visited] + map[now][i];
                tsp(i, nextVisited);
            }
        }
    }


}
