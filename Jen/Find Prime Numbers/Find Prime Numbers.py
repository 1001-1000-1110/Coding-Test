# 방법 1.
# def solution(n):
#     answer = 0
#     cnt = 0
#
#     for n in range(2, n + 1):
#         for i in range(2, n):
#             if n % i == 0:
#                 break
#         else:
#             cnt += 1
#
#     return cnt

# 방법 2. 
def solution(n):
    num = set(range(2, n + 1))

    for i in range(2, n + 1):
        if i in num:
            num -= set(range(2 * i, n + 1, i))
    return len(num)

n = 10
print(solution(n))
