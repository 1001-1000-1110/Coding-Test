package 백준.텀프로젝트;

import java.io.*;
import java.util.StringTokenizer;

public class 텀프로젝트 {
    static int[] Team;
    static int N;
    static boolean[] Visited, Done;
    static int CntOfComplete;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){ //테스트 케이스 별로 실행
            bw.write(solve(br)+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static int solve(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        Team = new int[N + 1];
        Visited = new boolean[N + 1];
        Done = new boolean[N + 1];
        CntOfComplete = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            Team[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N ; i++) {
            if(Done[i]) continue;
            dfs(i);
        }

        return N - CntOfComplete;
    }

    private static void dfs(int index) {
        /*이미 처리된 곳(팀이 구성 되었거나, 팀을 구성할 수 없는 학생의 경우) 종료*/
        if(Done[index]){
            return;
        }

        if(Visited[index]){ //기존에 방문했던 경우, 같은 곳을 두번 방문했다는 뜻 -> Cycle(순환)에 포함됨.
            Done[index] = true; //순환을 구성하는 것으로 처리가 완료되었음을 나타냄.
            CntOfComplete++; //순환을 구성하는 학생(노드) 중 한명이므로 숫자를 센다.
        }

        //처음 방문한 경우 Visited = true
        Visited[index] = true; //처음 방문한

        dfs(Team[index]);
        //윗줄의 dfs메서드를 통해서, 진행되는 dfs에서 다시 돌아왔따는 것은 싸이클이 아니라는 것
        Done[index] = true;
        Visited[index] = false;
    }
}
