package 백준.비숍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비숍 {
    static int N; //체스판 한변의 길이
    static int evenCost; //N이 짝수인 경우, 좌표를 이동할때 통일시키기 위한 변수
    static int[][] map; //체스판
    static int[] max = new int[2]; //체스판에서 서로 영향을 줄수 없도록 2가지로 나누어서 각각 백트래킹함. 이때의 놓을 수 있는 퀸의 최대 개수를 저장함.
    public static void main(String[] args) throws IOException {
        //입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N % 2 == 0){
            evenCost += 1;
        }
        map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //(1,1)을 시작으로 백트래킹
        dfs(1,1,0,0,0,0);
        //(1,2)를 시작으로 백트래킹
        dfs(1,2,0,0,0, 1);

        System.out.println(max[0] + max[1]);

    }

    private static void dfs(int x, int y, int cnt, long bit1, long bit2, int idx) {
        //입력받은 좌표가 다음 행으로 넘어가야 하는 경우를 계산함.
        if(y > N){
           x += 1;
           int diff = y - N + evenCost;
           if(diff % 2 == 1){
               y = 1;
           }else{
               y = 2;
           }
        }
        //x가 N을 넘어간 경우 = 맵의 가장 마지막 좌표를 확인했으므로, 백트래킹을 종료함.
        if(x > N){
            max[idx] = Math.max(max[idx],cnt);
            return;
        }

        //현재 위치에 놓을 수 있는 경우
        if(map[x][y] == 1 && checkBit1(x,y, bit1) && checkBit2(x, y, bit2)){
            long nBit1 = bit1 | (1L << (N + x - y - 1));
            long nBit2 = bit2 | (1L << (x + y - 1));
            dfs(x, y + 2, cnt + 1, nBit1, nBit2, idx);
        }

        dfs(x, y + 2, cnt , bit1, bit2, idx);
    }

    private static boolean checkBit2(int x, int y, long bit2) {
        int result = x + y;
        int bit = 1 << (result - 1);
        //이미 다른 비숍이 위치하는 경우, 놓을 수없음
        if((bit & bit2) == bit){
            return false;
        }
        return true;
    }

    private static boolean checkBit1(int x, int y, long bit1) {
        int result = N + x - y;
        int bit = 1 << (result - 1);
        //이미 다른 비숍이 위치하는 경우, 놓을 수없음
        if((bit & bit1) == bit){
            return false;
        }
        return true;
    }
}
