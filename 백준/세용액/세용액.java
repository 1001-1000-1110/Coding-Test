package 백준.세용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        //정렬
        Arrays.sort(nums);

        //이분탐색
        long result = Long.MAX_VALUE;
        int nowIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        breakPoint: //세 용액의 합이 0이 되는 경우 모든 반복문을 종료하기 위한 포인트지점
        for (int i = 0; i < n; i++) {
          long now = nums[i];
          int left = i + 1;
          int right = n - 1;
          while(left < right){
              long sum = nums[left] + nums[right];
              if(result > Math.abs(now + sum)){
                  result =  Math.abs(now + sum);
                  nowIndex = i;
                  leftIndex = left;
                  rightIndex = right;
              }
              if(now + sum == 0) //0인 경우, 반복문 종료
                  break breakPoint;
              if(now + sum > 0){ //0보다 큰 경우
                  right--;
              }else{ //0보다 작은 경우
                  left++;
              }
          }
        }

        System.out.println(nums[nowIndex]+" "+nums[leftIndex]+" "+nums[rightIndex]);

    }
}
