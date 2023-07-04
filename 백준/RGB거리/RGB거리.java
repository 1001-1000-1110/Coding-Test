package 백준.RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int dp[][] = new int[n + 1][4]; //몇번째 집인지, 무슨 색인지(0~2)
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            dp[i][1] = Integer.parseInt(st.nextToken());
            dp[i][2] = Integer.parseInt(st.nextToken());
            dp[i][3] = Integer.parseInt(st.nextToken());
        }


        for(int i = 1; i <= n; i++){
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + dp[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + dp[i][2];
            dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + dp[i][3];
        }

        Arrays.sort(dp[n]);

        System.out.println(dp[n][1]);
    }
}
