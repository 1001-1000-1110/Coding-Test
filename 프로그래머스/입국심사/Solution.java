package 프로그래머스.입국심사;

import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        //심사하는 시간을 기준으로 이분탐색
        //심사하는 시간(mid)가 n인원을 모두 평가할 수 없는 경우 -> 심사시간을 늘린다
        //심사하는 시간(mid)가 n인원을 모두 평가할 수 있는 경우 -> 심사 시간을 줄여 더 효율적인 시간을 찾는다.

        Arrays.sort(times); //오름차순 정렬
        long left = 0;
        long right = (long)n * times[times.length - 1];
        long result = 0;
        while(left <= right){
            long cnt = 0; //주어진 시간(mid)동안 몇명을 심사했는지 나타내는 변수
            long mid = (left + right) / 2;
            for(int time : times){
                cnt += mid / time; //mid라는 시간동안, 심사가 가능인 인원수를 계산함(mid라는 시간동안 모든 심사관은 계속 일할 수 있다.)
            }
            if(cnt >= n){//심사시간(mid)동안 n인원을 모두 평가할 수 있으므로, 보다 최적화하기 위해 주어진시간(mid)를 줄인다.
                right = mid - 1;
                result = mid;
            }else{//심사시간(mid)동안 n인원을 모두 평가할 수 없으므로, 심사시간(mid)를 늘린다.
                left = mid + 1;
            }
        }
        return result;
    }
}