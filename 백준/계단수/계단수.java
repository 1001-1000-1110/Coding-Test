package 백준.계단수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단수 {
    static int MOD = (int)Math.pow(10,9);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long dp[][][] = new long[n + 1][10][1 << 10];//자리의 길이(N), 마지막 숫자, 각 숫자의 사용여부

        for(int i = 1; i <= 9; i++){
            dp[1][i][1 << i] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k < (1<<10); k++){
                    if(j == 0){ //마지막자리에 0이 올수 있는 경우는 바로 앞자리의 숫자가 1인 경우(j보다 1만큼 큰 경우)
                        dp[i][j][k | 1 << j] = (dp[i][j][k | 1 << j] + dp[i - 1][j + 1][k]) % MOD;
                    }
                    else if(j == 9){//마지막자리에 9가 올수 있는 경우는 앞자리의 숫자가 8인 경우(j보다 1만큼 작은 경우)
                        dp[i][j][k | 1 << j] = (dp[i][j][k | 1 << j] + dp[i - 1][j - 1][k]) % MOD;
                    }
                    else{//0과 9가 아닌 경우, 계단수가 되는 경우는 앞자리의 숫자가 현재 숫자(j)보다 1만큼 크거나 작은 경우
                        dp[i][j][k | 1 << j] = (dp[i][j][k | (1 << j)] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for(int j = 0; j <= 9; j++){
            ans = (ans + dp[n][j][(1 << 10) - 1]) % MOD;
        }

        System.out.println(ans);
    }
}
