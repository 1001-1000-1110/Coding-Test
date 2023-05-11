package 프로그래머스.HIndex;

class Solution {
    public int solution(int[] citations) {
        int length = citations.length;
        int h = length;
        while(h > 0){
            int cnt = 0;
            for(int num : citations){
                if(num >= h){
                    cnt++;
                }
            }
            if(cnt >= h && length - cnt <= h){
                return h;
            }
            h--;
        }
        int answer = 0;
        return answer;
    }
}