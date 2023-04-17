package 백준.구슬탈출2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2 {
    static public class Point{
        int rx;
        int ry;
        int bx;
        int by;
        int depth;

        public Point(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }

    }
    static boolean[][][][] visited; // 방문한 위치를 기록함.
    static int n,m;
    static int holeX,holeY;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        //입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int Rx = 0;
        int Ry = 0;
        int Bx = 0;
        int By = 0;
        visited = new boolean[n][m][n][m];

        map = new char[n][m];
        for(int i = 0 ; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    Rx = i;
                    Ry = j;
                }else if(map[i][j] == 'B'){
                    Bx = i;
                    By = j;
                }

            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(Rx,Ry,Bx,By,0));
        visited[Rx][Ry][Bx][By] = true;


        while(!q.isEmpty()){
            Point nowPoint = q.poll();//현재 위치
            if(nowPoint.depth == 10) { //문제 : 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다
                break;
            }
//            System.out.println("===="+nowPoint.depth);

            boolean isRedFall = false; //구멍에 빠지면 true
            boolean isBlueFall = false; //구멍에 빠지면 true
            for(int i = 0; i < 4; i++){
                int nextRx = nowPoint.rx;
                int nextRy = nowPoint.ry;
                int nextBx = nowPoint.bx;
                int nextBy = nowPoint.by;
            //다음 좌표가 이동할 수 있는 좌표인지 확인하고 이동함.
                //파란구슬 이동
                //이동할 수 있는 경우 (맵 안에 위치해야하며, #이 아니어야함.)
                while(nextBx + dx[i]>=0 && nextBx +dx[i] < n && nextBy+dy[i] >=0 && nextBy + dy[i] < m && map[nextBx+dx[i]][nextBy+dy[i]] != '#'){
                    if(map[nextBx + dx[i]][nextBy+ dy[i]] == 'O'){ //구멍에 빠진 경우
                        isBlueFall = true;
                        break;
                    }else{
                        nextBx = nextBx + dx[i];
                        nextBy = nextBy + dy[i];
                    }
                }
                if(isBlueFall == true){
                    isBlueFall = false;
                    continue;
                }

                //빨간구슬 이동
                while(nextRx + dx[i]>=0 && nextRx +dx[i] < n && nextRy+dy[i] >=0 && nextRy + dy[i] < m && map[nextRx+dx[i]][nextRy+dy[i]] != '#'){
                    if(map[nextRx + dx[i]][nextRy+ dy[i]] == 'O'){ //구멍에 빠진 경우
                        isRedFall = true;
                        bw.write(nowPoint.depth + 1+"");
                        bw.flush();
                        bw.close();
                        return;
                    }else{
                        nextRx = nextRx + dx[i];
                        nextRy = nextRy + dy[i];
                    }
                }


                //빨간공과 파란공의 좌표가 겹칠 수도 있음.
                if(nextRx == nextBx && nextRy == nextBy){
                    //이동방향이 위쪽인 경우
                    if(i == 0){
                        if(nowPoint.rx < nowPoint.bx){//빨간공이 더 위에 있던 경우
                            nextBx = nextBx - dx[i];//파란공을 한칸 아래로 움직임
                        }else{//파란공이 더 위에 있던 경우
                            nextRx = nextRx - dx[i];//빨간공을 한칸 아래로 움직임
                        }
                    }
                    //이동방향이 아래쪽인 경우
                    if(i == 1){
                        if(nowPoint.rx > nowPoint.bx){//빨간공이 더 아래에 있던 경우
                            nextBx = nextBx - dx[i];//파란공을 한칸 위로 움직임
                        }else{//파란공이 더 아래에 있던 경우
                            nextRx = nextRx - dx[i];//빨간공을 한칸 위로 움직임
                        }
                    }

                    //이동방향이  왼쪽인 경우
                    if(i == 2){
                        if(nowPoint.ry < nowPoint.by){//빨간공이 더 왼쪽에 있던 경우
                            nextBy = nextBy - dy[i];//파란공을 한칸 오른쪽으로 움직임
                        }else{//파란공이 더 왼쪽에 있던 경우
                            nextRy = nextRy -dy[i];//빨간공을 한칸 오른쪽로 움직임
                        }
                    }

                    //이동방향이 오른쪽인 경우
                    if(i == 3){
                        if(nowPoint.ry > nowPoint.by){//빨간공이 더 오른쪽에 있던 경우
                            nextBy = nextBy - dy[i];//파란공을 한칸 왼쪽으로 움직임
                        }else{//파란공이 더 오른쪽에 있던 경우
                            nextRy = nextRy -dy[i];//빨간공을 한칸 왼쪽로 움직임
                        }
                    }

                }

                //이동해야할 좌표가 기존에 방문한 좌표가 아니라면 q에 추가함
//                if(!Rvisited[nextRx][nextRy] && !Bvisited[nextBx][nextBy]){
                if(!visited[nextRx][nextRy][nextBx][nextBy]){
                    q.add(new Point(nextRx,nextRy,nextBx,nextBy,nowPoint.depth+1));
                    visited[nextRx][nextRy][nextBx][nextBy] = true; //방문했음을 표시함.
                }
            }
        }

        bw.write(-1+"");
        bw.flush();
        bw.close();
    }
}
