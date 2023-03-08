N = int(input())
nums = sorted(list(map(int, input().split())))
answer = 0

for i in range(N):
    num = nums[i]
    p1, p2 = 0, N-1
    while p1 < p2:
        if p1 == i:
            p1 += 1
            continue
        if p2 == i:
            p2 -= 1        
            continue
        temp = nums[p1] + nums[p2]
        if temp == num:
            answer += 1
            break
        if temp < num: p1 += 1
        else: p2 -= 1

print(answer)