# Quiz Name
> ### 백준 / [골드3] <a href = "https://www.acmicpc.net/problem/11437"> 최소공통조상구하기1 </a>

<br>

## 💡 approaches
>  - LCA(최소공통조상구하기) 알고리즘활용  
>  - 트리에서 두개의 노드가 주어진 경우, 두 노드가 부모노드를 거슬러 올라가며, 최초로 공통되는 부모노드를 찾는 알고리즘이다.  
>   1. 주어진 두 노드 중 깊이가 더 깊은 노드의 부모노드를 거슬러 올라가, 다른 한 노드와 같은 깊이의 노드를 찾는다.
>   2. 두 노드 모두, 한 단계씩 부모노드를 거슬러 올라간다.(동일한 노드가 나올때까지)
<br>

## 🔑 quiz solution

```java
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 11437번 LCA(골드3)
public class Main {
    static boolean[] visit;//dfs시 방문여부
    static int[] parent, depth;//부모노드 , 배열의 깊이
    static ArrayList<Integer>[] tree; //인접리스트
    static int n, m; //노드의 개수 , 계산횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];//인덱스가 각 노드를 나타냄
        depth = new int[n + 1];//인덱스가 각 노드를 나타냄
        visit = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        //트리만들기
        for(int i = 0; i <=n; i++){
            tree[i] = new ArrayList<>();
        }

        //인접리스트 방식으로 각 노드의 관계를 구현
        for(int i = 0; i<n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        bfs(1);//dfs를 통해서 각 노드의 부모노드의 깊이를 구함

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = LCA(a,b);
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }

    /*1. a노드와 b노드의 깊이를 동일하게 맞춘다.
     * 2. 각 노드의 부모노드를 확인한다.
     * 3. 동일한 노드가 나타날때까지 반복한다.*/
    private static int LCA(int a, int b) {
        //a노드가 b노드 보다 깊다는 가정하에 로직을 진행할 것 -> a,b중 더큰 노드를 a로 놓음.
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        //동일한 깊이로 맞추기
        while(depth[a] != depth[b]){
            a = parent[a];
        }

        //부모노드로 한칸씩 이동하면서 동일한 값이 나올떄 까지 값을 비교함
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visit[node] = true;
        int level = 1; //depth[]배열에 깊이를 저장하기위한 인자, bfs깊이가 변할떄마다 갱신함
        int now_size = 1; //현재 깊이의 노드의 개수
        int cnt = 0; //깊의별로 노드의 개수 만큼 카운팅하기 위한 변수
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            for(int next : tree[nowNode]){
                if(!visit[next]){
                    visit[next] = true;
                    queue.add(next);
                    parent[next] = nowNode; //부모노드를 저장함
                    depth[next] = level; //깊이를 저장함
                }
            }
            cnt++;

            if(cnt == now_size){ //현재 큐에 담긴 노드의 개수만큼 확인한 경우, +1깊이의 노드들을 탐색하기위한 설정
                cnt = 0;
                now_size = queue.size();
                level++;
            }
        }
    }
}

```
### Time Complexity : O(N) _ 인접리스트 방식 
## 👩🏻‍🏫 TIL
>  - LCA알고리즘을 학습함

