package 프로그래머스.프로세스;

import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        //우선순위큐는 배열을 크기순서대로 내림차순 정렬함
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
        }
        //priorities 배열의 순서대로q에 넣음
        Queue<Info> q = new LinkedList<>();
        for(int i = 0;  i < priorities.length; i++){
            q.add(new Info(i,priorities[i]));
        }

        //p의 첫번째 요소와 pq의 첫번째 요소를 비교함
        //동일한 값이면 꺼냄(실행함)
        //다른 값이면 p의 맨뒤로 넣음
        int cnt = 1;
        int answer = 0;
        while(!pq.isEmpty()){
            Info now = q.poll();
            if(now.value != pq.peek()){
                q.add(now);
                continue;
            }
            if(now.index == location){
                answer = cnt;
                break;
            }
            pq.poll();
            cnt++;
        }
        return answer;

    }
    class Info implements Comparable<Info>{
        int index;
        int value;
        public Info(int index, int value){
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Info i){
            return value - i.value;
            // return Integer.compare(value,i.value);
        }
    }
}