package hackerrank.Day5.BalancedBrackets;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        char a = '(';
        char b = '{';
        char c = '[';

        char d = ')';
        char e = '}';
        char f = ']';
        if(s.length() % 2 == 1){
            return "NO";
        }
        Deque<Character> dq = new ArrayDeque<>();
        dq.offer(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            char now = s.charAt(i);
            if(now == d){
                if(!dq.isEmpty() && dq.peekLast() == a){
                    dq.pollLast();
                }else{
                    return "NO";
                }
            }else if(now == e){
                if(!dq.isEmpty() && dq.peekLast() == b){
                    dq.pollLast();
                }else{
                    return "NO";
                }
            }else if(now == f){
                if(!dq.isEmpty() && dq.peekLast() == c){
                    dq.pollLast();
                }else{
                    return "NO";
                }
            }else{
                dq.offer(now);
            }
        }

        if(!dq.isEmpty())
            return "NO";

        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
