from collections import deque

def solution(number, k):
    number = deque(list(number))
    n = len(number)-k
    stack = [number.popleft()]
    while number:
        while k > 0 and stack and stack[-1] < number[0]:
            stack.pop()
            k -= 1
        stack.append(number.popleft())
    return "".join(stack[:n])