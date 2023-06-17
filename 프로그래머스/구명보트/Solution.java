package 프로그래머스.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        //오름차순 정렬
        Arrays.sort(people);

        int left = 0; //people배열에서 탈출하지 못한 가장 가벼운 무게의 요소를 나타내는 `인덱스`
        int cnt = 0; //탈출 횟수

        for(int i = people.length - 1; i >= 0; i--){
            if(people[i] == -1)//이미 탈출한 경우는 건너뜀
                continue;
            if(people[i] + people[left] <= limit){ //가장 가벼운 사람과 동시에 탈출에 가능한 경우
                people[left] = -1;// -1로 탈출했음을 나타냄.
                left++;//가장 가벼운사람의 위치를 나타내는 left를 한칸 오른쪽으로 옮김
            }
            cnt++;//탈출 횟수 증가
        }

        return cnt;
    }
}