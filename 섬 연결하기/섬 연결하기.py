def find_parent(parent,x):
	if parent[x] != x:
		parent[x] = find_parent(parent,parent[x])
	return parent[x]

def union_parent(parent,a,b):
	a = find_parent(parent,a)
	b = find_parent(parent,b)
	if a > b: parent[b] = a
	else: parent[a] = b

def solution(n, costs):
    answer = 0
    parent = [0] * n
    edges = []
    
    for i in range(n):
        parent[i] = i
    
    for a, b, c in costs:
        edges.append((c, a, b))
    edges.sort()
    
    for c, a, b in edges:
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            answer += c
            
    return answer