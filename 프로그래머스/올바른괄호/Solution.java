package 프로그래머스.올바른괄호;
import java.util.*;
class Solution {
    boolean solution(String s) {

        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(dq.size() == 0||dq.peekLast() == c){ //같으면 넣음 || 가장 처음에는 dq가 비어있으므로 그냥 넣음
                dq.offer(c);
            }else{ //다르면 제거함
                if(c == '(') // ")("의 경우는 잘못된 쌍이므로 false를 반환.
                    return false;
                dq.pollLast();
            }

        }

        if(dq.size() != 0 )
            return false;

        return true;

    }
}