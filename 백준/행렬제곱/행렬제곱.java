package 백준.행렬제곱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 행렬제곱 {

    private static int[][] origin; //입력으로 받은 배열
    private static final int MOD = 1000;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        origin = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st2.nextToken()) % MOD;
            }
        }

        int[][] result = calculate(b);
        //출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] +" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static int[][] calculate(long ex) {
        if(ex == 1L){
            return origin;
        }
        //절반 계산, A^10 = A^5 * A^5
        int[][] half = calculate(ex / 2);
        int[][] result = multiply(half, half);

        //ex가 홀수인 경우, A^11 = A^5 * A^5 * A
        if(ex % 2 == 1){
            result = multiply(result, origin);
        }
        return result;
    }

    private static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] result = new int[N][N];
        for(int i = 0;  i <  N; i++){
            for(int j = 0; j < N; j++){
                for (int k = 0; k < N; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
