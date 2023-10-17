package 백준.도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획 {
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * n,과 m을 입력받음
         * int[m][3] cities를 통해 출발, 도착도시 초기화(양방향)
         * parent배열 초기화
         * 정렬 Comparator활용
         * 반복문 for i = 0 ~ m까지
         *  cities에 접근하여 parent배열을 하나로 연결함.
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cities = new int[m][3];
        parent = new int[n + 1];
        //parent초기화
        for(int i = 1; i<= n; i++){
            parent[i] = i;
        }

        //m번동안 도시를 연결하는 가중치의 정보를 받음
        for(int i = 0;  i < m; i++){
            st = new StringTokenizer(br.readLine());
            cities[i][0] = Integer.parseInt(st.nextToken());
            cities[i][1] = Integer.parseInt(st.nextToken());
            cities[i][2] = Integer.parseInt(st.nextToken());
        }

        //cities정렬
        Arrays.sort(cities, ((o1, o2) -> Integer.compare(o1[2],o2[2])));

        int totalCost = 0;
        int maxCost = -1;
        //find and union을 m번 반복함
        for(int i = 0; i < m; i++){
            int a = cities[i][0];
            int b = cities[i][1];
            int cost = cities[i][2];
            if(find(a) != find(b)){
                //union
                union(a,b);
                maxCost = Math.max(maxCost, cost);
                totalCost += cost;
            }
        }

        System.out.println(totalCost - maxCost);

    }
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA] = rootB;
    }

    private static int find(int a) {
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);

    }
}
