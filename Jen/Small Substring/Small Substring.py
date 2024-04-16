def solution(t, p):
    answer = 0

    for i in range(len(t) - len(p) + 1):
        if t[i:i + len(p)] <= p:
            answer += 1
    return answer

t = "500220839878"
p = "7"
print(solution(t, p))
