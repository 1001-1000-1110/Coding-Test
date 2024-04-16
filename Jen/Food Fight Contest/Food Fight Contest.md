# Food Fight Contest

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/134240> lv 1. Food Fight Contest </a>

<br>

## 💡 approaches
> - 음식의 양, 종류, 순서가 같다. 
> - 회문
> - 주어진 숫자 중 홀수가 있다면 -1을 한다. 
> - 배치를 나타내는 문자열을 return 하는데, 칼로리 낮은 순서에서 높은 순서로 return
> - 오름차순으로 저장하고, 0을 기준으로 reverse를 출력한다. 

<br>

## 🔑 quiz solution

> - food[i]가 홀수인지 체크, 홀일 때 -1을 해준다.
> - answer에 i값과 food[i]를 2로 나눈 값의 곱을 저장하고, 0을 더해준다. 
> - reverse_answer를 따로 선언, 오름차순으로 정렬된 answer를 역순으로 정렬하고 return 할 때 answer와 rev_answer를 더해 출력한다.  

```py
def solution(food):
    answer = ''
    
    for i in range(len(food)):
        if food[i] % 2 == 1:
            food[i] -= 1
        answer += str(i) * (food[i] // 2)
    answer += "0"
    rev_answer = "".join(reversed(answer[:-1]))

    return answer + rev_answer

food = [1, 3, 4, 6]
print(solution(food)) 
```

> - <strong> TIL ! </strong>
> - answer에 저장할 때 str(i)로 형변환을 해야한다. 
> - answer에 저장할 때 food[i] // 2에서 float을 고려해야 한다. 
