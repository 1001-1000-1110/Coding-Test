package 프로그래머스.섬연결하기;

import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        //가중치를 오름차순으로 정렬
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[]o2){
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int answer = 0;
        for(int i = 0; i < costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){//서클이 생기는 것을 방지하기 위함, 서로 다른 부모 노드를 가진 경우에만 union
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }

    //두개의 노드를 연결함
    private void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        parent[rootA] = rootB;

    }

    private int find(int child){
        if(parent[child] == child){
            return child;
        }
        return parent[child] = find(parent[child]); //노드의 개수가 많은 경우 시간초과를 방지하기 위함.
    }
}
