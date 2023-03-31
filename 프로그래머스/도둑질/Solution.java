package 프로그래머스.도둑질;

class Solution {
    public int solution(int[] money) {
        //첫번째 집 포함, 마지막집 제외
        int[] dp1 = new int[money.length];//마지막집은 제외하기 때문에 -1

        dp1[0] = money[0];
        dp1[1] = Math.max(money[0],money[1]);
        for(int i = 2; i < money.length - 1; i++){
            dp1[i] = Math.max(money[i] + dp1[i-2], dp1[i-1]);
        }
        //첫번째 집 제외, 마지막집 포함
        int[] dp2 = new int[money.length];
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1],money[2]);
        for(int i = 3; i < money.length; i++){
            dp2[i] = Math.max(money[i] + dp2[i-2], dp2[i-1]);
        }

        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}