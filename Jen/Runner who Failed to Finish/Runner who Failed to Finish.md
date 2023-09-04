# Runner who Failed to Finish

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/42576>lv 1. Runner who Failed to Finish</a>

<br>

## 💡 approaches
>  1. participant, completion 배열을 더한 후 set으로 중복 제거를 한 배열을 반환받는 방법을 생각했었다. -> (X)
>  - 동명이인에 대한 예외처리를 할 수 없어 실패

>  2. collections module의 Counter class 활용 -> (O)

<br>

## 🔑 quiz solution

>  - collections.Counter(participant)에는 각 요소와 요소의 갯수가 key와 value로 저장되어 있다. 
>  - collections module의 Counter 객체끼리는 뺄셈이 가능하다는 점을 이용해 collections.Counter(completion)을 빼준다. 
>  - 최종적으로 answer에는 하나의 key와 value가 남아있게 되고, answer.keys()를 list 형태로 만들어 0번째 index를 반환한다. 

```py
import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion) 
    return list(answer.keys())[0] 
```

>  - <strong> TIL ! </strong>
>  - collections module의 Counter class
>  - Counter class는 dictionary를 확장한 class로 data의 갯수를 셀 때 유용하다.