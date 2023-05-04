# Quiz Name
> ### Programmers / [level3] <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/42895#"> N으로 표현 </a>

<br>

## 💡 approaches
>  - DP
>  - 숫자를 사용한 횟수를 인덱스, 만들어진 숫자들을 요소로하는 배열을 사용함

<br>

## 🔑 quiz solution

```java

import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if(N == number){
            return 1;
        }

        Set<Integer>[] sets = new Set[9];
        for(int i = 0;  i < 9; i++){
            sets[i] = new HashSet<Integer>();
        }
        sets[1].add(N); //1개로는 자기자신밖에 만들지 못함.

        for(int i = 2; i <= 8; i++){
            for(int j = 1; j < i; j++){
                //i 와 j의 조합 사칙연산(j, i - j)
                for(int n1: sets[j]){
                    for(int n2:sets[i - j]){
                        sets[i].add(n1 + n2);
                        sets[i].add(n1 - n2);
                        sets[i].add(n1 * n2);
                        if(n2 != 0){
                            sets[i].add(n1 / n2);
                        }
                    }
                }
            }
            //N이 i값 만큼 반복되는 수 넣기
            int num = 0;
            for(int k = 0; k < i; k++){
                num = num * 10 + N;
            }
            sets[i].add(num);

            for(int temp: sets[i]){
                if(temp == number){
                    return i;
                }
            }
        }
        return -1;
    }
}
```
## 👩🏻‍🏫 TIL
>  - 나누기를 사용할 때, 0을 나누면 안된다.(예외처리)
>  - DP 어렵다.
