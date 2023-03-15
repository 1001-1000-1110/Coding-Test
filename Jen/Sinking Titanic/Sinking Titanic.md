# Sinking Titanic

> ### inflearn / <a href = https://www.inflearn.com/course/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8/dashboard> Sinking Titanic </a>

<br>

## 💡 approaches
>  - n명의 승객이 구명 보트로 탈출하는데 보트에는 최대 2명이 탈 수 있고, m만큼 무게 제한이 있다. 
>  - 이때 모두 탈출하기 위해 최소한으로 필요한 보트의 갯수를 구한다. 

>  1. 승객의 몸무게를 오름차순으로 정렬한다. 
>  2. max, min을 더하고 무게 제한을 통과하는지 확인한다. 
>  3. 무게 제한을 통과하지 못하는 경우, 무거운 사람을 리스트에서 pop 시킨 뒤 보트의 갯수를 +1 추가한다. 
>  4. 두번째 max와 다시 더해 무게 제한 통과를 확인한다. 
>  5. 무게 제한을 통과한 경우, 두 사람을 리스트에서 pop 시킨 뒤 보트의 갯수를 +1 추가한다. 
>  6. 리스트의 요소가 남지 않을 때까지 위 과정을 반복한다. 
>  7. 마지막 한명이 남은 경우가 있을 수 있으므로 체크해준다. 

<br>

## 🔑 quiz solution

>  - pop() 함수를 이용해 리스트 숫자를 하나씩 제거하는 방법
>  - pop()을 사용하게 되면 요소들이 비워진 자리로 이동하는 연산을 하게 된다. -> 비효율적

```py
n, m = map(int, input().split())
a = list(map(int, input().split()))
cnt = 0
# 정렬
a.sort() 

while a:
    if len(a) == 1: # 마지막에 한명 남은 경우, 아래 if문에서 한명의 몸무게를 두 번 더하거나, else문에서 한명을 삭제하는 오류가 있을 수 있으므로 보트 1개를 증가시키고 반복문을 종료한다. 
        cnt += 1
        break
    if a[0] + a[-1] > m: # 둘이 타고갈 수 없는 경우
        a.pop() # 맨 뒤부터 삭제된다. 
        cnt += 1 # 구명 보트 1개 추가
    else: # 맨 처음, 맨 뒤 사람의 무게가 제한을 넘지 않을 때
        a.pop(0) # index 0번 삭제
        a.pop # 맨 뒤 index 삭제 
        cnt += 1 # 구명 보트 1개 추가

print(cnt)
```

>  - deque를 사용해 계산 시 자료는 움직이지 않고 포인트 변수만 이동, 다음 자료의 위치를 가리키는 방법 -> 효율적
>  - deque는 자료를 앞, 뒤에서 빼고 넣을 수 있고 이 과정에서 자료들이 이동하는 것이 아닌 포인트 변수가 가리키는 곳만 변하므로 리스트 형태로 문제를 푸는 것보다 효율적이다. 

```py
from collections import deque

n, m = map(int, input().split())
a = list(map(int, input().split()))
cnt = 0
# 정렬
a.sort() 
a = deque(a) # a list가 deque 자료구조로 변경된다. 

while a:
    if len(a) == 1:
        cnt += 1
        break
    if a[0] + a[-1] > m:
        a.pop()
        cnt += 1
    else:
        a.popleft()
        a.pop()
        cnt += 1

print(cnt)
```