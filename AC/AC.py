import sys
from collections import deque
input = sys.stdin.readline

for _ in range(int(input())):
    p = list(input().rstrip())
    n = int(input())
    arr_str = input().rstrip()[1:-1]
    if len(arr_str) == 0:
        arr = deque([])
    else:
        arr = deque(list(map(int, arr_str.split(","))))
    flag = 0
    start = 1 # 1이면 맨 앞부터, -1이면 맨 뒤부터
    for order in p:
        if order == "R":
            start *= -1
        else:
            if len(arr) == 0:
                print("error")
                flag = 1
                break
            if start == 1:
                arr.popleft()
            else:
                arr.pop()
    if flag == 0:
        print("[" + ",".join(list(map(str, list(arr)[::start]))) + "]")
