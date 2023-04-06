# Quiz Name
> ### Programmers / [level 1] <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java"> k번째 수 </a>

<br>

## 💡 approaches
> 1. i번 - j번째 까지 배열 복사
>2. 오름차순 정렬
>3. k번째 수 저장

<br>

## 🔑 quiz solution

```java
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        //commands의 길이 만큼 반복
            //i부터j까지 배열에 저장
            //오름차순 정렬
            //k번째 수 return할 배열에 저장
        int[] answer = new int[commands.length];
        int answerIndex = 0;

        for(int r = 0; r < commands.length; r++){
            /* 특정 구간을 복사하는 Arrays.copyOfRange(원본배열, 복사할 시작 인덱스, 복사할 종료 인덱스)로 대체 가능.* 
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);*/
            int[] temp = new int[commands[r][1] - (commands[r][0] - 1)];//정렬에 사용할 배열
            int index = 0;
            for(int s = commands[r][0] - 1; s < commands[r][1]; s++){
                temp[index++] = array[s];
            }
            /* 특정 구간을 복사하는 Arrays.copyOfRange(원본배열, 복사할 시작 인덱스, 복사할 종료 인덱스)로 대체 가능.*/
            Arrays.sort(temp);
            answer[answerIndex++] = temp[commands[r][2] - 1];
        }
        return answer;
    }
}
```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  - Arrays.copyOfRange(원본배열, 복사할 원본배열의 시작인덱스, 복사할 원본배열의 종료 인덱스)  
> => 배열의 특정구간만 복사하는 메소드

