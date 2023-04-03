# Walk in the Park

> ### Programmers / <a href = https://school.programmers.co.kr/learn/courses/30/lessons/172928> lv 1. Walk in the Park </a>

<br>

## 💡 approaches
>  1. 주어진 방향으로 이동할 때 공원을 벗어나는지 확인한다. 
>  2. 주어진 방향으로 이동 중 장애물을 만나는지 확인한다. 
>  - 이 두 가지 중 하나라도 해당되면, 명령을 무시하고 다음 명령을 수행한다. 
>  - 공원의 가로는 W, 세로는 H이고 좌측 상단이 (0, 0), 우측 하단은 (H - 1, W - 1)이다.
>    - 동서남북 이동을 dict에 저장해서 계산하는 것을 생각했다. 
>  - route의 원소는 이동할 방향, 이동할 칸 수이며 이동할 방향은 N, S, W, E로 나타낸다. 

>  - 산책 경로가 주어졌을 때, 공원의 크기와 장애물을 고려해 최종 좌표를 출력한다. 
>  1. 산책을 시작할 위치를 찾는다. 
>  2. 산책 시작 
>  3. 이동하는 동안 장애물을 만나면 위치를 업데이트 한다. 
>  4. 도착지로 가는 도중 장애물이 있다면 도착할 수 없는 부분을 고려해야 한다. 
>  5. 도착이 안되는 상황에서는 명령 수행 전 위치로 되돌아간 뒤 남은 명령을 수행한다. 

<br>

## 🔑 quiz solution

>  - 공원의 크기, 위치를 if문으로 처리했다. 
>  - 이동이 불가능한 조건에서는 해당 명령을 수행하기 전의 좌표를 정답에 저장 후 반복문 탈출
>  - 이동이 가능하면 dict에 맞춰 이동하도록 한다. 

```py
def solution(park, routes):
    answer = []

    W = len(park[0])
    H = len(park)

    dict = {'N':[-1, 0], 'S':[1, 0], 'W':[0, -1], 'E':[0, 1]}

    # 시작점을 찾아 answer에 좌표 저장 
    for i in range(H):
        for j in range(W):
            if 'S' in park[i][j]:
                answer.append(i)
                answer.append(j)

    for route in routes:
        op, n = route.split()
        n = int(n)   

        # 원래 위치 
        px = answer[0]
        py = answer[1]

        for _ in range(n):
            # 업데이트 위치
            x = answer[0]
            y = answer[1]

            # 명령에 따라 한 칸 이동한 위치 
            dx = answer[0] + dict[op][0]
            dy = answer[1] + dict[op][1]

            # 이동 불가 조건 
            if (dx < 0 or dy < 0) or (dx >= H or dy >= W) or ('X' in park[dx][dy]):
                answer = [px, py]
                break
            else:
                answer = [dx, dy]

    return answer
```

```cpp
#include <vector>
#include <string>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) 
{
    vector<int> answer;

    int W = park[0].size(); 
    int H = park.size();

    // unordered_map은 map보다 더 빠른 탐색을 위한 해쉬 테이블로 구현한 자료구조이다. 
    // 탐색 시간 복잡도는 O(1)이다. 
    // 중복된 데이터를 허용하지 않으며, 해시 테이블을 사용해 키의 순서를 유지하지 않는 자료구조라고 생각하면 된다. 
    // key가 유사한 데이터가 많을 시에 해시 충돌 가능성 때문에 성능이 떨어질 수 있는 것을 유의해야 한다. 
    // <char, vector<int>>에서 char은 key, vector<int>는 value이다.  directions는 map의 이름이다. 
    unordered_map<char, vector<int>> dict = {{'N', {-1, 0}}, {'S', {1, 0}}, {'W', {0, -1}}, {'E', {0, 1}}};

    for (int i = 0; i < H; i++) 
    {
        for (int j = 0; j < W; j++) 
        {
            if (park[i][j] == 'S') 
            {
                // push_back은 vector의 끝에 요소를 추가할 때 사용하는 함수이다. 
                answer.push_back(i);
                answer.push_back(j);
            }
        }
    }

    for (string route : routes) 
    {
        char op = route[0];
        // stoi는 string to int이다. 
        // substr는 문자열을 자르는 함수로 지정한 위치(1)부터 마지막 문자열까지 선택한다는 의미이다. 
        int n = stoi(route.substr(1));   

        int px = answer[0];
        int py = answer[1];

        for (int i = 0; i < n; i++) 
        {
            int x = answer[0];
            int y = answer[1];

            int dx = answer[0] + dict[op][0];
            int dy = answer[1] + dict[op][1];

            if (dx < 0 || dy < 0 || dx >= H || dy >= W || park[dx][dy] == 'X') 
            {
                answer = {px, py};
                break;
            }
            else answer = {dx, dy};
        }
    }

    return answer;
}
```