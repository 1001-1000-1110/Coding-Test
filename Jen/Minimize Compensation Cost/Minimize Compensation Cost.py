import heapq

def solution(no, works):
    MaxHeap = []

    if no >= sum(works):
        return 0
    
    for work in works:
        heapq.heappush(MaxHeap, (-work, work))

    for _ in range(no):
        work = heapq.heappop(MaxHeap)[1] - 1 
        heapq.heappush(MaxHeap, (-work, work))

    return sum([i[1] ** 2 for i in MaxHeap])