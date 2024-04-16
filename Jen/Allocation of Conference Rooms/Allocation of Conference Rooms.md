# Allocation of Conference Rooms

> ### inflearn / <a href = https://www.inflearn.com/course/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8/dashboard> Allocation of Conference Rooms </a>

<br>

## 💡 approaches
> - 한 개의 회의실, n개의 회의가 있을 때 사용표를 설계한다. 
> - 회의 시작 시간, 끝 시간이 있고 회의는 서로 겹치면 안되는 상황에서 최대로 회의실을 사용할 수 있는 횟수를 출력한다. 

> - 주어진 조건에서 최대를 찾는다 -> greedy 활용
> - 회의가 끝나는 시간을 기준으로 정렬한다. 
> - 현재 회의가 끝나느 시간과 다음 회의 시작 시간을 비교한다.
> - 현재 회의가 끝나는 시간 <= 다음 회의 시작 시간인 경우 회의가 진행 가능하므로 cnt++

<br>

## 🔑 quiz solution

> - start, end를 tuple로 입력 받아 meeting list에 append
> - key = lambda x: x[1], x[0]을 기준으로 sort
> - 회의 끝 시간과 다음 회의 시작 시간을 비교했을 때 시작시간이 크거나 같은 경우를 만족하면 endtime에 end를 저장하고 cnt를 증가시킨다. 

```py
n = int(input()) # 회의 갯수 입력
meeting = [] # 회의 시작 시간, 끝 시간을 입력받을 list

for i in range(n):
    start, end = map(int, input().split()) # 회의 시작 시간, 끝 시간을 입력
    meeting.append((start, end)) # tuple 형태로 list에 append

meeting.sort(key = lambda x: (x[1], x[0]))
# sort 정렬 순위 : x[1] -> x[1], 즉 회의 끝 시간을 기준으로 sort
# x[1] : 회의 끝 시간, x[0] : 회의 시작 시간

endtime = 0 # 회의 끝 시간을 저장해야하기 위한 변수 선언 
cnt = 0 # 회의 수 cnt

for start, end in meeting:
    if start >= endtime: # 회의 끝 시간 <= 다음 회의 시작 시간 
        endtime = end # 회의 끝 시간을 endtime에 저장
        cnt += 1 # 회의가 진행 가능하므로 횟수 cnt

print(cnt)
```

> - <strong> TIL ! </strong>
> - best를 고르는 문제인 경우 greedy를 활용할 수 있다. 
> - greedy는 보통 sort를 필요로 하고, sort 순서대로 best를 탐색하며 코드 설계를 진행한다. 