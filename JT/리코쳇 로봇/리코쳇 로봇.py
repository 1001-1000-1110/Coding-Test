from collections import deque

def solution(board):
    start = [0, 0]
    h, w = len(board), len(board[0])
    for i in range(h):
        for j in range(w):
            if board[i][j] == 'R':
                start = [i, j]
                break

    q = deque([start + [0]])
    check = [[0 for _ in range(w)] for _ in range(h)]
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    while q:
        x, y, c = q.popleft()
        if board[x][y] == 'G':
            return c
        check[x][y] = 1
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            go = False
            while 0 <= nx < h and 0 <= ny < w and board[nx][ny] != 'D':
                nx += dx[i]
                ny += dy[i]
                go = True
            if go and not check[nx - dx[i]][ny - dy[i]]:
                q.append([nx - dx[i], ny - dy[i], c + 1])
    return -1