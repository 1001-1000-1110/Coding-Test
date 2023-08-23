package 백준.특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {
    static ArrayList<Info>[] map;
    static int target1, target2;
    static int MAX = 200000*1000;
    static int n,e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        for (int i = 0; i <=n ; i++) {
            map[i] = new ArrayList<Info>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Info(b,c));
            map[b].add(new Info(a,c));
        }

        st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());

        //1->target1 -> target2 -> n;
        int first = 0;
        first += dijkstra(1,target1);
        first += dijkstra(target1,target2);
        first += dijkstra(target2,n);


        //1->target2 -> target1 -> n;
        int second = 0;
        second += dijkstra(1,target2);
        second += dijkstra(target2,target1);
        second += dijkstra(target1,n);

        int result = 0;
        if(first >= MAX && second >= MAX){
            result = -1;
        }else{
            result = Math.min(first,second);
        }
        System.out.println(result);

    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
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
        return dist[end];
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
