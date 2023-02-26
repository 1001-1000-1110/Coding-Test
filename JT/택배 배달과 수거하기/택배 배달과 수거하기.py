import math

def solution(cap, n, deliveries, pickups):
    count = 0
    start = len(deliveries) - 1
    check_d = 0
    check_p = 0
    idx = start
    while idx != -1:
        if check_p < pickups[idx]:
            num = math.ceil((pickups[idx] - check_p) / cap)
            count += (idx + 1) * num
            check_d += cap * num
            check_p += cap * num - pickups[idx]
        else:
            check_p -= pickups[idx]

        if check_d < deliveries[idx]:
            num = math.ceil((deliveries[idx] - check_d) / cap)
            count += (idx + 1) * num
            check_d += cap * num - deliveries[idx]
            check_p += cap * num
        else:
            check_d -= deliveries[idx]
        idx -= 1
    return count * 2