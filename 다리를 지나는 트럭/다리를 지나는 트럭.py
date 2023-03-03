from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = deque([0]*bridge_length)
    truck_weights = deque(truck_weights)
    crnt_weight = 0
    while bridge:
        answer += 1
        crnt_weight -= bridge.popleft()
        if truck_weights:
            if crnt_weight + truck_weights[0] <= weight:
                w = truck_weights.popleft()
                crnt_weight += w
                bridge.append(w)
            else:
                bridge.append(0)
    return answer