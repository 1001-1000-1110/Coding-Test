# Small Substring

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/147355>lv 1. Small Substring </a>

<br>

## 💡 approaches
> - 숫자로 이루어진 문자열 t, p가 있을 때 t에서 p와 길이가 같은 부분문자열 중 p보다 작거나 같으면 cnt++ 후 return 
> - t를 len(p)만큼 split 후 변수에 저장 -> p와 저장한 부분 문자열을 비교하고 cnt를 증감한다.
> - 01, 02의 경우 따로 처리 해야하나 고민했다. 

<br>

## 🔑 quiz solution

> - split이 아닌 slicing을 사용했다. 
> - for문의 범위를 len(t) - len(p) + 1로 지정했다. -> index 0부터 시작하므로 + 1

```py
def solution(t, p):
    answer = 0

    for i in range(len(t) - len(p) + 1):
        if t[i:i + len(p)] <= p:
            answer += 1
    return answer
```
