from heapq import heappush, heappop

def solution(jobs):
    answer = 0
    N = len(jobs)
    jobs.sort(reverse=True)
    readyQ = []
    
    while readyQ or jobs:
        # 처리할 작업
        if readyQ: time, req = heappop(readyQ)
        else:
            req, time = jobs.pop()
            current = req

        # 대기시간 + 작업시간
        answer += current - req + time
        current += time

        while jobs and jobs[-1][0] <= current:
            req_tmp, time_tmp = jobs.pop()
            heappush(readyQ, (time_tmp, req_tmp))

    return answer // N