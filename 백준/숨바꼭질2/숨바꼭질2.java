package 백준.숨바꼭질2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질2 {
    static int N, K;
    static int MAX = 100_000;
    static boolean[] visited = new boolean[MAX + 1];
    private static int min;
    private static int minCnt;


    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(min);
        System.out.println(minCnt);
    }

    private static void solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        int seq = 0;
        min = Integer.MAX_VALUE;
        minCnt = 0;
        pq.add(new int[]{N, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int pos = now[0];
            int cnt = now[1];

            if(pos == K){
                if(cnt > min){
                    return;
                }else if(min == cnt){
                    minCnt++;
                }else{
                    min = Math.min(min, cnt);
                    minCnt = 1;
                }
            }

            if(visited[pos] && cnt == min) continue;
            visited[pos] = true;
            List<Integer> dup = new ArrayList<>();

            if(pos * 2 <= MAX && !visited[pos * 2]){
                pq.add(new int[]{pos * 2, cnt + 1});
            }

            if(pos + 1 <= MAX && !visited[pos + 1]){
                pq.add(new int[]{pos + 1, cnt + 1});
            }

            if(pos - 1 >= 0 && !visited[pos - 1]){
                pq.add(new int[]{pos - 1, cnt + 1});
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
