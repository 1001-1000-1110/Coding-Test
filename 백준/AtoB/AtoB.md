# Quiz Name
> ### BaekJoon / [Silver2] <a href = "https://www.acmicpc.net/problem/16953"> A->B </a>

<br>

## 💡 approaches
>  - dfs
>  - 

<br>

## 🔑 quiz solution

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int B;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[B + 1];
        solve(a, 1);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void solve(int number, int count) {
        if (number == B) {
            min = Math.min(min, count);
            return;
        }

        if (visited[number]) {
            return;
        }
        visited[number] = true;

        if (number * 2 <= B) {
            solve(number * 2, count + 1);
        }
        if (number <= 100_000_000 - 1 &&  number * 10 + 1 <= B) {
            solve(number * 10 + 1, count + 1);
        }
    }
}

```
### Time Complexity : O(logB)
## 👩🏻‍🏫 TIL
>  -
>  -
