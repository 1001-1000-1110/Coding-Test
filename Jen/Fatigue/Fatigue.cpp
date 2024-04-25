/*
Exhaustive Search
DFS
Recursive
Visited Array Permutation

피로도 시스템, 일정 피로도를 사용해 던전을 탐색한다. 
'최소 필요 피로도'를 충족해야 탐험 시작 가능, 탐험 후 '소모 피로도' 존재
하루에 한 번 탐험할 수 있는 던전이 여러 개 존재, 최대한 많은 던전을 탐험하려고 한다. 

매개변수 : 현재 피로도 k, [["각 던전별 최소 필요도", "소모 피로도"], [], ... ] 2차원 배열 dungeons
return : 탐험 가능한 최대 던전 수   

1. 탐험한 던전 수를 0으로 시작해 DFS
2. 탐험하지 않은 던전, 해당 던전의 최소 필요 피로도가 k보다 작거나 같으면 해당 던전 탐험 (DFS 수행)
3. DFS가 끝난 던전은 다른 경우에 재탐색 할 수 있도록 visited[i] = false
4. 현재 탐험 던전 수가 이전 탐험 던전 수보다 크면 answer = cnt로 cnt 초기화 
*/

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