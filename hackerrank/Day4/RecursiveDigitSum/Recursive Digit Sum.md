# Quiz Name
> ### HackerRank / [basic] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-recursive-digit-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four"> Recursive Digit Sum </a>

<br>

## 💡 approaches
>  - superDigit메소드 구현문제
>  - 숫자를 표현하는 문자열 n 과 정수 k가 주어진다
> 1. n * k한다.
> 2. 해당숫자를 구성하는 모든 값을 더한다.
> 3. 더한 값이 한자리수가 될떄까지 2.를 반복한다.
> 4. 한 자리수가 되면 값을 반환한다.

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
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        
        if(n.length() == 1)
            return Integer.parseInt(n); 
       
        long sum = 0;
        for(int j = 0;  j < n.length(); j++){
            sum += (n.charAt(j) - '0');
        }
        n = String.valueOf(sum * k);   

        while(n.length() > 1){
            sum = 0;
            for(int j = 0;  j < n.length(); j++){
                sum += (n.charAt(j) - '0');
            }
            n = String.valueOf(sum);   
        }
        return Integer.parseInt(n);
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

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
