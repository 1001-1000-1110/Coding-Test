package 프로그래머스.타겟넘버;

class Solution {
    static int n; //최대 깊이
    static int cnt;//조건을 만족하는 경우를 카운트함
    static int target;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        this.target = target;
        solve(0, 0, numbers); //인덱스, 값, 배열
        return cnt;
    }

    private static void solve(int depth, int val, int[] numbers){
        if(depth == n){
            if(val == target){
                cnt++;
            }
            return;
        }
        solve(depth + 1, val + numbers[depth], numbers); //더하는 경우
        solve(depth + 1, val - numbers[depth], numbers); //빼는 경우
    }
}