# Quiz Name
> ### BaekJoon / [Gold3] <a href = "https://www.acmicpc.net/problem/2342"> Dance Dance Revolution </a>

<br>

## 💡 approaches
> 다이나믹 프로그래밍 (Top-Down)
>  - solve()메서드를 통해 동일 한 값을 여러번 찾지 않도록 메모리제이션한다.

<br>

## 🔑 quiz solution

```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DanceDanceRevolution {
    static List<Integer> nums = new ArrayList<>();
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            if(value == 0) break;
            nums.add(value);
        }
        dp = new int[nums.size()][5][5];

        for(int i = 0;  i < dp.length; i++){
            for (int j = 0; j < 5; j++) {
            Arrays.fill(dp[i][j],-1);
            }
        }

        int result = solve(0,0,0);
        System.out.println(result);
    }

    private static int solve(int cnt, int left, int right) {
        if(cnt == nums.size()) return 0;

        if(dp[cnt][left][right] != -1) return dp[cnt][left][right];

        return dp[cnt][left][right] = Math.min(solve(cnt + 1, nums.get(cnt), right) + getPower(nums.get(cnt),left), solve(cnt + 1, left, nums.get(cnt)) + getPower(nums.get(cnt),right));

    }

    private static int getPower(int des, int pos) {
        int diff = Math.abs(des - pos);

        if(pos == 0) return 2; //발이 중앙에 있는 경우
        if(diff == 0) //이동한 위치에 발이 있는 경우
            return 1;
        else if(diff == 2) //반대편 인 경우
            return 4;
        else //인접한 경우
            return 3;
    }

}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
