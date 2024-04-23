# Cycle of Light Path

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/86052> lv 2. Cycle of Light Path </a>

<br>

## 💡 approaches
> - 구현, 시뮬레이션

> - S : 직진, L : 좌회전, R : 우회전 
> - 빛이 격자 끝을 넘어가는 경우 : 반대쪽으로 다시 돌아온다. 
> - 격자 내 빛이 이동할 수 있는 경로 사이클이 몇 개 있고, 각 사이클의 길이를 구해야 한다. 
> - 경로 사이클 : 빛이 이동하는 순환 경로 
> - 주어진 격자를 통해 만들어지는 경로 사이클의 모든 길이를 배열에 담고 오른차순으로 정렬해 return  

> - 가능한 모든 경로와 방향을 시작으로 사이클을 탐색한다. 
> - 이미 방문한 방향, 노드는 탐색하지 않는다. 
> - 사이클이 만들어지지 않는 경우 X : 서로 다른 사이클을 구한다. 

> 1. 방문 표시를 위해 각 좌표 별 4 방향을 체크하는 3차원 배열을 만든다. 
>    visited[r][c][d] : (r, c)에서 d 방향으로 이동한 적이 있는지 
> 2. 모든 노드와 방향에 대해 방문한 적이 없다면 사이클을 탐색한다. 
> 3. 출발점으로 다시 돌아올 때까지 탐색한다. 

> - def move() : 모듈러 연산으로 좌표를 넘어가면 다시 처음으로 돌아오도록 한다. 
> - def rotate() : 다음 노드가 R, L인 경우 방향 회전

```py
def move(r, c, d):
    global directions, n, m
    dx, dy = directions[d]

    return (r + dx) % n, (c + dy) % m

def roatate(d, node):
    if node == 'R':
        d = (d + 1) % 4
    elif node == 'L':
        d = (d - 1) % 4
    
    return d

def solution(grid):
    global directions, n, m, answer
    answer = []
    n, m = len(grid), len(grid[0])

    visited = [[[False for _ in range(4)] for _ in range(m)] for _ in range(n)]
    directions = [[1, 0], [0, -1], [-1, 0], [0, 1]] # D, L, U, R

    for r in range(n):
        for c in range(m):
            for d in range(4):
                if not visited[r][c][d]:
                    cx, cy, cd = r, c, d
                    cnt = 0

                    while not visited[cx][cy][cd]:
                        visited[cx][cy][cd] = True
                        cnt += 1
                        cx, cy = move(cx, cy, cd)
                        cd = roatate(cd, grid[cx][cy])
                    
                    answer.append(cnt)
                    
    return sorted(answer)
```

<br>

## 💡 approaches  
> -  DFS
> - 하나의 격자에서 빛을 쏘면 내부에서 사이클을 이룬다. = 하나의 길로 들어간다. = DFS
```cpp
bool cache[r][c][dir]
```
> - r, c 격자에 dir 방향으로 방향으로 들어온 적이 있는지 확인하는 배열
> - dir 방향이 들어온 적이 있다면 그에 해당하는 사이클이 존재한다는 의미
> - 아직 방문하지 않은 경로를 시작점으로 탐색, 이미 탐색한 경로를 갈 일은 X

```cpp
bool &ret = cache[r][c][in];
// if (ret != fasle) return;
ret = ture;
```
> - 위 코드에서 주석을 해제하면 이미 탐색한 경로로 넘어간다. 
> - 해당 문제에서 주석처리 된 부분을 그대로 둬도 정답으로 판별한다.
> - 즉, 이미 탐색한 경로를 건드리지 않는다는 가정이 성립

> - DFS 인자 
```
void dfs(vector<string> &grid, int sr, int sc, int si, int r, int c, int in, int cnt)
```
> - 매개변수 in은 현재 좌표로 들어오는 방향을 의미

> - DFS 움직임 구현
```cpp
// 0, 1, 2, 3
// 오, 왼, 아, 위
int dr[4] = {0, 0, 1, -1};
int dc[4] = {1, -1, 0, 0};

int LEFT[4] = {3, 2, 0, 1};
int RIGHT[4] = {2, 3, 1, 0};

...

    int out;
    
    if(grid[r][c] == 'S'){
        out = in;
    }
    else if(grid[r][c] == 'L'){
        out = LEFT[in];
    }
    else if(grid[r][c] == 'R'){
        out = RIGHT[in];
    }

    int nr = r + dr[out];
    int nc = c + dc[out];

    if(nr < 0) nr = R-1;
    if(nc < 0) nc = C-1;
    if(nr >= R) nr = 0;
    if(nc >= C) nc = 0;
    
    dfs(grid, sr, sc, si, nr, nc, out, cnt+1);
```
> - out은 나가는 방향을 의미하는 변수 

> - 현재 좌표가 S인 경우 나가는 방향을 in과 같게 설정한다.
> - 현재 좌표가 L인 경우 나가는 방향, in을 LEFT 배열에 넣은 방향으로 설정한다. 
> - dr, dc 배열은 <오른쪽, 왼쪽, 아래, 위> 나가는 순서로 배열이 저장되어 있다. 

> - 만약 L칸으로 들어온 방향이 아래인 경우라면 빛이 위에서 아래 L로 들어온 것이다. 
> - 따라서 빛은 L칸의 오른쪽으로 가야하고, dr[0]과 dc[0]을 사용해야 한다. 
> - 아래 방향인 2는 0ㅇ으로 매핑된다. 

> - 위 동작과 같이 RIGHT, LEFT 매핑 배열을 만들었다. 

> - in에 맞춰 out을 설정하고 격자 바깥으로 나갔다면 되돌아오도록 nr, nc를 설정한다. 
> - 그리고 다음 격자로 DFS 탐색을 계속한다.

> - 값 도출 조건
```cpp
if(r == sr && c == sc && si == in && cnt != 0)
{
    a = cnt;
    return;
}
```
> - 최종적으로 현재 좌표가 시작 좌표와 동일하고, 시작할 때 들어왔던 방향과 일치하면 
> - 현재까지 움직인 거리를 답에 저장하고 오름차순으로 return 

```cpp
#include <string>
#include <vector>
#include <cstring>
#include <algorithm>
#include <iostream>

using namespace std;

bool cache[501][501][4];
int dr[4] = {0, 0, 1, -1};
int dc[4] = {1, -1, 0, 0};

int LEFT[4] = {3, 2, 0, 1};
int RIGHT[4] = {2, 3, 1, 0};

int R, C;
// bool check = false;
int a;

void dfs(vector<string> &grid, int sr, int sc, int si, int r, int c, int in, int cnt) {
    
    if (r == sr && c == sc && si == in && cnt != 0) {
        a = cnt;

        return;
    }
    
    bool &ret = cache[r][c][in];
    // if(ret != false) return;
    ret = true;
    
    int out;
    
    if (grid[r][c] == 'S') {
        out = in;
    }
    else if (grid[r][c] == 'L') {
        out = LEFT[in];
    }
    else if (grid[r][c] == 'R') {
        out = RIGHT[in];
    }

    int nr = r + dr[out];
    int nc = c + dc[out];

    if (nr < 0) nr = R-1;
    if (nc < 0) nc = C-1;
    if (nr >= R) nr = 0;
    if (nc >= C) nc = 0;
    
    dfs(grid, sr, sc, si, nr, nc, out, cnt+1);
}

vector<int> solution(vector<string> grid) {
    memset(cache, 0, sizeof(cache));
    R = grid.size();
    C = grid[0].size();
    vector<int> answer;
    
    int ans;

    for (int i = 0; i < grid.size(); i++) {
        for (int j = 0; j < grid[i].size(); j++) {
            for (int k = 0; k < 4; k++) {
                if (!cache[i][j][k]) {
                    dfs(grid, i, j, k, i, j, k, 0);
                    answer.push_back(a);
                    a = 0;
                }
            }
        }
    }

    sort(answer.begin(), answer.end());
    
    return answer;
}

int main()
{
    vector<string> grid = {"SL", "LR"};
    vector<int> result = solution(grid);

    for (int num : result) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
```