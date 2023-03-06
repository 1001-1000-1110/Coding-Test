from itertools import product

def solution(users, emoticons):
    rates = list(product([10,20,30,40], repeat=len(emoticons)))
    join, amount = 0, 0
    for rate in rates:
        temp_join, temp_amount = 0, 0
        for user_rate, user_std in users:
            user_money = 0
            for i in range(len(emoticons)):
                if rate[i] >= user_rate:
                    user_money += emoticons[i] * (100 - rate[i]) * 0.01
            if user_money >= user_std:
                temp_join += 1
                user_money = 0
            temp_amount += user_money
        if temp_join > join:
            join, amount = temp_join, temp_amount
        elif temp_join == join:
            amount = max(amount, temp_amount)
    return [join, amount]