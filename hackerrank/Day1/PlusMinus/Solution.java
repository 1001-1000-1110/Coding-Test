package hackerrank.Day1.PlusMinus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int zeroCnt = 0;
        int positiveCnt = 0;
        int negativeCnt = 0;
        for(Integer num : arr){
            if(num > 0){
                positiveCnt++;
            }else if(num == 0){
                zeroCnt++;
            }else{
                negativeCnt++;
            }
        }


        System.out.println(String.format("%.6f",(double)positiveCnt / arr.size()));
        System.out.println(String.format("%.6f",(double)negativeCnt / arr.size()));
        System.out.println(String.format("%.6f",(double)zeroCnt / arr.size()));

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
