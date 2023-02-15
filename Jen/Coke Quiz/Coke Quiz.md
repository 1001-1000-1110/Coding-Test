# Coke Quiz

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/132267> lv 1. Coke Quiz </a>

<br>

## 💡 approaches
>  - 빈 병 2개를 주면 새 콜라 1개를 준다. 
>  - a개의 빈 병을 가져다주었을 때 b개만큼 돌려받는다면 n개를 가졌을 때 몇 병 돌려받는가 
>  - n을 a로 나누었을 때 몫 * b 
>  - 반복은 단순 n까지가 아닌 n이 a보다 작아질 때까지를 생각해 while문을 사용해야겠다고 생각했다. 

<br>

## 🔑 quiz solution

>  - 반복의 범위는 while n >= a까지
>  - n을 a로 나누었을 때 값에 b를 곱한 값을 n에 저장해 n 값을 수정한다. 
>  - answer에 n의 값을 더해주며 돌려받는 병의 수를 누적해준다. 
>  - temp에는 n을 a로 나눈 나머지 값이 들어간다. 남은 병을 더해 다음에 마트갈 때 교환한다. 

```py
def solution(a, b, n):
    answer = 0

    while n >= a:
        temp = n % a
        n = (n // a) * b
        answer += n
        n += temp

    return answer
```

> - <strong> TIL ! </strong>
> - 방법 2. 
> - 한번에 계산하지 않고 a개만 팔고 b개 받는 과정은 a - b개씩 병을 소비하는 것과 같다. 
> - 단 첫번째 진행할 때는 a개만 소비되기 때문에 b개만큼 받지 못해 -b
> - 첫번째 조건을 먼저 계산 n - b, 반복 횟수는 n - b만큼
> - (a - b)를 해주고 받는 병 b만큼 곱한다. 
```py
solution = lambda a, b, n: max(n - b, 0) // (a - b) * b
```
