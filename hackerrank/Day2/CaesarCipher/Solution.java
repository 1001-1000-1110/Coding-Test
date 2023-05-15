package hackerrank.Day2.CaesarCipher;

import java.io.*;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        if(k > 26){
            k %= 26;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            //upper
            if(now >= 'A' && now <= 'Z'){
                if(now + k > 'Z'){
                    now = (char)(now + k - 'Z' + 'A' - 1);
                }else{
                    now = (char)(now + k);
                }
                sb.append(now);
                continue;
            }
            //lower
            if(now >= 'a' && now <='z'){
                if(now + k > 'z'){
                    now = (char)(now + k - 'z' + 'a' - 1);
                }else{
                    now = (char)(now + k);
                }
                sb.append(now);
                continue;
            }
            sb.append(now);
        }
        return sb.toString();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
