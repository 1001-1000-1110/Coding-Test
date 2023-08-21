package 백준.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거짓말 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //truth
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        //진실을 아는 사람들의 부모를 0으로 표기
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            parent[num] = 0; //진실을 알고있는 사람만 0
        }
        //파티 진행
        int[][] inputs = new int[m][]; //입력을 받은 값을 저장한다음. union and find알고리즘으로 관계를 정리하고,
        for(int i = 0; i < m; i++){
            String[] temp = br.readLine().split(" ");
            int[] nums = new int[temp.length];
            inputs[i] = nums;
            for (int j = 0; j < nums.length; j++) {
                nums[j] = Integer.parseInt(temp[j]);
            }
            //1개인 경우 종료
            if(nums[0] == 1)
                continue;
            //2개 이상인 경우 union
            for (int j = 2; j < nums.length; j++) {
                if(find(nums[1]) != find(nums[j])){
                    union(nums[1],nums[j]);
                }
            }
        }

        //입력한 값 검사.
        int cnt = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 1; j <inputs[i].length ; j++) {
                if(find(inputs[i][j]) == 0){ //진실을 알고 있는 경우 종료,->한명이라고 진실을 알고 있으면 과장을 할 수 없음
                    break;
                }
                if(j == inputs[i].length - 1){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == 0){
            parent[rootB] = rootA;
        }else{ //rootB가 0인 경우와 그 나머지는 모두 동일하게 처리함.
            parent[rootA] = rootB;
        }
    }

    private static int find(int num) {
        if(parent[num] == num){
            return num;
        }

        return parent[num] = find(parent[num]);
    }
}
