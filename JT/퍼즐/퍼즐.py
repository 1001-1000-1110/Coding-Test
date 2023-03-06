#https://www.acmicpc.net/problem/1525

from collections import defaultdict
from collections import deque

M = ''
start = []
for i in range(3):
    M += ''.join(map(str, input().split()))

start.append([M.find('0'), M, 0])

q = deque(start)
target = '123456780'
dic = defaultdict(lambda : 999)

dx = [1, -1, 3, -3]

def new_t(t, x, nx):
    nt = ''
    for i in range(len(t)):
        if i == x:
            nt += t[nx]
        elif i == nx:
            nt += t[x]
        else:
            nt += t[i]
    return nt

while q:
    x, t, c = q.popleft()
    if dic[t] < c:
        continue
    dic[t] = c
    if t == target:
        print(c)
        exit(0)
    for i in range(4):
        nx = x + dx[i]
        if (x == 2 or x == 5) and dx[i] == 1:
            continue
        if (x == 3 or x == 6) and dx[i] == -1:
            continue
        if 0 <= nx < 9:
            nt = new_t(t, x, nx)
            q.append([nx, nt, c + 1])
print(-1)