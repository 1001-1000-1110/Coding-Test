package 프로그래머스.정수삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle[triangle.length - 1].length;

        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0){ //행의 첫번째 값인 경우, 좌측 상단의 값이 존재하지 않음.
                    triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
                    continue;
                }
                if(j == triangle[i].length - 1){ //행의 마지막 값인 경우, 우측 상단의 값이 존재하지 않음.
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                    continue;
                }
                triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];
            }
        }


        int answer = 0;
        for(int i = 0; i < n; i++){
            answer = Math.max(triangle[triangle.length - 1][i], answer);
        }
        return answer;
    }
}
