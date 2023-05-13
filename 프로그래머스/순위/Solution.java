package 프로그래머스.순위;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] map = new int[n][n];

        //인접행렬, 이겼으면 1 졌으면 -1를 채움
        for(int[] temp : results){
            int a = temp[0];
            int b = temp[1];
            map[a - 1][b - 1] = 1;
            map[b - 1][a - 1] = -1;
        }


        for(int i = 0; i < n; i++){
            for(int j = 0;  j < n; j++){
                for(int k = 0;  k < n; k++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                        map[j][i] = -1;
                    }else if(map[i][k] == -1 && map[k][j] == -1){
                        map[i][j] = -1;
                        map[j][i] = 1;
                    }
                }
            }
        }


        //n - 1개의 경기결과를 알면 명확한 순위를 알 수 있음
        int answer = 0;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(map[i][j] != 0){
                    cnt++;
                }
            }
            if(cnt == n - 1){
                answer++;
            }
        }

        return answer;
    }
}