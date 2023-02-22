from collections import deque
import heapq

INF = int(1e9)
dydx = ((1,0),(-1,0),(0,1),(0,-1))

def dijkstra(start, end, maps):
    C, R = len(maps[0]), len(maps)
    distance = [[INF]*C for _ in range(R)]
    q = []
    heapq.heappush(q, (0, start[0], start[1]))
    distance[start[0]][start[1]] = 0
    
    while q:
        dist, y, x = heapq.heappop(q)
        if distance[y][x] < dist: continue
        for dy, dx in dydx:
            _y, _x = y + dy, x + dx
            if not (0 <= _y < R and 0 <= _x < C) or maps[_y][_x] == 'X': continue
            d = dist + 1
            if d < distance[_y][_x]:
                distance[_y][_x] = d
                heapq.heappush(q, (d, _y, _x))
            if _y == end[0] and _x == end[1]:
                return distance[_y][_x]
    return INF

def bfs(start, end, maps):
    C, R = len(maps[0]), len(maps)
    distance = [[0]*C for _ in range(R)]
    q = deque([start])
    
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            _y, _x = y + dy, x + dx
            if not (0 <= _y < R and 0 <= _x < C) or maps[_y][_x] == 'X': continue
            if distance[_y][_x] == 0:
                distance[_y][_x] = distance[y][x] + 1
                q.append([_y, _x])
            if _y == end[0] and _x == end[1]:
                return distance[_y][_x]
    return INF  

def solution(maps):
    for i in range(len(maps)):
        for j in range(len(maps[i])):
            c = maps[i][j]
            if c == "S": start = [i, j]
            elif c == "L": lever = [i, j]
            elif c == "E": exit = [i, j]
    # solution 1. dijkstra
    # answer = dijkstra(start, lever, maps) + dijkstra(lever, exit, maps)

    # solution 2. BFS
    answer = bfs(start, lever, maps) + bfs(lever, exit, maps)
    if answer >= INF: answer = -1
    return answer