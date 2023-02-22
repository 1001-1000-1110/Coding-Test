# Dart Game

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/17682> lv 1. Dart Game </a>

<br>

## 💡 approaches
>  - 총 3번의 기회, 보너스 점수는 S : 1제곱, D : 2제곱, T : 3제곱으로 구성되어 있다. 
>  - 옵션으로 * : 현재 점수, 직전 점수가 2배, # : 현재 점수만큼 마이너스도 있다. 
>  - *은 중복이 가능하며, 겹친 경우에는 4배가 된다. 
>  - #의 경우 *와 중복이 가능하고 이 경우 -2배가 된다. 
>  - SDT는 점수마다 하나씩, *, #은 점수마다 하나씩 존재하거나 존재하지 않을 수 있다.

>  - for문으로 dartResult만큼 반복, if문으로 조건마다 점수를 지정, 리스트에 append 한다. 
>  - 이때 *의 경우 len(점수 리스트)가 1보다 큰 경우로 조건 설정, index [-2]와 [-1]로 현재 점수와 직전 점수를 지정한다. 

<br>

## 🔑 quiz solution

>  - 조건문 중 문자열에서 숫자인 경우 : isnumeric()을 사용해 분리했다. 
>  - int로 감싸주어 형변환을 했기 때문에, 조건문이 끝날 때마다 다시 n = ''로 만들어주어야 한다. 
>  - #의 경우 -1을 곱해주고 더하는 방법을 선택했다. 

```py
def solution(dartResult):
    n = ''
    answer = []

    for i in dartResult:
        if i.isnumeric():
            n += i
        elif i == "S":
            n = int(n) ** 1
            answer.append(n)
            n = ''
        elif i == "D":
            n = int(n) ** 2
            answer.append(n)
            n = ''
        elif i == "T":
            n = int(n) ** 3
            answer.append(n)
            n = ''              
        elif i == "*":
            if len(answer) > 1:
                answer[-2] = answer[-2] * 2
                answer[-1] = answer[-1] * 2
            else:
                answer[-1] = answer[-1] * 2
        elif i == "#":
            answer[-1] = answer[-1] * -1

    return sum(answer)
```

> - <strong> TIL ! </strong>
> - 정규 표현식을 사용하면 더 간결하게 코드 작성을 할 수 있다. 

```py
import re 

def solution(dartResult):
    bonus = {'S' : 1, 'D' : 2, 'T' : 3}
    option = {'': 1, '*': 2, '#': -1}

    p = re.compile('(\d+)([SDT])([*#]?)')
    # compile : 패턴과 플래그가 동일한 정규식을 여러번 사용할 때 compile을 사용해 지정한다. 
    # ? : quantifier 중 하나로 0이나 1을 나타내는 연산자이다. 아무것도 없거나 한개만 있는 경우에 작동하도록 추가
    dart = p.findall(dartResult)
    # 매치되는 모든 값을 찾아 리스트로 반환한다. 

    for i in range(len(dart)):
        if dart[i][2] == '*' and i > 0: 
        # i > 0 : index = 0일 때 *이 나온 경우 마지막 3번째 점수에 보너스 점수가 들어가지 않도록 추가 
            dart[i - 1] *= 2
        dart[i] = int(dart[i][0]) ** bonus[dart[i][1]] * option[dart[i][2]]
    
    return sum(dart)
```