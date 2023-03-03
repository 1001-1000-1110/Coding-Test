package 백준.특정거리의도시찾기;

import java.io.*;
import java.util.*;

public class 특정거리의도시찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer>[] map;//인접리스트
    static int n, m, k, x;//도시의수,도로의수,거리,출발도시
    static int[] visited;//방문여부 및 시작도시에서 부터의 거리 표시
    static ArrayList<Integer> result = new ArrayList<>();//x노드부터 거리가 k인 노드를 저장할 list

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        //인접리스트 구현
        map = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from].add(to);
        }

        //BFS
        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        bfs(x);

        if (result.size() == 0) {//아무것도 없는 경우 -1을 출력해야함
            bw.write(-1 + "");
        }else{//x노드부터 거리가k인 노드가 존재하는 경우
            Collections.sort(result);//오름차순으로 정렬
            for(int i : result){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();


    }

    private static void bfs(int node) {
        visited[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : map[now]) {
                if (visited[next] == -1) {//처음방문하는 경우
                    visited[next] = visited[now] + 1;//x 노드부터 현재 노드까지의 거리 + 1
                    q.add(next);
                    if (visited[next] == k) {//x노드부터 현재노드까지의 거리가 k인경우 result에 담음
                        result.add(next);
                    }
                }
            }
        }
    }
}
