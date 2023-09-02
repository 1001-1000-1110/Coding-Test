package 백준.외판원순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회 {
    static int[][] dp;//dp[현재 노드][현재 노드를 포함, 방문한 노드를 비트마스크로 나타냄]
    static int[][] map;
    static int N;
    static int visitedAll;//모두 방문했을 경우의 비트
    static int INF = 16_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

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
            for(int j = 1 ; j <= visitedAll ; j++) {
                dp[i][j] = -1;
            }
        }

        int result = tsp(1,1);
        System.out.println(result);
    }

    private static int tsp(int now, int visited) {

        if(visited == visitedAll){ //모든 도시를 방문한 경우
            if(map[now][1] == 0){
                return INF;
            }else{
                return map[now][1]; //시작 도시인 1로 가는 비용을 반환함.
            }
        }

        if(dp[now][visited] != -1)
            return dp[now][visited];

        dp[now][visited] = INF;
        //다음에 방문할 수 있는 구역이 존재하면, 방문함
        for(int i = 1; i <= N; i++){
            if(map[now][i] == 0)//경로가 없는 경우
                continue;
            int next = (1 << (i - 1));
            if((visited & next) != 0) //이미 방문한 경우
                continue;
            //다음 구간에 방문할 수 있는 경우
            dp[now][visited] = Math.min(dp[now][visited], tsp(i,visited | next) + map[now][i]);
        }
        return dp[now][visited];
    }
}
