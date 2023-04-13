from heapq import heappop, heappush

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
dxdy = ((-1, 0), (0, -1), (0, 1), (1, 0))

shark_x, shark_y = -1, -1
for i in range(N):
    for j in range(N):
        if graph[i][j] == 9:
            shark_x, shark_y = i, j
            break
    if shark_x > -1: break

def bfs(x, y):
    global size, shark_x, shark_y
    visited = [[False] * N for _ in range(N)]
    q = []
    heappush(q, [0, x, y])

    while q:
        cnt, x, y = heappop(q)
        # visited[_x][_y] = True
        if 0 < graph[x][y] < size:
            graph[shark_x][shark_y] = 0
            graph[x][y] = 0
            shark_x, shark_y = x, y
            return cnt
        for dx, dy in dxdy:
            _x, _y = x + dx, y + dy
            if not (0 <= _x < N and 0 <= _y < N) or visited[_x][_y] or graph[_x][_y] > size: continue
            heappush(q, [cnt + 1, _x, _y])
            visited[_x][_y] = True
    return 0

size, answer, eat = 2, 0, 0

while True:
    l = bfs(shark_x, shark_y)
    if l == 0: break
    answer += l
    eat += 1
    if eat == size:
        size += 1
        eat = 0

print(answer)