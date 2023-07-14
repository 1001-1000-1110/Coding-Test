package 백준.트리의지름1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름 {
    static int N;
    static List<Info>[] Map, ReverseMap;
    static int TheFurthestNode;
    static boolean Visited[];
    static int TheFurthestNodeSum = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //인접리스트 초기화
        Map = new ArrayList[N+1];
        ReverseMap = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            Map[i] = new ArrayList<>();
            ReverseMap[i] = new ArrayList<>();
        }

        //간선의 정보를 입력받음
        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Map[from].add(new Info(to, cost));
            ReverseMap[from].add(new Info(to, cost));
            ReverseMap[to].add(new Info(from, cost));
        }

        Visited = new boolean[N + 1];
        //루트 노드(1)에서 dfs를 하여 가장멀리 있는 노드를 찾음
        findFurthestNode(1,0, Map);

        TheFurthestNodeSum = 0;
        //가장멀리 있는 도르에서 dfs를 하여 가장 멀리 있는 노드까지의 가중치를 더함.
        Visited[TheFurthestNode] = true;
        findFurthestNode(TheFurthestNode,0, ReverseMap);

        System.out.println(TheFurthestNodeSum);
    }

    private static void findFurthestNode(int start, int sum, List<Info>[] map) {
        if(sum > TheFurthestNodeSum){
            TheFurthestNodeSum = sum;
            TheFurthestNode = start;
        }
        if(map[start] == null){
            return;
        }
        for(Info next : map[start]){
            if(!Visited[next.node]) {
                Visited[next.node] = true;
                findFurthestNode(next.node, sum + next.val, map);
                Visited[next.node] = false;
            }
        }
    }
}
class Info{
    int node;
    int val;

    public Info(int node, int val) {
        this.node = node;
        this.val = val;
    }
}
