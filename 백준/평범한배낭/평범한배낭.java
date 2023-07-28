package 백준.평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
    static int[] weight;
    static int[] value;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        weight = new int[n + 1];
        value = new int[n + 1];
        dp = new int[k + 1][n + 1];

        //n만큼 배열 초기화
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            weight[i] = w;
            value[i] = v;
        }

        //dp[i][j]를 채움
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= n; j++){
                //i = 현재 무게
                //j = 무게와 벨류
                //현재 무게 보다 j번째 무게가 더 큰 경우(가방에 담을 수 없는 무게인 경우)
                if(weight[j] >  i){
                    dp[i][j] = dp[i][j - 1];
                }else{ //가방에 담을 수 있는 경우
                    int spareWeight = i - weight[j];
                    int spareValue = 0;
                    for(int s = 1; s < j; s++){
                        spareValue = Math.max(dp[spareWeight][s], spareValue);
                    }
                    dp[i][j] = Math.max(dp[i][j - 1], value[j] + spareValue);
                }
            }
        }

        System.out.println(dp[k][n]);


    }
}
