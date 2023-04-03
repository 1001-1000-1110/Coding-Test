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
