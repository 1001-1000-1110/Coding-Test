from collections import deque

def solution(queue1, queue2):
    answer = 0
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    target = (sum1 + sum2) / 2
    
    queue1, queue2 = deque(queue1), deque(queue2)
    while queue1 and queue2 and sum1 != target:
        answer += 1
        if sum1 > target:
            sum1 -= queue1.popleft()
        else:
            queue1.append(queue2.popleft())
            sum1 += queue1[-1]
            
    return answer if sum1 == target else -1