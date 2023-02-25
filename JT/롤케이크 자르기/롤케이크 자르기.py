from collections import defaultdict

def solution(topping):
    ans = 0
    left = defaultdict(int)
    right = defaultdict(int)
    for i in range(1):
        if not left[topping[i]]:
            left['total'] += 1
        left[topping[i]] += 1

    for i in range(1, len(topping)):
        if not right[topping[i]]:
            right['total'] += 1
        right[topping[i]] += 1

    if left['total'] == right['total']:
        ans += 1

    for i in range(1, len(topping)):
        if not left[topping[i]]:
            left['total'] += 1
        left[topping[i]] += 1
        right[topping[i]] -= 1
        if not right[topping[i]]:
            right['total'] -= 1
        if left['total'] == right['total']:
            ans += 1

    return ans