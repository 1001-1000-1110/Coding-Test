package 백준.오큰수;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;  i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            //반복문
            while(!stack.isEmpty() && (A[i] > A[stack.peek()])){
                A[stack.pop()] = A[i];
            }
            //인덱스 push
            stack.push(i);
        }

        while(!stack.isEmpty()){
            A[stack.pop()] = -1;
        }

        for(int value : A){
            bw.write(value+" ");
        }
        bw.flush();
        bw.close();
    };
}
