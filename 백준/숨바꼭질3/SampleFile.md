# Quiz Name
> ### BaekJoon / [Gold5] <a href = "https://www.acmicpc.net/source/64330541"> 숨바꼭질3 </a>

<br>

## 💡 approaches
>  - BFS
>  - 우선순위큐

<br>

## 🔑 quiz solution

```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100000 + 1;
    static class Info implements Comparable<Info>{
        int x;
        int cnt;
        public Info(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info i) {
            return Integer.compare(this.cnt, i.cnt);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a,b));

    }

    private static int bfs(int start, int target) {
        boolean[] visited = new boolean[MAX];
        int min = Integer.MAX_VALUE;
        PriorityQueue<Info> pq = new PriorityQueue<Info>();
        pq.add(new Info(start,0));

        while(!pq.isEmpty()){
            Info now = pq.poll();
            if(now.x == target){
                min = now.cnt;
                break;
            }
            visited[now.x] = true;
            if(now.x * 2 < MAX && visited[now.x * 2] == false){
                pq.add(new Info(now.x * 2, now.cnt));
            }

            if(now.x + 1 < MAX && visited[now.x + 1] == false){
                pq.add(new Info(now.x + 1 , now.cnt + 1));
            }

            if(now.x - 1 >= 0 && visited[now.x - 1] == false){
                pq.add(new Info(now.x + -1 , now.cnt + 1));
            }
        }

        return min;
    }

}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
