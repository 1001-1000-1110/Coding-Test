# Quiz Name
> ### HackerRank / [intermediate] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-five"> Queue using Two Stacks </a>

<br>

## 💡 approaches
>  - 큐사용하기
>  - 

<br>

## 🔑 quiz solution

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int number;
            if(type == 1){
                number = Integer.parseInt(st.nextToken());
                q.offer(number);
            }else if(type == 2){
                q.poll();
            }else{
                bw.write(q.peek()+"\n");
            }
            
        }   
        bw.flush();
        bw.close();
    }
}
```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
