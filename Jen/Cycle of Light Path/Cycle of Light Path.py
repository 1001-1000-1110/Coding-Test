def move(r, c, d):
    global directions, n, m
    dx, dy = directions[d]

    return (r + dx) % n, (c + dy) % m

def roatate(d, node):
    if node == 'R':
        d = (d + 1) % 4
    elif node == 'L':
        d = (d - 1) % 4
    
    return d

def solution(grid):
    global directions, n, m, answer
    answer = []
    n, m = len(grid), len(grid[0])

    visited = [[[False for _ in range(4)] for _ in range(m)] for _ in range(n)]
    directions = [[1, 0], [0, -1], [-1, 0], [0, 1]] # D, L, U, R

    for r in range(n):
        for c in range(m):
            for d in range(4):
                if not visited[r][c][d]:
                    cx, cy, cd = r, c, d
                    cnt = 0

                    while not visited[cx][cy][cd]:
                        visited[cx][cy][cd] = True
                        cnt += 1
                        cx, cy = move(cx, cy, cd)
                        cd = roatate(cd, grid[cx][cy])
                    
                    answer.append(cnt)
                    
    return sorted(answer)

grid = ["SL", "LR"]
print(solution(grid))

# result = [16]