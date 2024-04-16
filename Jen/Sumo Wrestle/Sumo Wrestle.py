n = int(input())
sumo = []

for i in range(n):
    height, weight = map(int, input().split())
    sumo.append((height, weight))

sumo.sort(reverse=True) # 내림차순 정렬

largest = 0
cnt = 0

for h, w in sumo:
    if w > largest: # largest 값이 갱신될 때마다 cnt를 증가시킨다.  
        largest = w
        cnt += 1

print(cnt)
