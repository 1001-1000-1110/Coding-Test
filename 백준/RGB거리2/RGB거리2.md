# Quiz Name
> ### BaekJoon / [Gold4] <a href = "https://www.acmicpc.net/problem/17404"> RGB거리2 </a>

<br>

## 💡 approaches
>  - dp
>  - 

<br>

## 🔑 quiz solution

```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1000 * 1000;//최대치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //색깔별 비용을 저장함.
        int[][] costs = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][3]; //dp[x][y] = result, x = 몇번째 집인지 나타내는 값, y = 색 , result = 비용
        int min = INF;
        //시작하는 색깔을 구분하기 위한 반복
        for (int i = 0; i < 3; i++) {
            dp[1][0] = INF;
            dp[1][1] = INF;
            dp[1][2] = INF;
            dp[1][i] = costs[1][i];
            //이전 집과 다른 색을 칠하면서 최소값을 계산함.
            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + costs[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + costs[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + costs[j][2];
            }

            //마지막집에 칠한 색이, 첫번째 집에 칠한 색과 다른 경우에만 최소 값을 갱신함.
            for (int k = 0; k < 3; k++) {
                if (i == k) {
                    continue;
                }
                min = Math.min(min, dp[n][k]);
            }
        }

        System.out.println(min);
    }

}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
