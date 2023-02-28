from collections import deque

def solution(people, limit):
    answer = 0
    people = deque(sorted(people, reverse = True)) 
    # max heavy, max light를 판별하기 위한 내림차순 정렬 

    while len(people) > 1:
        if (people[0] + people[-1]) <= limit:
            answer += 1
            people.pop()
            people.popleft()
        else:
            answer += 1
            people.popleft()

    if people: # 1명이 남은 경우 처리 
        answer += 1

    return answer

people = [70, 80, 50]
limit = 100

print(solution(people, limit))