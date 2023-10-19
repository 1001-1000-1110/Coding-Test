package 백준.문제집;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집 {
    static int[] indegree; //각 문제의 진입차수를 저장함
    static List<Integer>[] priorities; //a를 풀고나서 b를 풀어야 하는 경우를 저장함
    static boolean[] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init(br);

        //진입차수가 0인 경우, 바로출력할 수 있음. 해당하는 값들을 우선순위 큐(작은 값부터 반환하는)에 넣음
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
                visited[i] = true;
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll(); //q에서 값을 꺼냄
            bw.write(now + " "); //출력함
            for(int next: priorities[now]){
                indegree[next]--;//now를 풀어야만 풀수있는 값들의 진입차수를 줄임
            }

            //진입차수가 0이며, 한번도 풀지 않은 값을 pq(우선순위큐)에 넣음
            for(int i = 1; i <= n; i++){
                if(visited[i]) continue;
                if(indegree[i] == 0){
                    pq.add(i);
                    visited[i] = true;
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        indegree = new int[n + 1];
        priorities = new List[n + 1];
        for (int i = 1; i <= n ; i++) {
            priorities[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //b의 진입차수를 올림
            indegree[b]++;

            //priorities, a다음 b를 풀어하는 것을 나타냄
            priorities[a].add(b);
        }
    }
}
