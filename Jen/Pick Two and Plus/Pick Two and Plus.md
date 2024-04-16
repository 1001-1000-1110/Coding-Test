# Pick Two and Plus

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/68644>lv 1. Pick Two and Plus </a>

<br>

## 💡 approaches
> - number 배열에서 만들 수 있는 모든 수를 반환한다.
> - 모든 경우의 수를 확인하기 위해 comb 사용한다.  

<br>

## 🔑 quiz solution

> - set()으로 중복을 제거한다. 
> - combination을 사용해 모든 경우의 수를 확인한다. 
> - comb로 뽑은 2개의 숫자를 sum()을 사용해 더한 뒤, add()로 answer에 요소를 추가한다. 
> - sorted로 오름차순 정렬한다. 

```py
from itertools import combinations

def solution(numbers):
    answer = set() 

    for comb in combinations(numbers, 2): 
        answer.add(sum(comb))

    return sorted(answer) 
```

> - <strong> TIL ! </strong>
> - set()을 이용해 중복 제거가 가능하다.  