def solution(sequence):
    s1 = sequence[:]
    s2 = sequence[:]
    for i in range(len(s1)):
        if i % 2 == 0:
            s1[i] *= -1
        if i % 2 == 1:
            s2[i] *= -1

    Max = s1[0]
    Sum = 0
    for i in s1:
        Sum += i
        Sum = max(Sum, 0)
        Max = max(Sum, Max)
    Sum = 0
    for i in s2:
        Sum += i
        Sum = max(Sum, 0)
        Max = max(Sum, Max)
    return Max