package 백준.스티커;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 스티커 {

  static int t;
  static int n;
  static int[][] dp;

  public static void main(String[] args) throws IOException {

    //어떤 상품을 썻는지 확인해야함.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      bw.write(solve(br) + "\n");
    }

    bw.flush();
    bw.close();
  }

  private static int solve(BufferedReader br) throws IOException {
    int n = Integer.parseInt(br.readLine());
    dp = new int[2 + 1][n + 2];

    for (int i = 1; i <= 2; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; st.hasMoreTokens(); j++) {
        dp[i][j + 1] = Integer.parseInt(st.nextToken());
      }
    }
    //dp채우기

    for (int i = 2; i < n + 2; i++) {
      for (int j = 1; j <= 2; j++) {
        if (j == 1) {
          dp[j][i] = Math.max(dp[j][i] + dp[2][i - 1], dp[j][i] + dp[2][i - 2]);
        } else {
          dp[j][i] = Math.max(dp[j][i] + dp[1][i - 1], dp[j][i] + dp[1][i - 2]);
        }
      }
    }
    return Math.max(dp[1][n + 1], dp[2][n + 1]);
  }

}
