def solution(s):
    stack = []

    for i in s:
        if i == "(":
            stack.append(i)
        else: 
            if stack: # len(stack) != 0, stack != empty
                stack.pop()
            else: # len(stack) == 0, stack == empty
                return False
    
    if stack != []:
        return False
    return True

s = ")("
print(solution(s))
