package 백준.트리의순회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 트리의순회 {

    private static int[] inOrder;
    private static int[] postOrder;
    private static int[] preOrder;
    private static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        
        makePreOrder(0,n - 1, 0 , n - 1);
        for(int node : preOrder){
            bw.write(node +" ");
        }

        bw.flush();
        bw.close();
    }

    /**
     *
     * @param is inOrder의 시작 index
     * @param ie inOrder의 종료 index
     * @param ps postOrder의 시작 index
     * @param pe postOrder의 종료 index
     */
    private static void makePreOrder(int is, int ie, int ps, int pe) {

        if(is > ie || ps > pe){
            return;
        }
        //postOrder의 마지막 값이 루트 노드임
        preOrder[index++] = postOrder[pe];

        //inOrder배열에서 루트노드의 인덱스를 찾음
        int rootIndex = 0;
        for (int i = is; i <= ie ; i++) {
            if(inOrder[i] == postOrder[pe]){
                rootIndex = i;
                break;
            }
        }
        //왼쪽자식노드 탐색
        makePreOrder(is, rootIndex - 1, ps , ps + rootIndex - is - 1);
        //오른쪽자식노드 탐색
        makePreOrder(rootIndex + 1, ie, ps + rootIndex - is, pe - 1);
    }
}
