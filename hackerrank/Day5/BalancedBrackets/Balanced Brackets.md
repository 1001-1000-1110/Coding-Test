# Quiz Name
> ### HackerRank / [intermediate] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-balanced-brackets/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-five"> BalancedBrackets </a>

<br>

## 💡 approaches
>  - `()` `{}` `[]` 가 올바르게 짝지어져있으면 "YES" 그렇지 않으면 "NO"를 반환하는 메소드 구현
>  - `)`,`}`,`]`의 경우 스택을 사용하여 가장 뒤에 있는 문자와 현재 문자의 짝이 올바르면  
>  -  `(`,`{`,`[`의 경우 스택에 넣음
>  - 예외 처리
>    - 문자열의 길이가 홀수 인경우
>    - 모든 문자열의 문자를 순회한 뒤에도 stack이 비어있지 않은 경우
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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        char a = '(';
        char b = '{';
        char c = '[';
        
        char d = ')';
        char e = '}';
        char f = ']';
        if(s.length() % 2 == 1){
            return "NO";
        }
        Deque<Character> dq = new ArrayDeque<>();
        dq.offer(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            char now = s.charAt(i);
            if(now == d){
                if(!dq.isEmpty() && dq.peekLast() == a){
                    dq.pollLast();
                }else{
                    return "NO";
                }
            }else if(now == e){
                if(!dq.isEmpty() && dq.peekLast() == b){
                    dq.pollLast();
                }else{
                    return "NO";
                }
            }else if(now == f){
                if(!dq.isEmpty() && dq.peekLast() == c){
                    dq.pollLast();
                }else{
                    return "NO";
                }
            }else{
                dq.offer(now);
            }   
        }
        
        if(!dq.isEmpty())
            return "NO";
        
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
