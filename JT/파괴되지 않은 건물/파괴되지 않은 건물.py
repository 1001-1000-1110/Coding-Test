#https://school.programmers.co.kr/learn/courses/30/lessons/92344

def solution(board, skill):
    answer = 0
    h, w = len(board), len(board[0])

    for j in range(w):
        t = board[0][j]
        for i in range(1, h):
            board[i][j] -= t
            t += board[i][j]

    for i in range(h):
        t = board[i][0]
        for j in range(1, w):
            board[i][j] -= t
            t += board[i][j]

    for type, r1, c1, r2, c2, degree in skill:
        if type == 1:
            board[r1][c1] -= degree
            if c2 + 1 < w:
                board[r1][c2 + 1] += degree
            if r2 + 1 < h:
                board[r2 + 1][c1] += degree
            if c2 + 1 < w and r2 + 1 < h:
                board[r2 + 1][c2 + 1] -= degree

        else:
            board[r1][c1] += degree
            if c2 + 1 < w:
                board[r1][c2 + 1] -= degree
            if r2 + 1 < h:
                board[r2 + 1][c1] -= degree
            if c2 + 1 < w and r2 + 1 < h:
                board[r2 + 1][c2 + 1] += degree

    for i in range(1, h):
        for j in range(w):
            board[i][j] += board[i - 1][j]

    for i in range(h):
        for j in range(1, w):
            board[i][j] += board[i][j - 1]

    for i in range(h):
        for j in range(w):
            if board[i][j] > 0:
                answer += 1

    return answer