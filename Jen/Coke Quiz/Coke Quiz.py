# 방법 1. 
def solution(a, b, n):
    answer = 0

    while n >= a:
        newCoke = n % a
        n = (n // a) * b
        answer += n
        n += newCoke

    return answer

# 방법 2. 
# solution = lambda a, b, n: max(n - b, 0) // (a - b) * b
# 한번에 계산하지 않고 a개만 팔고 b개 받는 과정은 a - b개씩 병을 소비하는 것과 같다. 
# 단 첫번째 진행할 때는 a개만 소비되기 때문에 b개만큼 받지 못해 -b
# 첫번째 조건을 먼저 계산 n - b, 반복 횟수는 n - b만큼
# (a - b)를 해주고 받는 병 b만큼 곱한다. 

a = 2
b = 1
n = 20
print(solution(a, b, n))
