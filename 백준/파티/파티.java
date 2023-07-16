package 백준.파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {
    static int N, M, X;
    static int[] Dist, ReverseDist;
    static List<Info>[] Map,ReverseMap ;
    static int Min;
    static int INF = Integer.MAX_VALUE;
    static boolean[] Visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Map = new ArrayList[N + 1];
        ReverseMap = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            Map[i] = new ArrayList<Info>();
            ReverseMap[i] = new ArrayList<Info>();

        }


        Dist = new int[N + 1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Map[from].add(new Info(to,cost));
            ReverseMap[to].add(new Info(from, cost));
        }

        Dist = new int[N + 1];
        ReverseDist = new int[N + 1];
        Dijkstra(Map, Dist);
        Dijkstra(ReverseMap, ReverseDist);

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <=N; i++){
            if(i == X) continue;
            answer = Math.max(answer, Dist[i] + ReverseDist[i]);
        }

        System.out.println(answer);
    }

    private static void Dijkstra(List<Info>[] map, int[] arr) {
        Arrays.fill(arr,INF);
        arr[X] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(X,0));

        while(!pq.isEmpty()){
            Info now = pq.poll();
            if(now.cost > arr[now.node])
                continue;
            for(Info next : map[now.node]){
                if(arr[next.node] > arr[now.node] + next.cost){
                    arr[next.node] = arr[now.node] + next.cost;
                    pq.add(new Info(next.node, arr[next.node]));
                }
            }
        }

    }


    static class Info implements Comparable<Info>{
        int node;
        int cost;
        public Info(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info i){
            return Integer.compare(this.cost, i.cost);
        }
    }
}
