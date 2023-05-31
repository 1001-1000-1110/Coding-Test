# Buying a Seat

> ### Programmers / <a href = https://school.programmers.co.kr/courses/16304/lessons/154055> lv 1. Buying a Seat </a>

<br>

## 💡 approaches
> - 100000 X 1000000 크기의 격자 모양 좌석이 있다. 
> - 관객이 원하는 자리의 좌표는 2차원 list seat에 [가로 좌표, 세로 좌표]로 저장되어 있다. 중복은 불가능 할 때, 표를 구하는데 성공한 사람의 수를 return 

> - 중복이 불가능하다. -> set을 사용해 중복 제거를 생각했다. 

<br>

## 🔑 quiz solution

> - tuple은 변경할 수 없고, hashable한 것을 이용해 list 값을 고유한 값인 tuple로 만들어준다. 
> - tuple로 변환 후 set()으로 중복을 제거한다. 
> - len으로 중복이 제거된 좌석의 좌표 수를 cnt 후 return 

```py
def solution(seat):
    
    return len(set([tuple(seats) for seats in seat]))
```