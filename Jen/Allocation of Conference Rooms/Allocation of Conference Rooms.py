n = int(input()) # 회의 갯수 입력
meeting = [] # 회의 시작 시간, 끝 시간을 입력받을 list

for i in range(n):
    start, end = map(int, input().split()) # 회의 시작 시간, 끝 시간을 입력
    meeting.append((start, end)) # tuple 형태로 list에 append

meeting.sort(key = lambda x: (x[1], x[0]))
# sort 정렬 순위 : x[1] -> x[1], 즉 회의 끝 시간을 기준으로 sort
# x[1] : 회의 끝 시간, x[0] : 회의 시작 시간

endtime = 0 # 회의 끝 시간을 저장해야하기 위한 변수 선언 
cnt = 0 # 회의 수 cnt

for start, end in meeting:
    if start >= endtime: # 회의 끝 시간 <= 다음 회의 시작 시간 
        endtime = end # 회의 끝 시간을 endtime에 저장
        cnt += 1 # 회의가 진행 가능하므로 횟수 cnt

print(cnt)
