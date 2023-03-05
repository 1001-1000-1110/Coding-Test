#https://school.programmers.co.kr/learn/courses/30/lessons/87694

from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 10001
    MAX = 105
    M = [[0 for _ in range(MAX)] for _ in range(MAX)]
    for r in rectangle:
        x1, y1, x2, y2 = r
        for i in range(x1 * 2, x2 * 2 + 1):
            for j in range(y1 * 2, y2 * 2 + 1):
                M[i][j] = 1

    start = [itemX * 2, itemY * 2, 0]
    target = [characterX, characterY]
    q = deque([start])
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    def check(x, y):
        cx = [1, 0, -1, 0, 1, -1, 1, -1]
        cy = [0, 1, 0, -1, 1, -1, -1, 1]
        for i in range(8):
            nx, ny = x + cx[i], y + cy[i]
            if 0 <= nx < MAX and 0 <= ny < MAX:
                if M[nx][ny] == 0:
                    return True
        return False

    for i in range(MAX):
        for j in range(MAX):
            if M[i][j] == 1 and check(i, j):
                M[i][j] = 2

    while q:
        x, y, c = q.popleft()
        if target[0] * 2 == x and target[1] * 2 == y:
            answer = min(answer, c // 2)
            break
        M[x][y] = 1
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < MAX and 0 <= ny < MAX and M[nx][ny] == 2:
                q.append([nx, ny, c + 1])
    return answer

print(solution(	[[1, 1, 7, 4], [3, 2, 5, 5], [4, 3, 6, 9], [2, 6, 8, 8]], 1, 3, 7, 8))
print(solution(	[[1, 1, 8, 4], [2, 2, 4, 9], [3, 6, 9, 8], [6, 3, 7, 7]], 9, 7, 6, 1))