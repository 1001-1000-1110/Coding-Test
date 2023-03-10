from heapq import heappop, heappush
from collections import defaultdict

def solution(operations):
    count = 0
    dic = defaultdict(int)
    min_heap = []
    max_heap = []
    answer = [0, 0]

    for o in operations:
        cmd, n = o.split()
        n = int(n)

        if cmd == "I":
            count += 1
            dic[n] += 1
            heappush(min_heap, n)
            heappush(max_heap, -n)
        elif count:
            count -= 1
            if n == -1:
                temp = heappop(min_heap)
                while dic[temp] <= 0:
                    temp = heappop(min_heap)
                dic[temp] -= 1
            else:
                temp = -heappop(max_heap)
                while dic[temp] <= 0:
                    temp = -heappop(max_heap)
                dic[temp] -= 1
    
    if count:
        temp = -heappop(max_heap)
        while dic[temp] <= 0:
            temp = -heappop(max_heap)  
        answer[0] = temp

        temp = heappop(min_heap)
        while dic[temp] <= 0:
            temp = heappop(min_heap)
        answer[1] = temp
    
    return answer