def solution(rows, columns, queries):
    answer = []
    Map = [[i + columns * j + 1 for i in range(columns)] for j in range(rows)]

    for x1, y1, x2, y2 in queries:
        x1, y1, x2, y2 = x1 - 1, y1 - 1, x2 - 1, y2 - 1
        Min = Map[x1][y1]
        prev = Map[x1][y1]
        for i in range(y1 + 1, y2 + 1):
            prev, Map[x1][i] = Map[x1][i], prev
            Min = min(prev, Min)
        for i in range(x1 + 1, x2 + 1):
            prev, Map[i][y2] = Map[i][y2], prev
            Min = min(prev, Min)

        for i in range(y2 - 1, y1 - 1, -1):
            prev, Map[x2][i] = Map[x2][i], prev
            Min = min(prev, Min)

        for i in range(x2 - 1, x1 - 1, -1):
            prev, Map[i][y1] = Map[i][y1], prev
            Min = min(prev, Min)
        answer.append(Min)

    return answer