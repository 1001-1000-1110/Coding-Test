def solution(cap, n, deliveries, pickups):
    answer = 0
    delivery_idx, pickup_idx = n, n

    while n > 0:
        delivery, pickup = 0, 0
        while delivery_idx and deliveries[delivery_idx-1] == 0: delivery_idx -= 1
        while pickup_idx and pickups[pickup_idx-1] == 0: pickup_idx -= 1

        n = max(delivery_idx, pickup_idx)
        answer += n
        
        while delivery_idx and delivery < cap:
            delivery += deliveries[delivery_idx-1]
            delivery_idx -= 1
        if delivery > cap:
            delivery_idx += 1
            deliveries[delivery_idx-1] = delivery - cap
        
        while pickup_idx and pickup < cap:
            pickup += pickups[pickup_idx-1]
            pickup_idx -= 1
        if pickup > cap:
            pickup_idx += 1
            pickups[pickup_idx-1] = pickup - cap

    return answer*2