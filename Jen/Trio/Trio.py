from itertools import combinations

def solution(number):

# 방법 1.    
    # answer = 0

    # for comb in list(combinations(number, 3)):
    # # combinations : list에 있는 모든 조합을 구할 수 있다. 
    #     if sum(comb) == 0:
    #         answer += 1

    # return answer

# 방법 2. 
    answer = 0
    l =len(number)

    for i in range(l - 2):
        for j in range(i + 1, l - 1):
            for k in range(j + 1, l):
                if number[i] + number[j] + number[k] == 0:
                    answer += 1

    return answer

number = [-2, 3, 0, 2, -5]
# [-2, 3, 0, 2, -5]
# [-3, -2, -1, 0, 1, 2, 3]
print(solution(number))
