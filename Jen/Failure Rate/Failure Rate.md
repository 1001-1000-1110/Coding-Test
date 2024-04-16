# Failure Rate

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/42889> lv 1. Failure Rate </a>

<br>

## 💡 approaches
> - 전체 스테이지 수 : N, 플레이어가 현재 멈춰 있는 스테이지 번호 : 배열 stages
> - 스테이지에 도달했지만 clear하지 못한 플레이어 수 / 스테이지 도달한 플레이어수  
> - 실패율이 높은 스테이지부터 내림차순으로 retrun한다. 
> - stage 1 : 1/8 
> - stage 2 : 3/7 (-1)
> - stage 3 : 2/4 (-3)
> - stage 4 : 1/2 (-1)
> - stage 5 : 0/1 (-1)
> - N은 스테이지 반복 횟수, stage의 len으로 전체 플레이어 수를 찾는다.
> - 다음 스테이지로 넘어갈 때마다 통과한 플레이어와 통과하지 못한 플레이어를 구분해 전체 플레이어 수에서 빼주며 실패율을 계산한다. 

<br>

## 🔑 quiz solution

> - dict 형태로 저장 -> stage는 key, 실패율은 value 
> - dict을 value 기준으로 정렬 후 key를 출력한다.
> - 결과값 내림차순 정렬 후 stage 번호를 출력 -> sorted lambda x: answer[x] reverse=True를 사용해 코드를 작성

```py
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
```
