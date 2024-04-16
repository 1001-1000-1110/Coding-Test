import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion) # Counter 객체는 뺄셈이 가능하다. 
    return list(answer.keys())[0] # 완주하지 못한 선수는 1명이므로 keys 값에서 [0]번째만 return
