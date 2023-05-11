# Quiz Name
> ### Programmers / [level] <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/42747"> H-Index </a>

<br>

## 💡 approaches
>  - h번 이상 인용된 논문이 h편 이상이다.
>    => h <= n (h가 아무리 커도 주어진 배열의 길이 n을 초과할 수는 없다.)


<br>

## 🔑 quiz solution

```java
import java.util.*;
class Solution {
    public int solution(int[] citations) {

        int length = citations.length; //citations의 길이
        int h = length;
        while(h > 0){
            int cnt = 0;
            for(int num : citations){
                if(num >= h){
                    cnt++;
                }
            }
            if(cnt >= h && length - cnt <= h){ //문제조건 인용회수가 h를 넘는 논문의 개수가 h개 이상 && h번을 초과하지 않는 논문의 개수가 h개 이하
                return h;
            }
            h--;
        }
        int answer = 0;
        return answer;
    }
}
```
### Time Complexity : O(N<sup>2</sup>)
## 👩🏻‍🏫 TIL
>  - 문제를 이해하는게 제일 어려웠다. 문해력을 키우자
