# Quiz Name
> ### Programmers / [level 3] <a href = "https://school.programmers.co.kr/learn/courses/30/parts/12263"> N으로 표현 </a>

<br>

## 💡 approaches
>  - dp
>  - dp 대상 : 사용하려는 숫자와 사용하려는 숫자의 개수
<br>

## 🔑 quiz solution

```py
def solution(N, number):
    dp = [set() for _ in range(9)]
    for i in range(1, 9):
        dp[i].add(int(str(N)*i))
        
        for j in range(1, i // 2 + 1):
            for n1 in dp[j]:
                for n2 in dp[i-j]:
                    dp[i].add(n1 + n2)
                    dp[i].add(n1 - n2)
                    dp[i].add(n2 - n1)
                    dp[i].add(n1 * n2)
                    if n2 != 0: dp[i].add(n1 // n2)
                    if n1 != 0: dp[i].add(n2 // n1)

        for target in dp[i]:
            if target == number: return i

    return -1
```

```java
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        String[] temp;
        
        for (int i=0;i<9;i++)
            dp[i] = new HashSet();
        
        for (int i=1;i<9;i++) {
            temp = new String[i];
            Arrays.fill(temp, String.valueOf(N));
            dp[i].add(Integer.parseInt(String.join("",temp)));
            
            for (int j=1;j<i/2+1;j++) {
                for (int n1: dp[j]) {
                    for (int n2: dp[i-j]) {
                        dp[i].add(n1 + n2);
                        dp[i].add(n1 - n2);
                        dp[i].add(n2 - n1);
                        dp[i].add(n1 * n2);
                        if (n2 > 0) dp[i].add(n1 / n2);
                        if (n1 > 0) dp[i].add(n2 / n1);
                    }
                }
            }
            for (int n: dp[i])
                if (n == number)
                    return i;      
        }
        
        return -1;
    }
}

```
### Time Complexity : O(N**8), set과 반복 횟수 (i//2 + 1)설정을 통한 시간 복잡도 개선
## 👩🏻‍🏫 TIL