def solution(s):
    stack = [] # python에서 stack은 list로 구성된다. 

    for i in s:
        if not stack: # stack == empty, append i 
            stack.append(i)
        elif i == stack[-1]: # list의 마지막 원소 == s에서 pop되는 원소, list의 해당 원소를 pop
            stack.pop()
        else: # list의 마지막 원소 != s에서 pop되는 원소, 해당 원소를 list append
            stack.append(i)
    
    if len(stack) > 0: # 남은 문자열이 있다면 
        return 0
    else:
        return 1

s = "baabaa"
print(solution(s))
