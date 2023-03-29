package 프로그래머스.완주하지못한선수;

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        //각 배열을 오름차순으로 정렬함
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < participant.length; i++){
            //completion이 participant보다 크기가 -1이므로, 해당 상황에는 paricipant[i]가 완주하지 못한 선수임
            if(i == completion.length) return participant[i];
            //두 배열 모두 오름차순으로 정렬했기 때문에, 각 배열에서 현재 인덱스의 이름이 다르다면 완주하지 못한 선수
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return "";
    }
}
