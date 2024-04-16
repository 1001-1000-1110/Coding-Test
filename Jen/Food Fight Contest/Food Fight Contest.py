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
