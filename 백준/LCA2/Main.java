package 백준.LCA2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visit; //bfs에서 활용.
    static int[] depth;//각 노드별 깊이를 나타냄.
    static int[][] parent;//p[k][n]라고할때, n노드의 2^k만큼 위에 있는 부모노드가 무엇인지 저장하는 배열
    static int maxDepth;//트리에서 가장 깊은 깊이를 나타냄
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        //인접리스트 구현
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        //maxDepth구하기
        int temp = 1;
        while (temp < n) {
            temp *= 2;
            maxDepth++;
        }
        //bfs를 통해서 각노드의 depth와 parent를 구함
        visit = new boolean[n + 1];
        depth = new int[n + 1];
        parent = new int[maxDepth + 1][n + 1];
        bfs(1);
        //점화식을 통한 parent배열 초기화 *****
        for(int i = 1; i <= maxDepth; i++){
            for(int j = 1; j<=n; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]]; //
            }
        }

        //lca실행
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = getLCA(a,b);
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();

    }

    private static int getLCA(int a, int b) {
        //노드 a의 깊이가 더 크게 설정함
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        //두노드의 차이를 고려하여 a노드가 b노드의 깊이와 같아질때까지 부모 노드로 이동함
        for(int i = maxDepth; i >=0; i--){
            if(Math.pow(2,i) <= depth[a] - depth[b]){
                a = parent[i][a];
            }
        }

        //두 노드는 같은 깊이에 있으므로, 두 노드의 가장 먼 부모노드에서 가까운 노드까지 값을 비교하여 서로 다른 노드인 노드로 이동함.
        //아래의 반복문을 통해서 이미 두 노드가 같은 노드일수 있음!
        for(int i = maxDepth; i>=0; i--){
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        //위의 반복문에서 서로 다른 순간의 노드를 찾았으므로, 해당 노드의 바로 위가 최소공통조상.
        int LCA = a;
        if(a != b){ //만약 두 노드가 서로 다르다면 루트노드가 최소공통조상이다.
            LCA = parent[0][LCA];
        }
        return LCA;
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visit[node] = true;
        int level = 1; //깊이를 나타냄
        int nodeSize = 1; //해당 깊이의 노드의 개수를 나타냄
        int count = 0;//반복문이 해당 트리의 깊이에 존재하는 노드 수 만큼, 동작하면 트리의 깊이를 변경해주기 위한 변수
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : tree[now]) {
                if(!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    parent[0][next] = now;
                    depth[next] = level;
                }
            }
            count++;
            if(count == nodeSize){ //해당 깊이의 노드를 모두 탐색했으므로 다음 깊이로 변경해주는 과정
                count = 0;
                nodeSize = q.size();
                level++;
            }

        }
    }
}
