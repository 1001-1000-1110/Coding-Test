# Trio

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/131705> lv 1. Trio </a>

<br>

## 💡 approaches
> - 조건 : 학생들은 각자 정수 번호가 있고, 3명의 정수 번호 합이 0일 때 삼총사이다. <br>
> - array를 3중 for문으로 훑으며 더했을 때 0인 경우 cnt++ <br>
> - [i] + [i + 1] + [i + 2] == 0인 경우 cnt++

<br>

## 🔑 quiz solution

> - itertools, cobination을 사용해 풀이하는 방법을 선택했다. 

```py
from itertools import combinations

def solution(number):
    answer = 0

    for comb in list(combinations(number, 3)):
    # combinations : list에 있는 모든 조합을 구할 수 있다. 
        if sum(comb) == 0:
            answer += 1

    return answer
```

> - 처음 접근했던 방법으로 풀이하기 위해서는 중복으로 더해주는 것을 주의해야한다.
> - 다음 for문으로 넘어갈 때 len(number)에서 하나씩 -1을 해주고, 초기값을 i+1, j+1로 설정한다.

```py
def solution(number):
    answer = 0
    l =len(number)

    for i in range(l - 2):
        for j in range(i + 1, l - 1):
            for k in range(j + 1, l):
                if number[i] + number[j] + number[k] == 0:
                    answer += 1

    return answer
```
