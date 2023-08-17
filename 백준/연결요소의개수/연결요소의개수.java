package 백준.연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연결요소의개수 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 0;  i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if( find(a) != find(b)){
                union(a,b);
            }
        }

        for(int i = 1; i <= n; i++){
            parent[i] = find(i);
        }

        Arrays.sort(parent);
        int cnt = 1;

        for(int i = 2; i <= n; i++){
            if(parent[i] != parent[i - 1])
                cnt++;
        }

        System.out.println(cnt);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootB] = rootA;
    }

    private static int find(int a) {
        if(a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }
}
