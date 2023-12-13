package 백준.가장긴바이토닉부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;  i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] asc= new int [n];
        int[] desc = new int[n];
        //i번 까지 증가하는 부분수열의 길이를 구한다.
        asc[0] = 1;
        for (int i = 1; i < n; i++) {
            asc[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]){
                    asc[i] = Math.max(asc[j] + 1,asc[i]);
                }
            }
        }

        //i번 부터 시작하여 감소하는 부분수열의 길이를 구한다.
        desc[n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            desc[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if(nums[i] > nums[j]){
                    desc[i] = Math.max(desc[j] + 1, desc[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            ans = Math.max(ans, asc[i] + desc[i]);
        }
        System.out.println(ans - 1);//1을 빼는 이유 = 증가하는 배열과 감소하는 배열의 길이를 더하면 기준이 되는 i번째의 숫자가 중복되기 때문.

    }
}
