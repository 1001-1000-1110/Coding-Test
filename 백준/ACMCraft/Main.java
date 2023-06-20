package 백준.ACMCraft;

import java.io.*;
import java.util.*;

public class Main {
    static class Info{
        int node;
        int cnt;
        public Info(int node, int cnt){
            this.node = node;
            this.cnt = cnt;
        }
    }
    static int T,N,K,W;
    static int[] indegree;//진입차수
    static List<Integer>[] map;
    static int[] time;//건설시간
    static int[] maxTime;//동일한 우선순위를 가진 건물들의 건설시간 중 가장 큰 값을 저장함.
    public static void main(String[] args) throws IOException {
        //위상정렬

        //인접리스트 구현을 통해 해당 노드에 연결된 것들을 저장함
        //진입차수를 저장하는 배열 생성 및 초기화
        //진입차수별 크기를 비교할 수 있는 배열이 필요함. 최대 N
        //찾고자하는 건물이 0이 되면 해당 건물의 진입차수 까지 더한 배열을 통해 값을 출력함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int sum = getTime(br);
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int getTime(BufferedReader br) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        String[] temp = br.readLine().split(" ");
        time = new int[N + 1]; //건설시간
        for(int i = 0; i < N; i++){
            time[i + 1] = Integer.parseInt(temp[i]);
        }

        maxTime = new int[N + 1];
        Arrays.fill(maxTime, Integer.MIN_VALUE);

        //인접리스트
        map = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            map[i] = new ArrayList<>();
        }

        indegree = new int[N + 1];
        for(int i = 0;  i < K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            indegree[b]++;
        }

        W = Integer.parseInt(br.readLine()); //건설해야할 건물

        if(indegree[W] == 0) //그냥 바로 건설할 수 있는 경우
            return time[W];

        Queue<Info> q = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(new Info(i,1));
                maxTime[1] = time[i];
                indegree[i] = -1;
            }
        }
        int answer = 0;
        while(!q.isEmpty()){
            Info now = q.poll();
            //진입차수 감소
            for(int next : map[now.node]){
                indegree[next]--;
            }
            // 진입차수가 0이 되면 큐에 추가.
            for(int i = 1; i < indegree.length; i++){
                if(indegree[i] == 0) {
                    q.add(new Info(i, now.cnt + 1));
                    maxTime[now.cnt + 1] = Math.max(maxTime[now.cnt + 1], time[i]);
                    indegree[i] = -1;

                    if (i == W) {
                        answer = now.cnt + 1;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= answer; i++){
            sum += maxTime[i];
        }
        return sum;
    }
}
