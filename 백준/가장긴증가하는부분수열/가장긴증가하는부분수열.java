package 백준.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n];
    int[] dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      nums[i] = Integer.parseInt(st.nextToken());
    }


    for(int i = 0; i < n; i++){
      dp[i] = 1;
      for(int j = 0; j < i; j++){
        if(nums[j] < nums[i]){
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    Arrays.sort(dp);
    System.out.println(dp[n-1]);
  }

}
