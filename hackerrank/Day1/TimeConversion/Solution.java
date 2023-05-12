package hackerrank.Day1.TimeConversion;

import java.io.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String[] timeInfo = s.split(":");
        if(timeInfo[2].substring(2,4).equals("AM")){
            if(timeInfo[0].equals("12")){
                timeInfo[0] = "00";
            }
            return timeInfo[0]+":"+timeInfo[1]+":"+timeInfo[2].substring(0, 2);
        }else{
            if(Integer.parseInt(timeInfo[0]) < 12){
                int temp = Integer.parseInt(timeInfo[0]) + 12;
                timeInfo[0] = String.valueOf(temp);
            }
            return timeInfo[0]+":"+timeInfo[1]+":"+timeInfo[2].substring(0, 2);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
