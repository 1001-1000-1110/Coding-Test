def checkTree(tree, left, right):
    if left >= right: return 1

    root = (left+right) // 2
    
    if tree[root] == 0:
        for i in range(left, right+1):
            if tree[i] != 0: return 0
        return 1
    
    return min(checkTree(tree, left, root-1), checkTree(tree, root+1, right))

def solution(numbers):
    answer = []
    for number in numbers:
        binary = list(map(int, bin(number)[2:]))
        temp = len(binary)

        k = 1
        while temp > 2**k-1: k += 1
        complete_binary = [0]*(2**k-1-temp) + binary
        
        answer.append(checkTree(complete_binary, 0, len(complete_binary)-1))
        
    return answer