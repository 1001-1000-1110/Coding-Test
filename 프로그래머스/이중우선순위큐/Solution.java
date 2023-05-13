package 프로그래머스.이중우선순위큐;

import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        //0,0 Ehsms 최댓값 최소값
        PriorityQueue<Integer> minq = new PriorityQueue<>();

        for(String op : operations){
            StringTokenizer st = new StringTokenizer(op);
            if(st.nextToken().equals("I")){
                minq.offer(Integer.parseInt(st.nextToken()));
            }else{
                if(st.nextToken().equals("-1")){//최소값을 삭제
                    minq.poll();
                }else{ //최대값을 삭제
                    List<Integer> temp = new ArrayList<>(minq);
                    Collections.sort(temp);
                    minq.clear();
                    for(int i = 0;  i < temp.size() - 1; i++){
                        minq.offer(temp.get(i));
                    }
                }
            }
        }

        int[] answer = new int[]{0,0};
        if(minq.size() == 0){
            return answer;
        }

        List<Integer> temp = new ArrayList<>(minq);
        Collections.sort(temp);
        if(minq.size() == 1){
            answer = new int[]{temp.get(0),temp.get(0)};
        }else{
            answer = new int[]{temp.get(temp.size() -1),temp.get(0)};
        }

        return answer;
    }
}