# implementation - sorted, zip, startswith
def solution(phone_book): 
    phone_list = sorted(phone_book)
    
    for i, j in zip(phone_list, phone_list[1:]):
        if j.startswith(i):
            return False
    return True

# hash
'''
def solution(phone_book): 
    hash_map = {}
    
    for number in phone_book:
        hash_map[number] = 1
    
    for number in phone_book:
        temp = ""
        for i in number:
            temp += i
            if temp in hash_map and temp != number:
                return False
    
    return True
'''
