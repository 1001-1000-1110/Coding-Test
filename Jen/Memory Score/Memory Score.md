# Memory Score

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/176963> lv 1. Memory Score </a>

<br>

## 💡 approaches
>  - 사진에 나오는 인물의 그리움 점수의 합 -> 추억 점수
>  - dict을 활용해서 계산한다. 
<br>

## 🔑 quiz solution

>  - zip을 사용해 두 개의 리스트를 묶어준다. 
>  - 2차원 photo 배열을 돌며 원소가 name에 포함되어 있는 경우 name에 해당하는 yearning 점수를 더해준다.

```py
def solution(name, yearning, photo):
    answer = []

    dict = {name:yearning for name, yearning in zip(name, yearning)}

    for i in range(len(photo)):
        answer.append(0)
        for j in photo[i]:
            if j in dict.keys():
                answer[i] += dict[j]
    return answer
```

>  - List Comprension으로 더 간결하게 코드 작성을 할 수 있다. 

```py
def solution(name, yearning, photo):
    return [sum(yearning[name.index(j)] for j in i if j in name) for i in photo]
```

>  - unordered_map으로 dict을 대체

```cpp
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo)
{
    vector<int> answer;

    unordered_map<string, int> m;

    for (int i = 0; i < name.size(); i++) m[name[i]] = yearning[i];

    for (int i = 0; i < photo.size(); i++) 
    {
        int sum = 0;
        
        for (int j = 0; j < photo[i].size(); j++) sum += m[photo[i][j]];

        answer.push_back(sum);
    }
    return answer;
}
```