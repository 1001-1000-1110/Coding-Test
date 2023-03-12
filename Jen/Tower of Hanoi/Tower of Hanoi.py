def solution(n):
    answer = []

    def hanoi(start, end, sub, n):
        if n == 1:
            answer.append([start, end])
        else:
            hanoi(start, sub, end, n - 1)
            hanoi(start, end, sub, 1)
            hanoi(sub, end, start, n - 1)
    
    hanoi(1, 3, 2, n)

    return answer

n = 2
print(solution(n))