# Quiz Name
> ### HackerRank / [intermediate] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-jesse-and-cookies/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six"> Jesse and Cookies </a>

<br>

## 💡 approaches
> - 문제
>  -  public static int cookies(int k, List<Integer> A) 메소드 구현
>  - `A`의 요소 중 가장 작은 값이 `k`이상이 되는 연산을 몇번 반복했는지 반환하는 함수 
>    - 가장 작은 값 2개를 연산한 후 해당 배열에 다시 넣음.(연산할때마다 길이가 계속 1씩 줄어듬.)
> - 풀이법 : 우선순위 큐 활용
<br>

## 🔑 quiz solution

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        int cnt = 0;
        boolean isPossible = true;
        while(!pq.isEmpty()){
            if(pq.peek() >= k){
                break;
            }
            
            if(pq.size() < 2){
                isPossible = false;
                break;
            }
            cnt++;
            int cookie1 = pq.poll();
            int cookie2 = pq.poll();
            pq.offer(cookie1 + cookie2 * 2);
        }
        
        if(isPossible == false){
            return - 1;
        }
        return cnt;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
