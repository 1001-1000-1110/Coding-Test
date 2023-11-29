package 백준.사이클게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클게임 {

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //parent
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) == find(b)){
                answer = i;
                break;
            }
            union(a,b);
        }

        System.out.println(answer);
    }

    private static int find(int child) {
        if (child == parents[child]) {
            return child;
        }
        return parents[child] = find(parents[child]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parents[rootA] = rootB;
    }
}
