def solution(elements):
    s = set()
    elements += elements
    SUM1 = 0
    for i in range(len(elements) // 2):
        SUM1 += elements[i]
        s.add(SUM1)
        SUM2 = SUM1
        for j in range(i + 1, len(elements) // 2 + i):
            SUM2 += elements[j] - elements[j - i]
            s.add(SUM2)
    return len(s)

print(solution([7,9,1,1,4]))