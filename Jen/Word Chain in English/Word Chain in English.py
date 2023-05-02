def solution(n, words):
    for i in range(1, len(words)): # 저장 X, 반복문 범위 = (1, len(words)), words[i][0] != words[i - 1][-1]을 수행하기 때문 
        if words[i][0] != words[i - 1][-1] or words[i] in words[:i]:
            return [(i % n) +1, (i // n) + 1] # 번호, 순서를 리스트에 담아 반환 
    else: 
        return [0, 0]