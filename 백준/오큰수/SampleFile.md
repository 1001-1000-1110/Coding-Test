# Quiz Name
> ### BaekJoon / [Gold4] <a href = "https://www.acmicpc.net/status?user_id=javahoiae&problem_id=17298&from_mine=1"> 오큰수 </a>

<br>

## 💡 approaches
>  - 단순반복문으로 해결 불가능(시간초과)
>  - 자료구조(스택)을 활용한 풀이
>  - [참고한 블로그](https://st-lab.tistory.com/196)

<br>

## 🔑 quiz solution

```java

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;  i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            //반복문
            while(!stack.isEmpty() && (A[i] > A[stack.peek()])){
                A[stack.pop()] = A[i];
            }
            //인덱스 push
            stack.push(i);
        }

        while(!stack.isEmpty()){
            A[stack.pop()] = -1;
        }

        for(int value : A){
            bw.write(value+" ");
        }
        bw.flush();
        bw.close();
    };
}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  - 스택을 활용한 알고리즘 풀이

