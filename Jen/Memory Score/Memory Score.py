def solution(name, yearning, photo):
    answer = []

    # zip을 활용해 두개의 리스트를 묶어준다. 
    dict = {name:yearning for name, yearning in zip(name, yearning)}

    # 2차원 photo 배열을 돌며 원소가 name에 포함되어 있는 경우 name에 해당하는 yearning 점수를 더해준다. 
    for i in range(len(photo)):
        answer.append(0)
        for j in photo[i]:
            if j in dict.keys():
                answer[i] += dict[j]
    return answer

'''
def solution(name, yearning, photo):
    return [sum(yearning[name.index(j)] for j in i if j in name) for i in photo]
'''