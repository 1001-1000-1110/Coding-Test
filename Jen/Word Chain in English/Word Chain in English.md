# Word Chain in English

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/12981> lv 2. Word Chain in English </a>

<br>

## 💡 approaches
>  - 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말한다. 
>  - 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작
>  - 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 한다.
>  - 이전에 등장했던 단어는 사용할 수 없고, 한 글자인 단어는 인정되지 않는다. 
>  - 탈락자가 있다면 [번호, 차례]를 반환하고 탈락자가 없다면 [0, 0]을 반환한다. 

<br>

## 🔑 quiz solution

>  - 저장하지 않고 반복문을 수행할 예정이므로 범위는 (1, len(words))으로 지정한다. 
>  - words[i][0] != words[i - 1][-1]을 수행하기 때문이다. 

```py
def solution(n, words):
    for i in range(1, len(words)): 
        if words[i][0] != words[i - 1][-1] or words[i] in words[:i]:
            return [(i % n) +1, (i // n) + 1] 
    else: 
        return [0, 0]
```

> - map을 이용해 사용 단어를 key 값으로 체크
> - 이전에 사용한 단어를 또 사용한 경우, 잘못된 단어를 사용한 경우에는 탈락한 사람의 번호, 순서를 반환 
> - 사용한 적 없는 단어가 나오면 이전 단어의 끝과 현재 단어의 맨 앞을 비교해 일치하는지 확인한다. 

```cpp
#include <string>
#include <vector>
#include <map>
 
using namespace std;
 
vector<int> solution(int n, vector<string> words) 
{
    map<string, int> word;
    word[words[0]]++;

    for (int i = 1; i < words.size(); i++)
    {
        if (word[words[i]] || words[i].front() != words[i - 1].back())
            return {(i % n) +1,(i / n) + 1};

        word[words[i]]++;
    }

    return {0, 0};
}
```
