package 백준.곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long ans = pow(a,b,c);

        System.out.println(ans);
    }

    private static long pow(long a, long b, long c) {
        if(b == 1){
            return a % c;
        }
        long temp = pow(a, b/2,c);
        long odd = 1;
        if(b % 2 == 1){
            odd = a % c;
        }
        return ((temp * temp) % c * odd % c) % c;
    }
}
