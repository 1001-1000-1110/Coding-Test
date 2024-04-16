def solution(nums):
    answer = 0

    N = len(set(nums))

    if len(nums) // 2 > N:
        return N
    else:
        return len(nums) // 2

nums = [3,3,3,2,2,2]	
print(solution(nums))
