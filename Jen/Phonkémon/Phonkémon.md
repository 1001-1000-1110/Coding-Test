# Phonkémon

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/1845>lv 1. Phonkémon </a>

<br>

## 💡 approaches
> - N마리의 폰켓몬 중 N / 2만큼 가져갈 수 있다. 종에 따라 번호를 붙여 관리할 때 최대한 다양한 종을 갖기 위한 방법은 ?
> - nums의 len이 N
> - N / 2만큼 반복하며 nums의 숫자가 같지 않을 때 count를 한다. 
> - i != i + 1로 숫자가 같지 않을 때 cnt++로 조건을 생각했다. 
> - 단 N / 2만큼만 cnt++을 해야한다. 

<br>

## 🔑 quiz solution

> - 중복 제거는 set을 통해 진행했다. 
> - N에 set을 통해 중복 제거한 nums의 len을 저장한다.
> - 만약 len(nums) / 2의 값이 N보다 큰 경우 N을 반환한다.
> - 이 외의 경우는 len(nums) / 2를 반환한다. 

```py
def solution(nums):
    answer = 0

    N = len(set(nums))

    if len(nums) // 2 > N:
        return N
    else:
        return len(nums) // 2
```

> - <strong> TIL ! </strong>
> - 중복되는 종이 많아 N / 2보다 적은 경우를 생각해야 했다. 이 경우는 종의 갯수만큼 고를 수 있다. 
> - min으로 더 적은 수를 선택하는 방법도 있다. 

```py
def solution(nums):
    return min(len(nums)/2, len(set(nums)))
```