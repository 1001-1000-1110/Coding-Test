package hackerrank.Day4.RecursiveDigitSum;

import java.io.*;

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {



        if(n.length() == 1)
            return Integer.parseInt(n);

        long sum = 0;
        for(int j = 0;  j < n.length(); j++){
            sum += (n.charAt(j) - '0');
        }
        n = String.valueOf(sum * k);

        while(n.length() > 1){
            sum = 0;
            for(int j = 0;  j < n.length(); j++){
                sum += (n.charAt(j) - '0');
            }
            n = String.valueOf(sum);
        }
        return Integer.parseInt(n);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
