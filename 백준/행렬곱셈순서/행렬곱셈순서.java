package 백준.행렬곱셈순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱셈순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N + 1][2];
        int[][] dp = new int[N + 1][N + 1];

        //matrix
        for(int i = 1;  i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        //최소 계산 횟수를 구함
        for(int i = 1;  i <= N; i++){ //구간의 간격
            for(int j = 1; j <= N - i; j++){ //구간의 시작점
                dp[j][j + i] = Integer.MAX_VALUE;
                for(int k = j; k < j + i; k++){ //구간을 쪼개는 지점
                    dp[j][i + j] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + (matrix[j][0] * matrix[k + 1][0] * matrix[j + i][1]));
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}
