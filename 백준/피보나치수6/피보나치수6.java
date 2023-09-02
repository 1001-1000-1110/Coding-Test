package 백준.피보나치수6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수6 {
    static long[][] origin = {{1,1},{1,0}};
    static long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());


        long[][] a = {{1, 1}, {1, 0}};
        System.out.println(pow(a, n - 1)[0][0]);
    }

    //분할정복
    private static long[][] pow(long[][] matrix, long exp) {
        //exp가 0,1인 경우
        if(exp <=1){
            return matrix;
        }

        //값을 구한다.
        long [][] result = pow(matrix, exp / 2);

        //result * result
        result = multiply(result, result);

        if(exp % 2 == 1){
            result = multiply(result, origin);
        }

        return result;
    }

    private static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] result = new long[2][2];

        result[0][0] = ((m1[0][0] * m2[0][0]) + (m1[0][1] * m2[1][0])) % MOD;
        result[0][1] = ((m1[0][0] * m2[0][1]) + (m1[0][1] * m2[1][1])) % MOD;
        result[1][0] = ((m1[1][0] * m2[0][0]) + (m1[1][1] * m2[1][0])) % MOD;
        result[1][1] = ((m1[1][0] * m2[0][1]) + (m1[1][1] * m2[1][1])) % MOD;

        return result;
    }


}
