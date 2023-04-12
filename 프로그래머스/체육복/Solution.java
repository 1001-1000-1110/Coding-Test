package 프로그래머스.체육복;

import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] borrow = new boolean[lost.length];
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //도난 당한 사람이 여유옷을 가지고 있는 경우, 체육에 참여가능하지만 다른 사람들 대여해줄수는 없음.
        for(int l = 0; l < lost.length; l++){
            for(int i = 0; i < reserve.length; i++){
                if(lost[l] == reserve[i]){
                    borrow[l] = true; //대여 완료를 표시함.
                    reserve[i] = -1;
                    answer++;
                }
            }
        }

        for(int l = 0; l < lost.length; l++){
            if(borrow[l] == true) continue;//이미 대여한 경우는 건너뜀
            for(int i = 0; i < reserve.length; i++){
                if(lost[l] - 1 == reserve[i]){//앞사람에게 대여가 가능한 경우
                    answer++;
                    reserve[i] = -1; //한번만 빌려주기 위한 코드
                    break;
                }
                if(lost[l] + 1 ==  reserve[i]){//뒷사람에게 대여가 가능한 경우
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}