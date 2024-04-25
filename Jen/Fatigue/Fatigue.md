# Fatigue

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/87946> lv 2. Fatigue </a>

<br>

## 💡 approaches
> - Exhaustive Search
> - DFS
> - Recursive
> - Visited Array Permutation

> - 피로도 시스템, 일정 피로도를 사용해 던전을 탐색한다. 
> - '최소 필요 피로도'를 충족해야 탐험 시작 가능, 탐험 후 '소모 피로도' 존재
> - 하루에 한 번 탐험할 수 있는 던전이 여러 개 존재, 최대한 많은 던전을 탐험하려고 한다. 

> - 매개변수 : 현재 피로도 k, [["각 던전별 최소 필요도", "소모 피로도"], [], ... ] 2차원 배열 dungeons
> - return : 탐험 가능한 최대 던전 수  

```py
answer = 0
N = 0
visited = []

def dfs(k, cnt, dungeons):
    global answer 

    # 최대 방문 횟수 초기화
    if cnt > answer:
        answer = cnt

    # 방문 시작점 설정
    # DFS 탐색이 종료된 후 다른 시작점으로 탐색 시작
    for i in range(N):
        # dungeon[i][0] : i번째 던전의 최소 필요 피로도
        # dungeon[i][1] : i번째 던전의 소모 피로도 
        if k >= dungeons[i][0] and not visited[i]:
            visited[i] = 1 # 방문
            dfs(k - dungeons[i][1], cnt + 1, dungeons) # 줄어든 피로도로 던전 방문 시작
            visited[i] = 0 # 해당 순서로 던전을 모두 방문했으니, 다시 초기화

def solution(k, dungeons):
    global N, visited
    
    N = len(dungeons)
    visited = [0] * N

    dfs(k, 0, dungeons)

    return answer

def main():
    k = 80
    dungeons = [[80,20],[50,40],[30,10]]

    print(solution(k, dungeons))
    # result = 3

if __name__ == "__main__":
    main()
```

<br>

## 💡 approaches  
> 1. 탐험한 던전 수를 0으로 시작해 DFS
> 2. 탐험하지 않은 던전, 해당 던전의 최소 필요 피로도가 k보다 작거나 같으면 해당 던전 탐험 (DFS 수행)
> 3. DFS가 끝난 던전은 다른 경우에 재탐색 할 수 있도록 visited[i] = false
> 4. 현재 탐험 던전 수가 이전 탐험 던전 수보다 크면 answer = cnt로 cnt 초기화 

```cpp
#include <string>
#include <vector>
#define MAX 8

using namespace std;

int answer = 0;
bool visited[MAX] = {0};

void dfs(int cnt, int k, vector<vector<int>> &dungeons) {
    if (cnt > answer) answer = cnt;

    for (int i = 0; i < dungeons.size(); i++) {
        if (!visited[i] && dungeons[i][0] <= k) {
            visited[i] = true;
            
            dfs(cnt + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }

}

int solution(int k, vector<vector<int>> dungeons) {
    dfs(0, k, dungeons);

    return answer;
}
```