from collections import defaultdict

def solution(want, number, discount):
    answer = 0
    dic = defaultdict(int)
    product = defaultdict(int)
    now = defaultdict(int)

    for i in range(len(want)):
        dic[want[i]] = number[i]

    for i in range(10):
        now[discount[i]] += 1
        product[discount[i]] += 1

    def check():
        for i in dic:
            if dic[i] > now[i]:
                return False
        return True

    if check():
        answer += 1

    for i in range(10, len(discount)):
        now[discount[i - 10]] -= 1
        now[discount[i]] += 1
        product[discount[i - 10]] -= 1
        product[discount[i]] += 1
        if check():
            answer += 1

    return answer