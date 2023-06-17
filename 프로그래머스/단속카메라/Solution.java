package 프로그래머스.단속카메라;

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        //진출 지점을 기준으로 정렬한다.
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1],o2[1]));

        int answer = 1;
        int camera = routes[0][1];
        for(int i = 1; i < routes.length; i++){
            //가장 가까이에 설치된 카메라가 자신의 구간에 포함되지 않는 경우,
            if(routes[i][0] > camera){
                answer++;
                camera = routes[i][1];//자신의 구간이 끝나는 지점에 카메라 설치
            }
        }
        return answer;
    }
}