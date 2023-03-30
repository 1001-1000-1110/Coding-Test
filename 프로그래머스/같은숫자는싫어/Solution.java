package 프로그래머스.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(arr[0]);
        list.add(arr[0]);

        for(int i = 1;  i < arr.length; i++){
            if(stack.peek() == arr[i])
                continue;
            stack.push(arr[i]);
            list.add(arr[i]);
        }

        int[] answer = new int[list.size()];
        for(int i = 0;  i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}