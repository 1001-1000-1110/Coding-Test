package 백준.최소스패닝트리;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st= new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] costs = new int[e][3];
        for(int i = 0; i < e; i++){
            st= new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        //가중치를 기준으로 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        //parent
        parent = new int[v + 1];
        for(int i = 1; i < parent.length; i++){
            parent[i] = i;
        }

        long answer = 0;
        for(int i = 0;  i < costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        System.out.println(answer);
    }

    private static int find(int child){
        if(parent[child] == child){
            return child;
        }

        return parent[child] = find(parent[child]);
    }

    private static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        parent[rootA] = rootB;
    }
}
