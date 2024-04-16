# 방법 1. 
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

# 방법 2. 정규식 풀이 코드 
# import re 
# regex : 정규 표현식을 사용할 때는 내장모듈인 re를 import
# 정규 표현식은 문자열에서 특정 문자를 추출할 때 사용한다. 

# def solution(dartResult):
#     bonus = {'S' : 1, 'D' : 2, 'T' : 3}
#     option = {'': 1, '*': 2, '#': -1}

#     p = re.compile('(\d+)([SDT])([*#]?)')
#     # compile : 패턴과 플래그가 동일한 정규식을 여러번 사용할 때 compile을 사용해 지정한다. 
#     # ? : quantifier 중 하나로 0이나 1을 나타내는 연산자이다. 아무것도 없거나 한개만 있는 경우에 작동하도록 추가
#     dart = p.findall(dartResult)
#     # 매치되는 모든 값을 찾아 리스트로 반환한다. 

#     for i in range(len(dart)):
#         if dart[i][2] == '*' and i > 0: 
#         # i > 0 : index = 0일 때 *이 나온 경우 마지막 3번째 점수에 보너스 점수가 들어가지 않도록 추가 
#             dart[i - 1] *= 2
#         dart[i] = int(dart[i][0]) ** bonus[dart[i][1]] * option[dart[i][2]]
    
#     return sum(dart)

dartResult = "1S2D*3T"
print(solution(dartResult))
