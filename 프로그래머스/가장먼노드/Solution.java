package 프로그래머스.가장먼노드;

import java.util.*;
class Solution {
    static int[] distance; //노드까지의 최단 거리를 담음
    static Queue<Integer> q = new LinkedList<Integer>();
    static List<Integer>[] nodes;

    public int solution(int n, int[][] edge) {

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); //각 노드에 도달하는 거리를 최대로 채움

        //인접리스트
        nodes = new ArrayList[n + 1];

        for(int i = 0;  i <= n; i++){
            nodes[i] = new ArrayList<Integer>();
        }


        for(int[] ed : edge){
            nodes[ed[0]].add(ed[1]);
            nodes[ed[1]].add(ed[0]);
        }
        //큐에 넣을 초기 값
        distance[1] = 0;
        q.add(1);
        while(!q.isEmpty()){
            int currentNode = q.poll();
            for(int nextNode : nodes[currentNode]){
                if(distance[currentNode] + 1 < distance[nextNode]){ //"현재노드에 가중치(1)을 더한 값"이, "현재노드와 연결되어 있는 노드"의 최단거리보다 짧으면 갱신함
                    distance[nextNode] = distance[currentNode] + 1;
                    q.add(nextNode);
                }
            }
        }

        //가장멀리있는 노드의 개수 구하기
        Arrays.sort(distance);
        int target = distance[distance.length-2];
        int cnt = 0;
        for(int dis : distance){
            if(dis == target)
                cnt++;
        }

        return cnt;
    }
}