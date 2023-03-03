package 백준.최단경로;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {
    //인접리스트를 구현을 위한 사용자정의 클래스
    static class info implements Comparable<info> {
        int node;//도착노드
        int distance;//가중치

        public info(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(info o) {
            return Integer.compare(distance, o.distance);
        }
    }

    ;

    static ArrayList<info>[] map; //인접리스트
    static boolean[] visited;//노드를 중복하여 방문하지 않기위함
    static int[] shortestArr;//최단거리를 기록하는 배열
    static int V, E, K; //정점의 개수, 간선의 개수,시작노드
    static int u, v, w;//출발노드,도착노드,가중치
    static int INF = Integer.MAX_VALUE;//무한대를 대체하는 값
    static PriorityQueue<info> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        //시작노드, 도착노드, 가중치를 담는 클래스 구현
        //정의한 클래스를 통한 인접리스트 배열 사용
        //최단거리배열을 활용해야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<info>();
        }
        visited = new boolean[V + 1];
        shortestArr = new int[V + 1];

        //인접리스트 만들기,에지 수만큼 반복
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map[u].add(new info(v, w));
        }
        //최단거리배열,시작노드를 제외한 나머지 노드의 값을 무한으로 설정
        Arrays.fill(shortestArr, INF);
        shortestArr[K] = 0;

        pq.add(new info(K, 0));

        while (!pq.isEmpty()) {
            info now = pq.poll();
            int nowNode = now.node;
            if (visited[nowNode] == true) continue;
            visited[nowNode] = true;
            for (info next : map[now.node]) {
                int nextNode = next.node;
                if (shortestArr[nextNode] > shortestArr[nowNode] + next.distance) {
                    shortestArr[nextNode] = shortestArr[nowNode] + next.distance;
                    pq.add(new info(nextNode,shortestArr[nextNode]));
                }
            }
        }

        for(int i = 1 ; i <= V; i++){
            if(shortestArr[i] == INF){
                bw.write("INF"+"\n");
            }else{
                bw.write(shortestArr[i]+"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    ;
}
