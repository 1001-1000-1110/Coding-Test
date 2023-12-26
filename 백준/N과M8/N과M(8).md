# Quiz Name
> ### BaekJoon / [Silver3] <a href = "https://www.acmicpc.net/problem/15657"> N과M(8) </a>

<br>

## 💡 approaches
>  - 
>  - 

<br>

## 🔑 quiz solution

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] nums;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        //오름차순정렬
        //N개의 숫자를 M개씩 뽑아서 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums =new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int[] arr = new int[M];
        dfs(0,0, arr);

        bw.flush();
        bw.close();
    }

    private static void dfs(int index,int length, int[] arr) throws IOException {
        if(length == M){
            for(int i = 0;  i < M; i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        int[] nArr = arr.clone();
        for(int i = index; i < N; i++){
            nArr[length] = nums[i];
            dfs(i,length + 1,nArr);
        }
    }
}

```
### Time Complexity : O(N<sup>N</sup>)
## 👩🏻‍🏫 TIL
>  -
>  -
