package 백준.문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();

        int bombLastIndex = bomb.length() - 1;
        char lastWord = bomb.charAt(bombLastIndex);

        Stack<Character> stack = new Stack<>(); //스택
        for(int i = 0;  i < input.length(); i++){
            stack.push(input.charAt(i));
            if(stack.peek() == lastWord){
                Stack<Character> temp = new Stack<>();
                temp.push(stack.pop());
                for(int j = bombLastIndex - 1; j >=0; j--){
                    if(!stack.isEmpty() && bomb.charAt(j) == stack.peek()){
                        temp.push(stack.pop());
                    }else{ //다른 단어인 경우, 기존 스택에 옮겨 담음
                        while(!temp.isEmpty()){
                            stack.push(temp.pop());
                        }
                        break;
                    }
                }
            }
        }

        int stackSize = stack.size();
        char[] reverse = new char[stackSize];
        for(int i = 0;  i <stackSize; i++){
            char now = stack.pop();
            reverse[i] = now;
        }
        StringBuilder sb = new StringBuilder();
       for(int i = reverse.length - 1; i >= 0; i--){
           sb.append(reverse[i]);
       }
       String ans = sb.toString();
       if(ans.length() == 0){
           ans = "FRULA";
       }
       System.out.println(ans);
    }
}
