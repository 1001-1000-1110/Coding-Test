package 백준.절댓값힙;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

//백준 11286
public class 절댓값힙 {
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        /*
         우선순위큐의 정렬 기준을 직접 설정해줘야하기 때문에, 인자로 new Comparator<Integer>(){}사용하여
         compare 메소드를 오버라이드해서 정렬의 기준을 직접 구현해줘야함.

         - compare 메소드의 리턴값이 양수가 나올 경우, 두 파라미터의 위치를 변경한다.
       */
        @Override
        public int compare(Integer o1, Integer o2) {
            //절대값이 동일한 경우 음수 값을 더 우선 순위로 함
            if (Math.abs(o1) == Math.abs(o2)){
                return o1 > o2 ? 1 : -1;
            }else {
            //절대값을 비교하여 더 작은 값을 우선 순위로 함
                return Math.abs(o1) - Math.abs(o2);
            }

        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int command = Integer.parseInt(br.readLine());
            //0이 입력된 경우, 절대값이 가장 작은 값을 출력
            if(command == 0){
                int removedNumber = removeNumber();
                bw.write(removedNumber + "\n");
            }else{
            //0이 아닌경우 우선순위큐에 값을 넣어줌
                pq.add(command);
            }
        }

        bw.flush();
        bw.close();

    }

    private static int removeNumber() {
        if(pq.isEmpty()) return 0;
        return pq.remove();
    }
}

