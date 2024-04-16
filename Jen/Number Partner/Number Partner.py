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

X = "102"
Y = "1234501"
print(solution(X, Y)) 