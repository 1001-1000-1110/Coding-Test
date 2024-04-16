def solution(park, routes):
    answer = []

    W = len(park[0])
    H = len(park)

    dict = {'N':[-1, 0], 'S':[1, 0], 'W':[0, -1], 'E':[0, 1]}

    # 시작점을 찾아 answer에 좌표 저장 
    for i in range(H):
        for j in range(W):
            if 'S' in park[i][j]:
                answer.append(i)
                answer.append(j)

    for route in routes:
        op, n = route.split()
        n = int(n)   

        # 원래 위치 
        px = answer[0]
        py = answer[1]

        for _ in range(n):
            # 업데이트 위치
            x = answer[0]
            y = answer[1]

            # 명령에 따라 한 칸 이동한 위치 
            dx = answer[0] + dict[op][0]
            dy = answer[1] + dict[op][1]

            # 이동 불가 조건 
            if (dx < 0 or dy < 0) or (dx >= H or dy >= W) or ('X' in park[dx][dy]):
                answer = [px, py]
                break
            else:
                answer = [dx, dy]

    return answer
