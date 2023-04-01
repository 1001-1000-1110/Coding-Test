#https://school.programmers.co.kr/learn/courses/30/lessons/12979

def solution(n, stations, w):
    answer = 0
    r = 2 * w + 1
    now = 0
    for i in stations:
        answer += (i - w - 1 - now) // r + ((i - w - 1 - now) % r != 0)
        now = i + w
    return answer + (n - now) // r + ((n - now) % r != 0)