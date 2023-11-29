package 백준.수나누기게임;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 수나누기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];//숫자
        Map<Integer, Integer> numToIdx = new HashMap<>(); //숫자가 (nums와 scores에서)몇번째 인덱스에 위치하는 지 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxValue = -1;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            nums[i] = number;
            numToIdx.put(number,i);
            maxValue = Math.max(maxValue, number);
        }
        //점수를 계산한다.
        int[] scores =  new int[n];
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            int multiple = 1;
            while(value < maxValue){ // nums[i]에 2배,3배,4배 ... 값이 존재하는지 하나씩 확인한다.
                multiple++;
                value = nums[i] * multiple;
                if(numToIdx.containsKey(value)){
                    scores[i]++;
                    scores[numToIdx.get(value)]--;
                }
            }
        }
        for(int score: scores){
            bw.write(score+" ");
        }

        bw.flush();
        bw.close();
    }
}
