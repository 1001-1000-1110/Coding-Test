
# Quiz Name
> ### BaekJoon / [Gold 5] <a href = "https://www.acmicpc.net/status?user_id=pushedrumex&problem_id=5430&from_mine=1"> 5430.AC </a>


<br>

## 💡 approaches
>  - R 명령은 reverse함수나 slice([::-1])를 사용해보자 -> 시간초과 O(N)
>  - D 명령은 slice([1:])를 사용해보자 ->  시간초과 O(N)
## 💡 new approaches
>  - start이라는 변수에 배열의 시작에 대한 정보를 담자 -> O(1)
>  - deque를 사용하여 leftpop을 사용하자 -> O(1)
<br>

## 🔑 quiz solution

```py
import sys
from collections import deque
input = sys.stdin.readline

for _ in range(int(input())):
    p = list(input().rstrip())
    n = int(input())
    arr_str = input().rstrip()[1:-1]
    if len(arr_str) == 0:
        arr = deque([])
    else:
        arr = deque(list(map(int, arr_str.split(","))))
    flag = 0 # 정답 출력을 위한 flag
    start = 1 # 1이면 배열의 맨 앞부터, -1이면 배열의 맨 뒤부터
    for order in p:
        if order == "R":
            start *= -1
        else:
            if len(arr) == 0:
                print("error")
                flag = 1
                break
            if start == 1:
                arr.popleft()
            else:
                arr.pop()
    if flag == 0:
        print("[" + ",".join(list(map(str, list(arr)[::start]))) + "]")
```
### Time Complexity : O(N)

## 👩🏻‍🏫 TIL
>  - slice의 시간 복잡도는 복사되는 element의 개수에 비례
>  - sys.stdin.readline은 마지막 개행(\n)이 들어가기 때문에 입력을 받을 시, rstrip()함수를 사용하여 공백을 제거해줘야함

