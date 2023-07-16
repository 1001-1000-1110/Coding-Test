package 백준.트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름 {
    static int N, Node;
    static ArrayList<Info>[] Map;
    static boolean[] visited ;
    static int Max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        Map = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            Map[i] = new ArrayList<Info>();
        }

        //map
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split(" ");
            int from = Integer.parseInt(temp[0]);
            for(int j = 1;  j < temp.length; j+=2) {
                if (temp[j].equals("-1"))
                    break;
                int to = Integer.parseInt(temp[j]);
                int val = Integer.parseInt(temp[j + 1]);
                Map[from].add(new Info(to,val));
            }
        }

        visited = new boolean[N + 1];

        dfs(1,0);
        visited[1] = false;
        dfs(Node,0);
        System.out.println(Max);
    }

    private static void dfs(int i, int sum) {
        if(sum > Max){
            Max = sum;
            Node = i;
        }
        visited[i] = true;

        for(Info now : Map[i]){
            if(visited[now.node] == false){
                visited[now.node] = true;
                dfs(now.node, sum + now.cost);
                visited[now.node] = false;
            }
        }

    }

    static class Info{
        int node;
        int cost;

        public Info(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
}
