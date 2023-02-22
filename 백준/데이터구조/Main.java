package 백준.데이터구조;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static int firstLeaf;
    static int Max = 2000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        //첫번째 리프노드
        firstLeaf = 1;
        while(firstLeaf < Max) firstLeaf *= 2;


        //트리 크기 지정하기
        tree = new int[firstLeaf * 2];

        //리프 노드의 초기값이 존재하는 경우, 초기화해줘야하지만 생략

        //update -> update_tree
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //a = 1인경우, 추가
            if(a == 1){
                update(1,0,firstLeaf - 1,b - 1,1);
            }else{
                int num = query(1,0,firstLeaf - 1,b);
                update(1,0,firstLeaf - 1, num, -1);
                bw.write(num+1+"\n");
            }
            //a = 2인경우 출력후, 삭제
        }
        bw.flush();
        bw.close();

    }

    private static int query(int node, int start, int end, int k) {
        if(start == end) return start;
        int mid = start + (end - start)/2;
        //왼쪽 자식 노드의 값이 k보다 작은 경우
        if(tree[node * 2] < k){
            return query(node * 2 + 1, mid + 1, end,k - tree[node*2]);
        }//왼쪽 자식 노드의 값이 k보다 크거나 같은경우
        else{
            return query(node * 2,start,mid,k);
        }
    }

    private static void update(int node, int start, int end, int index, int value){
        if(index < start || index > end){
            return;
        }
        if(start == end){
            tree[node] += value;
            return;
        }
        int mid = start + (end - start)/2;
        update(node * 2, start, mid, index, value);
        update(node * 2 + 1, mid + 1, end, index, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    //리프노드에서 기존의 값과 바꾸려는 값의 차이를 구한 후, updateTree메소드를 통해 트리를 갱신함
//    private static void update(int node, int start, int end, int index, int value) {
//        tree[firstLeaf + index] += value;
//        updateTree(1,0,firstLeaf - 1, index, value);
//    }
//
//    //리프노드를 제외한 부분을 순회하며 관계된 노드에 대해서 diff만큼의 변화를 반영함.
//    private static void updateTree(int node, int start, int end, int index, int diff) {
//        if(index < start || index > end) return;
//        tree[node] += diff;
//        if(start != end){
//            int mid = start + (end - start)/2;
//            updateTree(node * 2, start, mid,index,diff);
//            updateTree(node * 2 + 1, mid + 1, end,index,diff);
//        }
//    }
}
