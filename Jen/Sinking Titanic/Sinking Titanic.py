# 방법 1. 
# deque를 사용해 계산 시 자료는 움직이지 않고 포인트 변수만 이동, 다음 자료의 위치를 가리키는 방법으로 효율적이다. 
from collections import deque

n, m = map(int, input().split())
a = list(map(int, input().split()))
cnt = 0
# 정렬
a.sort() 
a = deque(a) # 리스트 a가 deque 자료구조로 변경된다. 

while a:
    if len(a) == 1:
        cnt += 1
        break
    if a[0] + a[-1] > m:
        a.pop()
        cnt += 1
    else:
        a.popleft()
        a.pop()
        cnt += 1

print(cnt)

# 방법 2. 
# pop() 함수를 사용해 계산 후 리스트의 숫자를 하나씩 삭제하는 방법 
'''
n, m = map(int, input().split())
a = list(map(int, input().split()))
cnt = 0
# 정렬
a.sort() 

while a:
    if len(a) == 1: # 마지막에 한명 남은 경우, 아래 if문에서 한명의 몸무게를 두 번 더하거나, else문에서 한명을 삭제하는 오류가 있을 수 있으므로 보트 1개를 증가시키고 반복문을 종료한다. 
        cnt += 1
        break
    if a[0] + a[-1] > m: # 둘이 타고갈 수 없는 경우
        a.pop() # 맨 뒤부터 삭제된다. 
        cnt += 1 # 구명 보트 1개 추가
    else: # 맨 처음, 맨 뒤 사람의 무게가 제한을 넘지 않을 때
        a.pop(0) # index 0번 삭제
        a.pop # 맨 뒤 index 삭제 
        cnt += 1 # 구명 보트 1개 추가

print(cnt)
'''
