import sys
input = sys.stdin.readline

def init(start, end, node):
    if start == end: tree[node] = arr[start]
    else:
        mid = (start + end) // 2
        tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1)
    return tree[node]

def update(start, end, node, index, diff):
    if start <= index <= end:
        tree[node] += diff
        if start == end: return
        mid = (start + end) // 2
        update(start, mid, node*2, index, diff)
        update(mid+1, end, node*2+1, index, diff)

def find(start, end, node, index1, index2):
    if not (index2 < start or end < index1):
        if index1 <= start and end <= index2: return tree[node]
        mid = (start + end) // 2
        return find(start, mid, node*2, index1, index2) + find(mid+1, end, node*2+1, index1, index2)
    return 0
    
N, M, K = map(int, input().split())
tree = [0] * N * 4
arr = [0] + [int(input()) for _ in range(N)]
init(1, N, 1)

for _ in range(M+K):
    a, b, c = map(int, input().split())
    if a == 1:
        update(1, N, 1, b, c-arr[b])
        arr[b] = c
    else: print(find(1, N, 1, b, c))