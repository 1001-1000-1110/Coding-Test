package 백준.N과M12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N과M12 {
    static TreeSet<Integer> set = new TreeSet<>();
    static int[] nums;
    static int[] arr;
    static int N,M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st2.nextToken()));
        }

        nums = set.stream().mapToInt(Integer::intValue).toArray();
        arr = new int[M];
        dfs(0,0,0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int index, int startValueIndex,int length) throws IOException {

        if(length == M){
            for (int i = 0; i < length; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i = startValueIndex; i < nums.length; i++){
            arr[index] = nums[i];
            dfs(index + 1, i,length + 1);
        }
    }
}
