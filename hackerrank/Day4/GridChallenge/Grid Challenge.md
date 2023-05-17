# Quiz Name
> ### HackerRank / [Basic] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-grid-challenge/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four"> Grid Challenge </a>

<br>

## 💡 approaches
>  - 문자열배열이 주어진다. String [] 
>  - 문자열을 구성하는 각 문자들을 오름차순 정렬한다.
>  - 첫 행부터 마지막 행까지, 세로 방향으로도 오름차순이면 "YES"를 반환한다.
>    - 아닌경우는 "NO"를 반환한다
>  

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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for(int i = 0; i < grid.size(); i++){

            String str = grid.get(i);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j< str.length(); j++){
                pq.add(str.charAt(j));
            }

            while(!pq.isEmpty()){
                sb.append(pq.poll());
            }
            grid.set(i, sb.toString());
        }

        for(int j = 0; j<grid.get(0).length(); j++){
            for(int k = 0; k < grid.size() - 1; k++){
                if(grid.get(k).charAt(j) > grid.get(k + 1).charAt(j)){
                    return "NO";
                }
            }
        }
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
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

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
