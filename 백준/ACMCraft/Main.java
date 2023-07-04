package 백준.ACMCraft;

import java.io.*;
import java.util.*;

public class Main {
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

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
                maxTime[i] = time[i];
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
            //진입차수 감소
            for(int next : map[now]){
                maxTime[next] = Math.max(maxTime[next], maxTime[now] + time[next]);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }

            }
        }

        return maxTime[W];
    }
}
