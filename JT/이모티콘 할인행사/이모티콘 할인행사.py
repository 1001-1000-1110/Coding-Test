#from itertools import product

def solution(users, emoticons):
    sales = [40] * len(emoticons)
    n, m = 0, 0
    def cal(sales):
        nonlocal n, m
        cnt = 0
        money = 0
        for j in range(len(users)):
            account = 0
            for i in range(len(emoticons)):
                if users[j][0] <= sales[i]:
                    account += emoticons[i] * (100 - sales[i]) // 100
            if users[j][1] <= account:
                cnt += 1
            else:
                money += account
        if cnt >= n:
            if cnt == n:
                m = max(money, m)
            else:
                n, m = cnt, money

    def dfs(idx, sales):
        cal(sales)
        for i in range(idx, len(sales)):
            for j in range(10, 40, 10):
                sales[i] = j
                dfs(i + 1, sales)
            sales[i] = 40
    dfs(0, sales)
    # 아래와 같이 대체 가능
    # percents = (10, 20, 30, 40)
    # for s in product(percents, repeat=len(emoticons)):
    #   cal(s)
    return [n, m]