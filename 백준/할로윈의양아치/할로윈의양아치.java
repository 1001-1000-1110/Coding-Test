package 백준.할로윈의양아치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 할로윈의양아치 {
    private static boolean[] visited;
    private static List<Integer>[] relation;
    private static int[] candies;
    private static Map<Integer, int[]> groups = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        candies = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }

        relation = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            relation[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a].add(b);
            relation[b].add(a);
        }

        //bfs를 통해 그룹별, 사탕의 수, 사람의수를 정리함
        visited = new boolean[n + 1];
        int groupIndex = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i, ++groupIndex);
            }
        }
        //배낭문제
        int[][] dp = new int[groups.size() + 1][k];
        for (int i = 1; i <= groups.size(); i++) {
            int candy = groups.get(i)[0];
            int people = groups.get(i)[1];
            for (int j = 1; j < k; j++) {
                if (people <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - people] + candy, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[groups.size()][k - 1]);
    }

    private static void bfs(int node, int groupIndex) {
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        //사탕의 개수, 사람 수
        int candy = candies[node];
        int people = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : relation[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    candy += candies[next];
                    people++;
                }
            }
        }
        int[] candyAndPeople = new int[2];
        candyAndPeople[0] = candy;
        candyAndPeople[1] = people;
        groups.put(groupIndex, candyAndPeople);
    }
}
