package 프로그래머스.피로도;

import java.util.*;
class Solution {
    static boolean[] visited;
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        for(int i = 0; i < dungeons.length; i++){
            Arrays.fill(visited,false);
            dfs(i,k,0,0,dungeons);
        }


        int answer = max;
        return answer;
    }
    //시작노드, 피로도 , 방문한 던전횟수, depth(깊이), dungeons배열
    private static void dfs(int start,int k, int cnt, int depth, int[][] dungeons){
        if(depth == dungeons.length){
            max = Math.max(cnt,max);
            return;
        }
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                int dcnt = 0;
                int dk = 0;
                if(k >= dungeons[i][0]){
                    dcnt = 1;
                    dk = dungeons[i][1];
                }
                dfs(i, k - dk , cnt + dcnt, depth + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}