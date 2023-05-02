package 프로그래머스.네트워크;

import java.util.*;
class Solution {
    static ArrayList[] map;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n]; //방문한 노드(컴퓨터)인지 확인하는 배열
        map = new ArrayList[n]; //인접리스트
        for(int i = 0;  i < map.length; i++){
            map[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < computers.length; i++){
            int[] com = computers[i];
            for(int j = 0; j < com.length; j++){
                if(com[j] == 1){ //연결되어있는 경우만 담음
                    map[i].add(j);
                }
            }
        }

        int answer = 0;
        for(int i = 0;  i < n; i++){
            if(visited[i] == false){
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    private void dfs(int node){
        ArrayList<Integer> currNode = map[node];
        for(int connectedNode:currNode){
            if(!visited[connectedNode]){
                visited[connectedNode] = true;
                dfs(connectedNode);
            }
        }
    }
}