#https://school.programmers.co.kr/learn/courses/30/lessons/87377

from math import inf

def solution(line):
    point = []
    x_min, x_max, y_min, y_max = inf, -inf, inf, -inf
    for i in range(len(line)):
        x1, y1, z1 = line[i]
        for j in range(i + 1, len(line)):
            x2, y2, z2 = line[j]

            if x1 * y2 - y1 * x2 == 0:
                continue

            x = (y1 * z2 - z1 * y2) / (x1 * y2 - y1 * x2)
            y = (z1 * x2 - x1 * z2) / (x1 * y2 - y1 * x2)
            if x == int(x) and y == int(y):
                x, y = int(x), int(y)
                point.append([x, y])
                x_min = min(x_min, x)
                x_max = max(x_max, x)
                y_min = min(y_min, y)
                y_max = max(y_max, y)
    Map = [['.' for _ in range(x_max + 1 - x_min)] for _ in range(y_max + 1 - y_min)]
    for x, y in point:
        Map[y_max - y][x - x_min] = '*'
    answer = []
    for i in range(len(Map)):
        answer.append(''.join(Map[i]))
    return answer