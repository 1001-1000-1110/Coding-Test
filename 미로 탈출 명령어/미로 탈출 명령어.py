from collections import deque
dxdy = (("d", 1, 0), ("l", 0, -1), ("r", 0, 1), ("u", -1, 0))

def solution(n, m, x, y, r, c, k):
    q = deque([[x, y, ""]])
    while q:
        x, y, path = q.popleft()
        l = len(path)

        if (l, x, y) == (k, r, c): return path

        if l < k:
            l += 1
            for direc, dx, dy in dxdy:
                _x, _y, _path = x + dx, y + dy, path + direc

                if not (1 <= _x <= n and 1 <= _y <= m): continue

                if abs(_x-r) + abs(_y-c) > k-l: continue

                q.append([_x, _y, _path])
                break
            
    return "impossible" 