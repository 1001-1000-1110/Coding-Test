#include <string>
#include <vector>
#include <map>
 
using namespace std;
 
vector<int> solution(int n, vector<string> words) 
{
    map<string, int> word; // map을 이용해 사용 단어를 key 값으로 체크
    word[words[0]]++;

    for (int i = 1; i < words.size(); i++)
    {
        // 이전에 사용한 단어를 또 사용한 경우, 잘못된 단어를 사용한 경우에는 탈락한 사람의 번호, 순서를 반환 
        // 사용한 적 없는 단어가 나오면 이전 단어의 끝과 현재 단어의 맨 앞을 비교해 일치하는지 확인한다. 
        if (word[words[i]] || words[i].front() != words[i - 1].back())
            return {(i % n) +1,(i / n) + 1};

        word[words[i]]++;
    }

    return {0, 0};
}