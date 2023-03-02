# Sumo Wrestle

> ### inflearn / <a href = https://www.inflearn.com/course/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8/dashboard> Sumo Wrestle </a>

<br>

## 💡 approaches
>  - n명의 지원자가 있고 각 지원자마다 키와 몸무게가 주어진다. 
>  - 선수 선발 시, 키와 몸무게 둘 중 하나를 다른 선수와 비교해 하나라도 다른 선수보다 작은 경우가 있다면 선발에서 탈락한다. 

>  - 주어진 조건에서 최대를 찾는다 -> greedy 활용
>  - 키 기준으로 내림차순 sort를 한다. 
>  - 이때 가장 키가 큰 사람, 즉 index 0번은 무조건 선발된다.
>  - 두번째로 키가 큰 사람은 index 0번과 비교했을 때 몸무게가 더 무거운 경우에 선발된다. 
>  - n명의 지원자만큼 반복한다. 

<br>

## 🔑 quiz solution

>  - largest를 지정해 새로 갱신할 때마다 cnt를 한다. 

```py
n = int(input())
sumo = []

for i in range(n):
    height, weight = map(int, input().split())
    sumo.append((height, weight))

sumo.sort(reverse=True) # 내림차순 정렬

largest = 0
cnt = 0

for h, w in sumo:
    if w > largest: # largest 값이 갱신될 때마다 cnt를 증가시킨다.  
        largest = w
        cnt += 1

print(cnt)
```