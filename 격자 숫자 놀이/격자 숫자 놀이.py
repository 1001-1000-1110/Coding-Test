from collections import defaultdict

r, c, k = map(int, input().split())

# 100 * 100
arr = [list(map(int, input().split())) + [0] * 97 for _ in range(3)]
for _ in range(97): arr.append([0] * 100)

answer = 0

if arr[r-1][c-1] == k:
    print(answer)
    exit()

flag = False

# 현재 행, 열의 개수
rN, cN = 3, 3

for _ in range(100):
    answer += 1
    if rN >= cN:
        cN_temp = 0

        for i in range(rN):
            temp = []
            dic = defaultdict(int)

            for j in range(cN):
                if arr[i][j] == 0: continue
                dic[arr[i][j]] += 1

            # (숫자, 카운트)
            for n, cnt in sorted(dic.items(), key=lambda item: (item[1], item[0])):
                temp += [n, cnt]
            
            tempN = len(temp)

            for a in range(100):
                if a < tempN: arr[i][a] = temp[a]
                else: arr[i][a] = 0

            cN_temp = max(cN_temp, tempN)

        cN = cN_temp if cN_temp <= 100 else 100
    else:
        rN_temp = 0

        for j in range(cN):
            temp = []
            dic = defaultdict(int)

            for i in range(rN):
                if arr[i][j] == 0: continue
                dic[arr[i][j]] += 1

            for n, cnt in sorted(dic.items(), key=lambda item: (item[1], item[0])):
                temp += [n, cnt]

            tempN = len(temp)

            for a in range(100):
                if a < tempN: arr[a][j] = temp[a]
                else: arr[a][j] = 0

            rN_temp = max(rN_temp, tempN)

        rN = rN_temp if rN_temp <= 100 else 100

    if arr[r-1][c-1] == k:
        flag = True
        print(answer)
        break

# 불가능하거나 100초를 초과 -> -1
# 불가능한 경우는 언제일까
if not flag: print(-1)