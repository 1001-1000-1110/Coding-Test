package 백준.회의실배정;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] timeTable = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        //회의 끝나는 시간 순으로 정렬
        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            //양수가 나올 경우, 두 파라미터의 위치를 변경한다.
            /*리턴 값
            * 음수 : o1 < o2
            * 0: o1 == o2
            * 양수: o1 > o2
            * */
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {//회의 종료
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int endTime = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (timeTable[i][0] >= endTime){
                endTime = timeTable[i][1];
                cnt++;
            }

        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
