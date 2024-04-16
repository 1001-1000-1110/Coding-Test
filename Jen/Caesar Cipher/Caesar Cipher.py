def solution(s, n):
    s = list(s)

    for i in range(len(s)):
        if s[i].isupper(): # 대문자일 떄 
            s[i] = chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
        elif s[i].islower(): # 소문자일 때 
            s[i] = chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
        # chr() : 숫자를 인자로 주면 아스키코드에 해당하는 문자를 반환 (아스키코드 -> 문자)
        # ord() : 문자의 아스키코드를 반환 (문자 -> 아스키코드)
        # ord('문자') -> 아스키코드 정수 반환, chr(정수) -> '문자' 반환
        # Z/z 범위를 넘기지 않기 위해 % 26
        # 26을 나눈 값에 다시 아스키 값을 더해주면 뒤로 밀린 값이 나오게 된다. 

    return "".join(s)

s = "a B z"
n = 4
print(solution(s, n))
