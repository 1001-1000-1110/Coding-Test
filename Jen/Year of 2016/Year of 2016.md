# Year of 2016

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/12901> lv 1. Year of 2016 </a>

<br>

## 💡 approaches
> - 2016년 1월 1일은 금요일, 2016년 a월 b일은 무슨 요일인가 ?
> - 2016년은 윤년이다. 

<br>

## 🔑 quiz solution

> - days list를 만들어 요일을 저장한다.
> - days[1] = "FRI"가 되도록 순서를 저장한다. 
> - months list를 만들어 각 월 일수를 저장한다.
> - 구해야 하는 월까지 일수를 sum()으로 더해준다.
> - +b를 해 구해야 하는 일도 더해준다.
> - %7로 나눈 나머지를 저장한다.
> - day[index]값에 구한 값을 넣어 출력한다. 

```py
def solution(a, b):
    days = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"]
    months = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    answer = days[(sum(months[:a - 1]) + b) % 7]

    return answer
```