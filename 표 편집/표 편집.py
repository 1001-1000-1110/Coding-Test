def solution(n, k, cmd):
    table = ["O"] * n
    remove = []

    graph = [[-1, 1]]
    for i in range(1, n-1):
        graph.append([i-1, i+1])
    graph.append([n-2, -1])

    for c in cmd:
        
        if c == "C":
            remove.append(k)
            table[k] = "X"
            node = graph[k]
            
            if node[1] == -1:
                k = node[0]
                graph[node[0]][1] = -1
            elif node[0] == -1:
                k = node[1]
                graph[node[1]][0] = -1
            else:
                graph[node[0]][1] = node[1]
                graph[node[1]][0] = node[0]
                k = node[1]
                
        elif c == "Z":
            idx = remove.pop()
            node = graph[idx]
            table[idx] = "O"

            if node[0] != -1: graph[node[0]][1] = idx
            if node[1] != -1: graph[node[1]][0] = idx
            
            if k == -1: k = idx
            
        else:
            direc, num = c.split()
            num = int(num)
            
            if direc == "U":
                while num > 0:
                    k = graph[k][0]
                    num -= 1
                    
            else:
                while num > 0:
                    k = graph[k][1]
                    num -= 1

    return "".join(table)