package 백준.트리의부모찾기;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] map = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            map[i] = new ArrayList<>();
        }
        //연결 정보를 map에 담음
        StringTokenizer st;
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from].add(to);
            map[to].add(from);
        }


        int[] parent = new int[n + 1]; //parent[노드] = 부모노드
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        //인접리스트를 기반으로 parent배열 초기화 생성
        //bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next: map[now]){
                if(visited[next] == true) continue;
                parent[next] = now;
                visited[next] = true;
                q.add(next);
            }
        }

        for(int i = 2; i <= n; i++){
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();

    }
}
