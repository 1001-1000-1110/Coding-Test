# Quiz Name
> ### HackerRank / [Basic] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one"> Plus Minus </a>

<br>

## 💡 approaches
>  - plusMinus메소드를 구현하는 문제
>    - 주어진 형태에 맞게 숫자를 출력해야함

<br>

## 🔑 quiz solution

```java
class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int zeroCnt = 0;
        int positiveCnt = 0;
        int negativeCnt = 0;
        for(Integer num : arr){
            if(num > 0){
                positiveCnt++;
            }else if(num == 0){
                zeroCnt++;
            }else{
                negativeCnt++;
            }
        }


        System.out.println(String.format("%.6f",(double)positiveCnt / arr.size()));
        System.out.println(String.format("%.6f",(double)negativeCnt / arr.size()));
        System.out.println(String.format("%.6f",(double)zeroCnt / arr.size()));

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  - String.format()을 활용한 출력방식
>    -String.format("포맷",출력할 값);
>    - 포맷
>    - > "%d" : 10진수  
     "%f" : 실수  
     "%.2f" : 실수(소수점 둘째 자리까지)  
     "%s" : 문자열