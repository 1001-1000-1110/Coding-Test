package 백준.할로윈의양아치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 할로윈의양아치오답풀이 {

    private static int[] parent;
    private static int[] candies;
    private static int n;
    private static int m;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        candies = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }

        //union find로 그룹을 분류함
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) != find(b)) {
                union(a, b);
            }
        }
        //그룹별로 사탕의 합을 더함
        Map<Integer, Integer> groups = new HashMap<>();
        Map<Integer, Integer> peopleCnt = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (groups.containsKey(parent[i])) {
                int value = groups.get(parent[i]);
                groups.put(parent[i], value + candies[i]);
                int cnt = peopleCnt.get(parent[i]);
                peopleCnt.put(parent[i], cnt + 1);
            } else {
                groups.put(parent[i], candies[i]);
                peopleCnt.put(parent[i], 1);
            }
        }

        //배낭 문제
        int[][] info = new int[groups.size() + 1][2]; //0은 사람의 수, 1은 사탕의 수
        int index = 1;
        for (int key : groups.keySet()) {
            info[index][0] = peopleCnt.get(key);
            info[index][1] = groups.get(key);
            index++;
        }

        int[][] dp = new int[info.length][k];//[그룹번호][사람수] = 사탕의 개수
        for (int i = 1; i < info.length; i++) {
            int cnt = info[i][0]; //사람의 수
            int candy = info[i][1]; //사탕의 수
            for (int j = 1; j < k; j++) {
                if (cnt <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cnt] + candy);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[info.length-1][k - 1]);

    }

    private static int find(int child) {
        if (child == parent[child]) {
            return child;
        }
        return parent[child] = find(parent[child]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA > rootB) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
        }
    }
}
