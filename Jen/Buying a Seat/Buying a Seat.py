def solution(seat):
    
    return len(list(set([tuple(seats) for seats in seat])))