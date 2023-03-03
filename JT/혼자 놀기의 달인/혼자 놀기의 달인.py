from collections import defaultdict

def solution(cards):
    num = defaultdict(int)
    a, b = 0, 0
    for i in cards:
        if num[i]:
            continue
        j = i
        count = 0
        while not num[j]:
            num[j] += 1
            count += 1
            j = cards[j - 1]
        t = sorted([a, b, count])
        a, b = t[-1], t[-2]
    return a * b