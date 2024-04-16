# Find Prime Numbers

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/12921> lv 1. Find Prime Numbers </a>

<br>

## 💡 approaches
> - 1부터 입력받은 n 사이의 소수 갯수를 반환한다.
> - for문으로 나눴을 때 나머지가 0인 경우를 cnt하고 cnt가 2개인 경우를 소수로 판별한다. 

<br>

## 🔑 quiz solution

> - 이중 for문을 사용하여 2부터 n + 1까지, 2부터 n까지 반복하며 나머지가 0일 때 break하고 이 외 경우는 cnt++ 한다. 
> - 이 경우 대량 계산에는 적합하지 않아 타임아웃이 될 가능성이 있었다. 

```py
def solution(n):
    answer = 0
    cnt = 0

    for n in range(2, n + 1):
        for i in range(2, n):
            if n % i == 0:
                break
        else:
            cnt += 1

    return cnt
```

> - <strong> TIL ! </strong>
> - 에라토스테네스의 체를 활용해 소수를 판별할 수 있다. 
> - 2, 3, 4를 제외한 배수를 제거하는 방식이고 대량 계산에 적합하다.

```py
def solution(n):
    num = set(range(2, n + 1))

    for i in range(2, n + 1):
        if i in num:
            num -= set(range(2 * i, n + 1, i))
    return len(num)
```