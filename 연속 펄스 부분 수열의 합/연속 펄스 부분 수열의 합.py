def solution(sequence):
    N = len(sequence)
    
    dp1, dp2 = [0]*N, [0]*N
    mul1, mul2 = 1, -1

    dp1[0], dp2[0] = sequence[0] * mul1, sequence[0] * mul2
    
    for i in range(1, len(sequence)):
        mul1 *= -1
        mul2 *= -1        
        dp1[i] = max(dp1[i-1] + sequence[i]*mul1, sequence[i]*mul1)
        dp2[i] = max(dp2[i-1] + sequence[i]*mul2, sequence[i]*mul2)

    return max(max(dp1), max(dp2))