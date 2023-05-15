# Quiz Name
> ### HackerRank / [Basic] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-countingsort1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-two"> Counting sort1 </a>

<br>

## 💡 approaches
>  - 주어진 배열의 요소(0 ~ 100)가 몇개 있는지 파악하여 반환하는 메소드 구현.
>  - 

<br>

## 🔑 quiz solution

```java
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        Collections.sort(arr, Collections.reverseOrder());

        int[] cntArray = new int[100];
        for(int num: arr){
            cntArray[num]++;
        }

        List<Integer> answer = new ArrayList<>();
        for(int num: cntArray){
            answer.add(num);
        }

        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.countingSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
