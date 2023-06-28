package 백준.팰린드롬분할;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 팰린드롬분할 {
    static boolean[][] isPalindrome;
    static int dp[];
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int n = str.length();
        isPalindrome = new boolean[n + 1][n + 1];
        dp = new int[n + 1];

        checkPalindrome();

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                if(isPalindrome[j][i] == true){
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[n]);
    }

    /*0<= j <= i 일때, j~i가 패린드롬인지 확인함.*/
    private static void checkPalindrome() {
        for(int i = 0; i < str.length(); i++){
            point:
            for(int j = 0; j <= i; j++){
                int left = j;
                int right = i;
                while(left <= right){
                    if(str.charAt(left++) != str.charAt(right--)){
                        continue point;
                    }
                }
                isPalindrome[j + 1][i + 1] = true;
            }
        }
    }
}

