def solution(a, b):
    days = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"]
    months = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    answer = days[(sum(months[:a - 1]) + b) % 7]

    return answer

a = 5
b = 24
print(solution(a, b))
