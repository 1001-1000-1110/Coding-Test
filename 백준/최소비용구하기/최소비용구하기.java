package 백준.최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Info>[] map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i <m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Info(b,c));
        }

        //출발도시, 도착 도시
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //dijkstra
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start,0));

        while(!pq.isEmpty()){
            Info now = pq.poll();
            if(dist[now.node] < now.cost){
                continue;
            }
            for(Info next : map[now.node]){
                if(dist[next.node] > dist[now.node] + next.cost){
                    dist[next.node] = dist[now.node] + next.cost;
                    pq.add(new Info(next.node, dist[next.node]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Info implements Comparable<Info>{
        int node;
        long cost;

        public Info(int node, long cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info i){
            return Long.compare(this.cost, i.cost);

        }
    }
}
