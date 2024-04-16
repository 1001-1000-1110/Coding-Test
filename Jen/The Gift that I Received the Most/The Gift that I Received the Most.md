# The Gift that I Received the Most

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/258712> The Gift that I Received the Most </a>

<br>

## 💡 approaches
> - 

<br>

## 🔑 quiz solution

> 1. 두 사람이 선물을 주고 받은 기록이 있을 때, 더 많은 선물을 준 사람이 덜 준 사람에게 다음 달 선물을 하나 더 받는다. 
> 2. 두 사람이 선물을 주고 받은 기록이 없거나 같을 때, 선물 지수가 더 큰 사람이 덜 준 사람에게 다음 달 선물을 하나 받는다.
> - 선물 지수 : 이번 달까지 자신이 친구들에게 준 선물 수 - 받은 선물 수 
> - 만일 선물 지수까지 같다면 선물을 주고 받지 않는다. 
> - return = 다음 달 가장 많은 선물을 받는 친구가 받을 선물의 수 

```py
import numpy as np

def solution(friends, gifts):
    dic = {f : i for i, f in enumerate(friends)} 
    table = [[0] * len(friends) for _ in range(len(friends))] 
    presents = [0] * len(friends)

    for gift in gifts:
        g, t = gift.split()
        table[dic[g]][dic[t]] += 1

    array = np.array(table)

    given = array.sum(axis = 1)
    taken = array.sum(axis = 0)
    score = list(given - taken)

    for i in range(len(friends)):
        for j in range(i + 1, len(friends)):
            if table[i][j] > table[j][i]:
                presents[i] += 1
            elif table[j][i] > table[i][j]:
                presents[j] += 1
            else: # 같은 경우 
                if score[i] > score[j]:
                    presents[i] += 1
                elif score[j] > score[i]:
                    presents[j] += 1
    
    return max(presents)

def main():   
    friends = ["muzi", "ryan", "frodo", "neo"]
    gifts = ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]
    result = solution(friends, gifts)

    print(result)

if __name__ == "__main__":
    main()
```