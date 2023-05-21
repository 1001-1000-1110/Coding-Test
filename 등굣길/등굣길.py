def solution(m, n, puddles):
    graph = [[0] * (m+1) for _ in range(n+1)]
    
    for y, x in puddles: graph[x][y] = -1
    for j in range(1, m+1):
        if graph[1][j] == -1: break
        graph[1][j] = 1
    for i in range(1, n+1):
        if graph[i][1] == -1: break
        graph[i][1] = 1
    
    for i in range(2, n+1):
        for j in range(2, m+1):
            if graph[i][j] != -1:
                if graph[i-1][j] != -1:
                    graph[i][j] += graph[i-1][j]
                if graph[i][j-1] != -1:
                    graph[i][j] += graph[i][j-1]

    return graph[n][m] % 1000000007