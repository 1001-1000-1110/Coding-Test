package hackerrank.Day6.JesseAndCookies;

import java.io.*;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        int cnt = 0;
        boolean isPossible = true;
        while(!pq.isEmpty()){
            if(pq.peek() >= k){
                break;
            }

            if(pq.size() < 2){
                isPossible = false;
                break;
            }
            cnt++;
            int cookie1 = pq.poll();
            int cookie2 = pq.poll();
            pq.offer(cookie1 + cookie2 * 2);
        }

        if(isPossible == false){
            return - 1;
        }
        return cnt;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

