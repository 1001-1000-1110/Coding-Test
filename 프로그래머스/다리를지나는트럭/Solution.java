package 프로그래머스.다리를지나는트럭;

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1; //계속해서 증가시켜주는 변수가 필요함.
        int total_weight = 0;
        Queue<Info> q = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++){
            while(q.size() >= bridge_length  || total_weight + truck_weights[i] > weight){
                if(q.peek().startTime + bridge_length > time){ //다리를 건너고 있는 가장 앞의 버스를 다리를 건너게하고, time에 다리를 건너는데 필요한 시간만큼 더해줌
                    time += q.peek().startTime + bridge_length - time;
                }
                total_weight -=  q.poll().weight;
            }
            q.add(new Info(truck_weights[i],time));
            total_weight += truck_weights[i];
            time++;
        }
        time += bridge_length;

        return time - 1;
    }
    static class Info{
        int weight; //무게
        int startTime; //다리에 진입한 시간

        public Info(int weight, int startTime){
            this.weight = weight;
            this.startTime = startTime;
        }
    }
}