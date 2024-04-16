# Tower of Hanoi

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/12946> lv 2. Tower of Hanoi </a>

<br>

## 💡 approaches
> - 세 개의 기둥이 있고, 기둥에 꽂을 수 있는 다양한 크기의 원판이 있다. 
> - 규칙
>  1. 한번에 하나의 원판만 이동한다. 
>  2. 큰 원판이 작은 원판 위에 있어서는 안된다. 
> - 규칙에 따라 최소한의 움직임으로 첫번째 기둥에서 세번째 기둥으로 옮기는 방법을 반환한다. 

> - 출발 기둥 : start, 보조 기둥 : sub, 도착 기둥 : end
> - hanoi(start, end, sub, n) == start에서 sub를 거쳐 end로 n개의 원반을 운반
>  1. n - 1개의 원판을 1 -> 2 기둥으로 옮긴다. 
>  2. 남은 1개의 원판을 1 -> 3 기둥으로 옮긴다. 
>  3. 다시 n - 1개의 원판을 2 -> 3 기둥으로 옮긴다. 

<br>

## 🔑 quiz solution

>  1. 첫 번째 재귀에서 맨 끝의 n번째 원판을 목적지로 옮기기 위해 위에 있는 n - 1개의 원판을 sub로 옮긴다. 
>  2. 그 다음 n번째 원판을 목적지로 옮긴다. 
>  3. sub에 있는 n - 1개의 원판을 목적지로 옮긴다. 

> - 위 3단계를 1번 이상 거치면 3번 기둥에 완전히 동일한 순서로 원판이 놓이도록 옮겨지는데, 이때 1단계와 3단계에서 start와 end, sub가 변경된다. 
> - 처음에 주어진 출발지점과 도착 지점을 고려할 때 1번 기둥이 start, 2번 기둥이 sub, 3번 기둥이 end이다. 
> - 1단계에서는 start에 있는 n - 1개의 원판을 모두 sub로 옮겨야 한다. 1단계의 도착 기둥은 2번 기둥인 것이다. 
> - 이때 보조 기둥은 end 기둥이 된다. 따라서 재귀 호출할 때 함수 인자로 (start, sub, end, n - 1)가 되는 것이다. 
> - 재귀 종료문으로 n이 1이 될 때 종료되도록 설정하고, 반환한다. 
> - n이 1개일 때는 재귀를 사용하지 않아도 되기 때문이다. 
> - 2단계에서는 비어있는 3번 기둥(end)에 1번 기둥에 남아있는 원판(가장 큰 원판)을 옮긴다.
> - 3단계에서는 2번 기둥으로 옮긴 n - 1개의 원판을 3번 기둥으로 옮기게 된다. 
> - 이 때 2번 기둥은 start가 되고, 1번 기둥이 sub, 3번 기둥이 end가 된다. 
> - 따라서 재귀 호출 할 때 함수 인자는 (sub, end, start, n - 1)이 된다.

```py
def solution(n):
    answer = []

    def hanoi(start, end, sub, n):
        if n == 1:
            answer.append([start, end])
        else:
            hanoi(start, sub, end, n - 1)
            hanoi(start, end, sub, 1)
            hanoi(sub, end, start, n - 1)
    
    hanoi(1, 3, 2, n)

    return answer
```