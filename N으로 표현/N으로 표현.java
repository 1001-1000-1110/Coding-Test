import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        String[] temp;
        
        for (int i=0;i<9;i++)
            dp[i] = new HashSet();
        
        for (int i=1;i<9;i++) {
            temp = new String[i];
            Arrays.fill(temp, String.valueOf(N));
            dp[i].add(Integer.parseInt(String.join("",temp)));
            
            for (int j=1;j<i/2+1;j++) {
                for (int n1: dp[j]) {
                    for (int n2: dp[i-j]) {
                        dp[i].add(n1 + n2);
                        dp[i].add(n1 - n2);
                        dp[i].add(n2 - n1);
                        dp[i].add(n1 * n2);
                        if (n2 > 0) dp[i].add(n1 / n2);
                        if (n1 > 0) dp[i].add(n2 / n1);
                    }
                }
            }
            for (int n: dp[i])
                if (n == number)
                    return i;      
        }
        
        return -1;
    }
}