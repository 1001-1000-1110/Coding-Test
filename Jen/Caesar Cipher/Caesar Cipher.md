# Caesar Cipher

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/12926> lv 1. Caesar Cipher </a>

<br>

## 💡 approaches
> - 일정 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식
> - 아스키코드 활용

<br>

## 🔑 quiz solution

> - chr() : 아스키코드 -> 문자로 변환한다.
> - ord() : 문자 -> 아스키코드로 변환한다. 

```py
def solution(s, n):
    s = list(s)

    for i in range(len(s)):
        if s[i].isupper(): # 대문자일 떄 
            s[i] = chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
        elif s[i].islower(): # 소문자일 때 
            s[i] = chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))

    return "".join(s)
```

> - <strong> TIL ! </strong>
> - Z/z의 범위를 넘지 않기 위해 나누기 26을 한다. 
> - 나눈 값에 다시 아스키코드를 더하면 밀린 값이 나온다. 