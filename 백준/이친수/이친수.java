package 백준.이친수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[90+1];

        dp[0] = 0;
        dp[1] = 1;


        for(int i = 2; i <=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);

//        long[][] dp = new long[90 + 1][2];//N의 최대 값이 N이므로
//
//        dp[1][1] = 1; // 1
//        dp[1][0] = 0; //
////        dp[2][1] = 1; //1인경우 1가지만 존재
////        dp[2][0] = 1; //10인 경우 1가지만 존재
//        for(int i = 2; i <= n; i++){
//            dp[i][0] += dp[1][0] + dp[1][1]; //0으로 끝나는 경우 뒤에 0과 1이 위치할 수 있음. 즉, 2개가 올수 있음
//            dp[i][1] += dp[1][0] + 1; //1로 끝나는 경우 뒤에 0만 올 수 있음.
//        }
//
//        long result = dp[n][1] + dp[n][0];
//        System.out.println(result);

    }
}
