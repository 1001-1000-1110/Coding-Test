package 백준.다각형의면적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다각형의면적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] xs = new long[n + 1];
        long[] ys = new long[n + 1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 신발끈 공식을 사용하여 다각형 넓이를 구함.
         */
        long sumXY = 0;
        long sumYX = 0;
        for(int i = 1; i < n; i++){
            sumXY += xs[i] * ys[i + 1];
            sumYX += xs[i + 1] * ys[i];
        }
        sumXY += xs[n] * ys[1];
        sumYX += xs[1] * ys[n];
        double result = Math.abs((sumXY - sumYX)) * 0.5;
        System.out.println(String.format("%.1f",result));
    }
}
