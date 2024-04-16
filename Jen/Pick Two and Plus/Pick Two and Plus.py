from itertools import combinations

def solution(numbers):
    answer = set() # 중복 제거

    for comb in combinations(numbers, 2): # 모든 경우의 수를 확인하기 위해 comb 사용
        answer.add(sum(comb)) # set은 append가 아닌 add로 요소 추가, comb를 sum한 값을 넣어준다. 

    return sorted(answer) # 오름차순

numbers = [2,1,3,4,1]
print(solution(numbers))
