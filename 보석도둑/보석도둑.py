import sys, heapq
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
jewels = sorted([list(map(int, input().rstrip().split())) for _ in range(N)])
bags = sorted([int(input().rstrip()) for _ in range(K)])

result = 0
jewels_tmp = []
# 수용무게가 낮은 가방부터
for bag in bags:
    # 가방에 넣을 수 있는 최대 가치의 보석 담기
    while jewels and bag >= jewels[0][0]: # 담을 수 있는 보석
        heapq.heappush(jewels_tmp, -heapq.heappop(jewels)[1])
    if jewels_tmp:
        result += heapq.heappop(jewels_tmp)
    elif not jewels:
        break;

print(-result)