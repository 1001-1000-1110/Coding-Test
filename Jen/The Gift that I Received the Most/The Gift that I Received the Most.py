import numpy as np

def solution(friends, gifts):
    dic = {f : i for i, f in enumerate(friends)} 
    table = [[0] * len(friends) for _ in range(len(friends))] 
    presents = [0] * len(friends)

    for gift in gifts:
        g, t = gift.split()
        table[dic[g]][dic[t]] += 1

    array = np.array(table)

    given = array.sum(axis = 1)
    taken = array.sum(axis = 0)
    score = list(given - taken)

    for i in range(len(friends)):
        for j in range(i + 1, len(friends)):
            if table[i][j] > table[j][i]:
                presents[i] += 1
            elif table[j][i] > table[i][j]:
                presents[j] += 1
            else: # 같은 경우 
                if score[i] > score[j]:
                    presents[i] += 1
                elif score[j] > score[i]:
                    presents[j] += 1
    
    return max(presents)

def main():   
    friends = ["muzi", "ryan", "frodo", "neo"]
    gifts = ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]
    result = solution(friends, gifts)

    print(result)

if __name__ == "__main__":
    main()