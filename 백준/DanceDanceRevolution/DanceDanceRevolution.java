package 백준.DanceDanceRevolution;

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
