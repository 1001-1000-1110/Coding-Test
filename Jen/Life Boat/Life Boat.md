# Life Boat

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/42885> lv 2. Life Boat </a>

<br>

## 💡 approaches
> - 보트를 가장 적은 횟수로 사용해 사람들을 이동시킨다. -> greedy 활용 
> - 제일 무거운 사람 + 제일 가벼운 사람을 짝지어 이동시킨다. 

<br>

## 🔑 quiz solution

> - people list를 deque로 만들고 내림차순 sort
> - 무거운 사람은 왼쪽, 가벼운 사람은 오른쪽 -> index 지정
> - 무게를 합해 limit보다 가벼우면 2명 다 빼기
> - limit보다 무거우면 무거운 사람 1명만 뺀다.

```py
from collections import deque

def solution(people, limit):
    answer = 0
    people = deque(sorted(people, reverse = True)) 
    # max heavy, max light를 판별하기 위한 내림차순 정렬 

    while len(people) > 1:
        if (people[0] + people[-1]) <= limit:
            answer += 1
            people.pop()
            people.popleft()
        else:
            answer += 1
            people.popleft()

    if people: # 1명이 남은 경우 처리 
        answer += 1

    return answer
```