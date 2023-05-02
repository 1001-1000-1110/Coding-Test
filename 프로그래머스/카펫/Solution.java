package 프로그래머스.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        //카펫의 가로 세로는 최소 3이다.
        //브라운 + 옐로우의 개수를 만족하는지 경우만 찾아야함
        int sum = brown + yellow;

        for(int row = 3; ;row++){
            int col = sum / row;
            if(col < row){ //가로의 길이가 세로보다 짧은 경우는 건너 뜀,가로의 길이가 세로의 길이보다 크거나 같기 때문에(문제조건)
                continue;
            }
            if((col - 2) * (row -2) == yellow) //노란색의 개수가 같으면 조건만족
                return new int[]{col, row};
        }
    }
}