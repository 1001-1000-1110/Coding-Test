def solution(n, m, section):
    answer = 0
    p = 0
    for i in section:
        if p <= i:
            p = m + i
            answer += 1

    return answer