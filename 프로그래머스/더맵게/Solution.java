package 프로그래머스.더맵게;

import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int val : scoville){
            pq.add(val);
        }

        int temp = pq.peek();
        int cnt = 0; //몇번 계산 했는지
        while(temp < K && pq.size() >= 2){
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            temp = pq.peek();
            cnt++;
        }

        if(temp < K) return -1;
        return cnt;
    }
}