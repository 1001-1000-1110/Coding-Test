package 백준.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아기상어 {
    public static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int[][] map;// 입력받은 물고기와 상어의 크기를 나타냄
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n; //입력받은 크기
    static int size; //상어 크기
    static boolean visit[][];
    static Queue<Node> q = new LinkedList<>();//bfs를 위한 queue

    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //초기 맵 만들기
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if (map[row][col] == 9) {
                    q.add(new Node(row, col, 0)); //아기상어의 좌표 x, 좌표 y, 0(상어와 물고기의 거리)
                    map[row][col] = 0;
                }
            }
        }
        int time = bfs();
        System.out.println(time);
    }

    private static int bfs() {
        int cnt = 0; //먹은 물고기 개수
        int time = 0;//
        int size = 2;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            //bfs를 한바퀴 돌때마다 상어가 먹을 수 있는 물고기의 정보(좌표x,좌표y, 상어와거리)를 조건에 맞게 정렬함.
            @Override
            public int compare(Node n1, Node n2){
                if(n1.distance < n2.distance){
                    return -1;
                }else if(n1.distance == n2.distance){
                    if(n1.x < n2.x){
                        return -1;
                    }
                    else if(n1.x == n2.x){
                        return n1.y < n2.y ? -1 : 1;
                    }
                }
                return 1;
            }
        });
        while(true){
            visit = new boolean[n][n];
            while (!q.isEmpty()) {
                Node currNode = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = currNode.x + dx[i];
                    int nextCol = currNode.y + dy[i];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && visit[nextRow][nextCol] != true && map[nextRow][nextCol] <= size) {
                        visit[nextRow][nextCol] = true;
                            q.add(new Node(nextRow,nextCol, currNode.distance + 1));
                            if(map[nextRow][nextCol] > 0 && map[nextRow][nextCol] < size){
                                //bfs를 통해 맵을 순회하며 상어가 먹을 수 있는 물고기의 정보를 우선순위큐에 담음
                                pq.add(new Node(nextRow,nextCol, currNode.distance + 1));
                            }
                    }
                }
            }
            //먹을 수 있는 물고기가 없으면 종료.
            if(pq.size() == 0) return time;

            Node temp = pq.poll();
            pq.clear(); //1번의 bfs를 통해서 조건에 맞는 1마리의 물고기만 먹으므로, 다음 bfs동작을 위해 비워야 함.
            time += temp.distance;
            q.add(new Node(temp.x,temp.y,0));//다음 bfs를 위한 시작 값(상어가 물고기를 먹은 좌표x, y, 물고기와 상어와의 거리)
//            System.out.println(temp.x +" , "+temp.y + " size : " +size + " dist : " + temp.distance + " map : "+map[temp.x][temp.y]);
            map[temp.x][temp.y] = 0;
            cnt++; //상어가 물고기를 먹은 횟수를 셈.
            if (cnt == size) { //상어의 크기만큼 물고기를 먹으면 크기 증가.
                size++;
                cnt = 0;
            }
        }
    }
    ;
}
