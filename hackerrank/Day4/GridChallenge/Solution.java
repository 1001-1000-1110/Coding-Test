package hackerrank.Day4.GridChallenge;

import java.io.*;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for(int i = 0; i < grid.size(); i++){

            String str = grid.get(i);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j< str.length(); j++){
                pq.add(str.charAt(j));
            }

            while(!pq.isEmpty()){
                sb.append(pq.poll());
            }
            grid.set(i, sb.toString());
        }

        for(int j = 0; j<grid.get(0).length(); j++){
            for(int k = 0; k < grid.size() - 1; k++){
                if(grid.get(k).charAt(j) > grid.get(k + 1).charAt(j)){
                    return "NO";
                }
            }
        }
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
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

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
