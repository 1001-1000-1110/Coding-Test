def dfs(now, count, name, n, notA):
    if not notA: return count
    right = dfs(notA[0], count+abs(notA[0]-now), name, n, notA[1:])
    left = dfs(notA[-1]-n, count+now+n-notA[-1], name, n, notA[:-1])
    return min(left, right)
        
def solution(name):
    answer = 0
    notA = []
    n = len(name)
    for i in range(n):
        if name[i] != "A":
            notA.append(i)
            answer += min(ord(name[i])-ord("A"), ord("Z")-ord(name[i])+1)
    answer += dfs(0, 0, name, n, notA)
    return answer