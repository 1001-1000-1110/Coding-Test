package 프로그래머스.디스크컨트롤러;

import java.util.*;
class Solution {
    static class Info implements Comparable<Info>{
        int start; //작업 요청시간
        int time;  //작업에 소요되는 시간
        public Info(int start, int time){
            this.start = start;
            this.time = time;
        }
        @Override
        public int compareTo(Info i){ //소요되는 시간을 비교하여 정렬
            return Integer.compare(this.time,i.time);
        }

    }
    public int solution(int[][] jobs) {
        PriorityQueue<Info> pq = new PriorityQueue<>();

        //우선순위큐에 넣음
        for(int[] job : jobs){
            pq.offer(new Info(job[0],job[1]));
        }

        int cnt = 0; //작업의 기준이 될 변수 -> 현재시간
        int sum = 0; //소요시간의 총합을 더하는 변수
        while(!pq.isEmpty()){
            Queue<Info> q = new LinkedList<>();

            while(!pq.isEmpty() && pq.peek().start > cnt){ //요청받은 시간이, 현재 시간보다 늦은 경우
                q.offer(pq.poll());//임시 큐에 담아놓음
            }

            if(pq.isEmpty()){//우선순위 큐가 빈 경우
                cnt++; // 현재 시각에 실행할 수 있는 작업이 없으므로, 시간만 증가시킴
            }else{//실행할 수 있는 작업이 존재하는 경우
                cnt += pq.peek().time; //작업의 소요시간만큼 현재 시간을 증가시킴
                sum += cnt - pq.poll().start; // 작업의 요청부터 종료까지의 시간을 더함.
            }

            for(Info i : q){//임시 큐에 값을 다시 우선순위 큐에 넣음
                pq.offer(i);
            }
        }
        return sum / jobs.length;


    }
}