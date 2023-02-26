def solution(queue1, queue2):
    q = queue1 + queue2
    target = sum(q) // 2
    count = 0
    i, j = 0, len(queue1)
    SUM = sum(queue1)
    while i < len(q) and j < len(q):
        if target == SUM:
            return count
        if SUM < target:
            SUM += q[j]
            j += 1
        else:
            SUM -= q[i]
            i += 1
        count += 1
    return -1