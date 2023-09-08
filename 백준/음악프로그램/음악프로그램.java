package 백준.음악프로그램;

import java.io.*;
import java.util.*;

public class 음악프로그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //가수
        int m = Integer.parseInt(st.nextToken()); //pd

        int[] indegree = new int[n + 1];
        List<Integer>[] map = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            map[i] = new ArrayList<>();
        }
        //각 pd들이 제작한 순서를 기준으로 map을 초기화함
        for (int i = 0; i < m; i++) {
            int[] singers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 2; j < singers.length; j++){
                indegree[singers[j]]++; //진입차수
                map[singers[j - 1]].add(singers[j]); //map
            }
        }


        //진입차수가 0인 것부터 차례로 queue에 넣음

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            if(indegree[i] == 0){
                q.add(i);
                bw.write(i+"\n");
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
            //현재 노드(가수) 다음에 연결된 노드의 진입차수를 -1함
            for (Integer next : map[now]) {
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                    bw.write(next+"\n");
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(indegree[i] != 0){ //순서 정하는 것이 불가능한 경우
                System.out.println(0);
                return;
            }
        }
        bw.flush();
        bw.close();
    }
}
