package 백준.좋다;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1253번
public class 좋다 {
    static int[] nums;
    static int n;
    static int cnt;//좋은 수 만큼 증가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        //숫자 배열 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        //숫자 배열을 오름차순으로 정렬함
        Arrays.sort(nums);
        //모든 수를 한번씩 선택
        for (int i = 0; i < n; i++) {
            isGoodNumber(i);
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    //인자로 받은 인덱스보다 작은 인덱스의 수들로 구성되는지 파악함.
    private static void isGoodNumber(int index) {
        int currentNum = nums[index];
        int left = 0;
//        int right = index - 1; 동일한 값이 여러개인 경우를 고려하지 않음.
        int right = n - 1;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            //현재 값과 동일한 경우,
            if (leftNum + rightNum == currentNum) {
                if (left != index && right != index) {
                    cnt++;
                    break;
                }else if(left == index){
                    left++;
                }else if(right == index){
                    right--;
                }
            }
            //현재 숫자보다 작으면 left++
            else if (leftNum + rightNum < currentNum) {
                left++;
            }
            //현재 숫자보다 크면 right--;
            else if (leftNum + rightNum > currentNum) {
                right--;
            }
        }
    }
}
