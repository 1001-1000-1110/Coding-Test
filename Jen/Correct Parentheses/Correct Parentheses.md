# Correct Parentheses

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/12909> lv 2. Correct Parentheses </a>

<br>

## 💡 approaches
> - Removing Pairs 문제를 참고, stack으로 풀이를 생각했다. 
> - 마지막 stack에 원소가 남아있는 경우 false return, 빈 경우 true return

<br>

## 🔑 quiz solution

>  1. "("의 경우 stack에 저장해준다. 
>  2. ")"의 경우 stack이 비어있는지 확인 후 비어있다면 false return 
>  3. 빈 상태가 아니라면 pop()
>  4. 올바른 괄호 조건이 충족되는 경우 -> len(stack) == 0, stack == empty이고
>  5. 올바른 괄호 조건이 아닌 경우 -> len(stack) != 0, stack != empty

```py
def solution(s):
    stack = []

    for i in s:
        if i == "(":
            stack.append(i)
        else: 
            if stack: 
                stack.pop()
            else: 
                return False
    
    if stack != []:
        return False
    return True
```