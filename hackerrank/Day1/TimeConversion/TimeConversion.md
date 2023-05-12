# Quiz Name
> ### HackerRank / [Basic] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-time-conversion/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one"> Time Conversion </a>

<br>

## 💡 approaches
>  - timeConversion메소드를 구현해야함
>    - 인자로 입력된 `12시간포맷 + (AM/PM)` 형태의 문자열을 -> `24시간포맷`으로 반환해야함

<br>

## 🔑 quiz solution

```java

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String[] timeInfo = s.split(":");
        //AM인 경우
        if(timeInfo[2].substring(2,4).equals("AM")){ 
            if(timeInfo[0].equals("12")){ //AM에서 12시인경우 00시로 변경
                timeInfo[0] = "00";
            }
            return timeInfo[0]+":"+timeInfo[1]+":"+timeInfo[2].substring(0, 2);
        }else{ //PM인 경우
            if(Integer.parseInt(timeInfo[0]) < 12){ //시간이 12보다 작은 경우 12를 더한다. ex) 08PM -> 20
                int temp = Integer.parseInt(timeInfo[0]) + 12;
                timeInfo[0] = String.valueOf(temp);
            }
            return timeInfo[0]+":"+timeInfo[1]+":"+timeInfo[2].substring(0, 2);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
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
