package 백준.후위표기식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후기표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char now = str.charAt(i);

            if(now == '+' || now =='-'){
                while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' ||
                        stack.peek() == '+' || stack.peek() == '-')){
                    sb.append(stack.pop());
                }
                stack.push(now);
            }else if(now == '*' || now =='/'){
                while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    sb.append(stack.pop());
                }
                stack.push(now);
            }else if( now == ')'){
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else if(now =='('){
                stack.push(now);
            }else{
                sb.append(now);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

}
