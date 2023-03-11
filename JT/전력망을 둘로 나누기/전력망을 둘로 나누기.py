from itertools import combinations
from collections import defaultdict, deque

def solution(n, wires):
    answer = 0
    Max = 0
    for i in combinations(wires, n - 2):
        node = defaultdict(list)
        check = [0, 1] + [0] * n
        for x, y in i:
            node[x].append(y)
            node[y].append(x)
        q = deque([1])
        count = 1
        while q:
            now = q.popleft()
            for nxt in node[now]:
                if not check[nxt]:
                    check[nxt] = 1
                    count += 1
                    q.append(nxt)
        if Max < count * (n - count):
           answer = abs(count - (n - count))
           Max = count * (n - count)
    return answer