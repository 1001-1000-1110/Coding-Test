from heapq import *

def solution(N, road, K):
    INF = int(1e9)
    start = 1
    answer = 0
    distance = [INF] * (N+1)
    graph = [[] for _ in range(N+1)]
    q = []
    
    for a, b, c in road:
        graph[a].append((b, c))
        graph[b].append((a, c))
    
    distance[start] = 0
    heappush(q, (0, start))
    while q:
        dist, now = heappop(q)
                        
        if distance[now] < dist: continue
        if dist <= K: answer += 1
        
        for node, d in graph[now]:
            d += dist
            if distance[node] > d:
                distance[node] = d
                heappush(q, (d, node))

    return answer