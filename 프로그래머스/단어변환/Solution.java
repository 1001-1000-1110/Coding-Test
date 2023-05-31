package 프로그래머스.단어변환;

import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int targetIndex = Arrays.asList(words).indexOf(target);
        //변환할 수 없는 경우, 해당 배열에 target이 들어있지 않은 경우 종료
        if(targetIndex == -1){
            return 0;
        }


        //bfs
        //타겟단어가 되면 종료,
        //바뀐횟수, 단어를 담는 클래스필요
        boolean[] visited = new boolean[words.length];//이미 교체된 word를 true, 교체된적 없던 단어를 fasle로 표현
        Deque<Info> dq = new ArrayDeque<>();
        dq.add(new Info(begin,-1,0));//문자열,  words배열과 visited배열에서 문자열의 인덱스, 교체된 횟수
        int answer = 0;

        while(!dq.isEmpty()){
            Info now = dq.poll();
            if(now.word.equals(target)){ //target인 경우 종료
                answer = now.cnt;
            }
            //현재 문자열과 교체된적 없는 문자열을 비교함.(몇개의 문자가 일치하는지)
            for(int i = 0; i<words.length; i++){
                if(visited[i] == true) continue; //이미 교체된 문자열은 제외함.
                String comparedword = words[i];
                int cnt = 0;
                for(int j = 0; j < now.word.length(); j++){
                    if(now.word.charAt(j) == comparedword.charAt(j)){//공통되는 문자의 개수를 셈
                        cnt++;
                    }
                }
                if(now.word.length() - 1 == cnt){//1개를 제외하고 모두 일치하는 경우
                    dq.add(new Info(comparedword,i,now.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        return answer;
    }
    static class Info{
        String word;
        int index;
        int cnt;
        public Info(String word,int index, int cnt){
            this.word = word;
            this.index = index;
            this.cnt = cnt;
        }
    }
}