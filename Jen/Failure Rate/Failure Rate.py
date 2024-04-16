def solution(N, stages):
    answer = {} # dict의 형태로 변환 
    user = len(stages) # user의 수 

    for stage in range (1, N + 1):
        if user != 0: # user가 0이 아닌 경우 
            count = stages.count(stage) # stage를 클리어하지 못한 user의 수 
            answer[stage] = count / user # 실패율 
            user -= count # 다음 실패율을 계산하기 전, 이전 단계를 통과하지 못한 user를 거른다. 
        else: 
            answer[stage] = 0 # 예외처리 
    
    return sorted(answer, key=lambda x: answer[x], reverse=True)
    # lambda : 익명함수, 함수를 따로 선언하지 않고 lambda 식으로 대체한다.

N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
print(solution(N, stages))