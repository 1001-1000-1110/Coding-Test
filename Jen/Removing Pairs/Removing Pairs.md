# Removing Pairs

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/12973>lv 2. Removing Pairs </a>

<br>

## 💡 approaches
>  - 알파벳 문자열 중 연속되는 문자를 짝으로 제거 시키고 남은 문자열도 짝으로 제거가 가능하면 return 1, 아닐경우 return 0
>  - 완전 탐색으로 i == i + 1인 경우 pop -> 남은 s의 길이가 0일 때 return 0, else return 1을 생각했다. 

<br>

## 🔑 quiz solution

>  - 완전 탐색으로 코드 작성 시 효율성이 떨어지게 된다. -> timeout
>  - 두 개를 비교해 서로 같을 때 pop, 다를 때 append -> stack을 생각했다. 
>  1. list(temp) 생성 -> python에서 stack은 list로 구성된다. 
>  2. stack == empty, append i 
>  3. list의 마지막 원소 == s에서 pop되는 원소, list의 해당 원소를 pop
>  4. list의 마지막 원소 != s에서 pop되는 원소, 해당 원소를 append

```py
def solution(s):
    stack = [] 

    for i in s:
        if not stack: 
            stack.append(i)
        elif i == stack[-1]: 
            stack.pop()
        else: 
            stack.append(i)
    
    if len(stack) > 0: 
        return 0
    else:
        return 1
```

>  - <strong> TIL ! </strong>
>  - 두 개를 비교해 서로 같을 때 pop, 다를 때 append인 경우 -> stack을 사용해서 풀면 효율성이 좋아진다. 
>  - stack에서 원소 제거 X, 가져오기만 할 때 [-1] 사용 