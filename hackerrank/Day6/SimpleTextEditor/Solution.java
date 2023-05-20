package hackerrank.Day6.SimpleTextEditor;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < q; i++){
            String[] command = br.readLine().split(" ");
            // System.out.println(Arrays.toString(command));
            if(command[0].equals("1")){
                StringBuilder sb = new StringBuilder();
                if(!stack.isEmpty()){
                    sb.append(stack.peek());
                }
                stack.add(sb.append(command[1]).toString());
            }else if(command[0].equals("2")){
                int k = Integer.parseInt(command[1]);
                String str = stack.peek();
                str = str.substring(0,str.length() - k);
                stack.add(str);
            }else if(command[0].equals("3")){
                String str = stack.peek();
                int k = Integer.parseInt(command[1]);
                // System.out.println(stack.peek() +" " + k);
                bw.write(str.substring(k-1, k)+"\n");
            }else if(command[0].equals("4")){
                stack.pop();
            }
        }
        bw.flush();
        bw.close();

    }
}
