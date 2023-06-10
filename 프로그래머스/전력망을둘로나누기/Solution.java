package 프로그래머스.전력망을둘로나누기;

import java.util.*;
class Solution {
    static int[][] map;
    static boolean[] visited;
    static int cnt;

    public int solution(int n, int[][] wires) {

        //인접행렬 구현
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for(int[] wire : wires){
            int node1 = wire[0];
            int node2 = wire[1];
            map[node1][node2] = 1;
            map[node2][node1] = 1;
        }

        //연결된 간선들을 하나씩 제거하고, 쪼개진 트리의 차를 구함.
        int min = Integer.MAX_VALUE;
        for(int[] wire : wires){
            int node1 = wire[0];
            int node2 = wire[1];
            map[node1][node2] = 0;
            map[node2][node1] = 0;

            Arrays.fill(visited,false);
            cnt = 0;
            dfs(node1, n);
            int first = cnt;

            Arrays.fill(visited,false);
            cnt = 0;
            dfs(node2, n);
            int second = cnt;

            int diff = Math.abs(first - second);
            min = Math.min(diff,min);
            map[node1][node2] = 1;
            map[node2][node1] = 1;
        }
        return min;
    }
    private static void dfs(int node, int n){
        cnt++;
        visited[node] = true;
        for(int i = 1; i <= n; i++){
            if(visited[i] == false && map[node][i] == 1){
                dfs(i, n);
            }
        }

    }
}