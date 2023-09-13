# Clothes

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/42578> lv 2. Clothes</a>

<br>

## 💡 approaches
>  - hash, Counter

<br>

## 🔑 quiz solution

>  1. hash
>  - 옷 종류별로 구분하기 위해 hash_map dict에서 type key에 해당하는 값을 가져온다. 
>  - 만약 type key가 존재하지 않는다면 기본값으로 0을 반환한다. 
>  - 즉 의상이 이전에 등장하지 않았다면 0을 반환한다. 
>  - 가져온 값이 1을 더해 해당 종류의 의상 갯수를 1 증가시킨다.
>
>  - 입지 않은 경우를 추가해 모든 조합 계산
>  - type에 대한 의상 갯수를 가져와 현재 의상 종류에 대한 경우의 수를 answer에 누적곱한다. 
>
>  - 아무것도 입지 않은 경우 제외하기 위해 answer -1을 한다.

>  2. Counter 
>  - Counter class를 사용해 각 종류의 의상 갯수를 counter 변수에 저장한다.
>  - 모든 종류의 count + 1을 누적곱
>  - reduce : 누적 연산을 수행, 누적곱
>  - lambda acc, cur : acc * (cur+1) : 람다 함수를 정의
>  - 현재까지 누적값('acc')과 현재 요소('cur')를 받아 누적 곱을 계산 
>  - counter.values()에서 가져온 각 의상 종류의 갯수가 들어간다. 
>  - 각 의상 종류의 개수에 1을 더하여, 해당 종류의 의상을 입거나 입지 않은 경우 모두 고려
>  - counter.values() : 가져온 각 의상 종류의 갯수가 들어간다.
>  - 각 의상 종류의 갯수에 1을 더해 해당 의상 종류의 의상을 입거나 입지 않은 경우 모두를 고려
>  - counter.values(), 1 : 초기 누적 값을 1로 설정, 아무것도 입지 않은 경우를 고려하기 위한 초기값
>  - -1 : 모든 의상을 입지 않은 경우를 하나 뺸다. 즉 아무것도 입지 않은 경우를 제외한다. 

```py
# hash 
def solution(clothes):
    hash_map = {}

    for name, type in clothes: 
        hash_map[type] = hash_map.get(type, 0) + 1 

    answer = 1
    for type in hash_map:
        answer *= (hash_map[type] + 1)

    return answer -1 

# Counter
from collections import Counter
from functools import reduce

def solution(clothes): 
    counter = Counter([type for clothe, type in clothes])

    answer = reduce(lambda acc, cur : acc * (cur+1), counter.values(), 1) - 1
    
    return answer
```