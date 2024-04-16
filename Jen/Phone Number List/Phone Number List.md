# Phone Number List

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/42577>lv 2. Phone Number List</a>

<br>

## 💡 approaches
>  1. list 원소 접근이 불가능한 경우 == list['a']의 형태이므로 hash를 생각했다. 
>  2. 문자열이 특정 문자열로 시작하는지 확인할 수 있는 startswith() 사용을 생각했다. 

<br>

## 🔑 quiz solution

> - sorted로 phone_book list를 정렬시킨다. 
> - zip() 함수를 사용해 phone_list와 0번째 index를 제거한 phone_list를 i와 j에 매칭시킨다. 
> - phone_list[1:]이 phone_list로 시작하면 False를 return 한다. 
> - 위 경우를 제외하면 True를 return -> phone_book의 길이가 1인 경우 예외 처리 

```py
# implementation - sorted, zip, startswith
def solution(phone_book): 
    phone_list = sorted(phone_book)
    
    for i, j in zip(phone_list, phone_list[1:]):
        if j.startswith(i):
            return False
    return True

# hash
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
```

> - <strong> TIL ! </strong>
> - startswith() : 문자열이 특정 문자열로 시작하는지 확인할 수 있다. 