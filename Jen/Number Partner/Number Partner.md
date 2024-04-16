# Number Partner

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/131128> lv 1. Number Partner </a>

<br>

## 💡 approaches
> - X, Y가 있을 때 두개의 수에서 공통으로 나오는 수들을 조합해 가장 큰 수를 만든다. 
> - 이중 for문으로 i와 j가 같을 때 answer에 저장

<br>

## 🔑 quiz solution

> - 0-9 매칭을 사용해서 풀이한다.
> - range(9, -1, -1)을 사용해 풀이한다.
> - 9부터 0까지 역순으로 정렬, step은 -1  

```py
def solution(X, Y):
    answer = ''

    # x = {str(num): 0 for num in range(10)} # 반복 숫자를 저장하기 위한 dict
    # y = {str(num): 0 for num in range(10)} # 반복 숫자를 저장하기 위한 dict

    # for i in X: # X 문자열 하나씩 돌면서 count 
    #     x[i] += 1
    # for i in Y: # Y 문자열 하나씩 돌면서 count
    #     y[i] += 1
    
    for i in range(9, -1, -1): # (9, -1, -1)을 사용해 sort 함수를 사용하지 않고 문제 풀이
        answer += str(i) * (min(X.count(str(i)), (Y.count(str(i)))))

    if answer == '':
        return '-1'
    elif len(answer) == answer.count('0'): # 000인 경우 예외처리
        return '0'
    else:
        return answer
```

> - <strong>TIL ! </strong> 
> - sort 사용 시 time out을 주의한다.
> - 이중 for문으로 i와 j가 같을 때 answer에 저장하는 방법을 사용할 때는 time out을 주의한다. 
