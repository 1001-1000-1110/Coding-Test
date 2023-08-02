package 백준.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스 {
    static List<Integer>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//컴퓨터 수
        int m = Integer.parseInt(br.readLine());// 간선 개수

        map = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            map[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for(int i = 0;  i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from].add(to);
            map[to].add(from);
        }

        System.out.println(bfs(1,n));


    }

    private static int bfs(int start, int n) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : map[now]){
                if(visited[next] == true){
                    continue;
                }
                q.add(next);
                visited[next] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
