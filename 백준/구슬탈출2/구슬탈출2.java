package 백준.구슬탈출2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 구슬탈출2 {
    static class Point implements Comparable<Point>{
        int Rx;
        int Ry;
        int Bx;
        int By;
        int cnt;
        public Point(int Rx, int Ry, int Bx, int By, int cnt) {
            this.Rx = Rx;
            this.Ry = Ry;
            this.Bx = Bx;
            this.By = By;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Point o){
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static PriorityQueue<Point> q = new PriorityQueue<>();
    //이거 우선순위 큐로 구현할것 implements comparator사용해서

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        int Rx = 0;
        int Ry = 0;
        int Bx = 0;
        int By = 0;

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
//                System.out.println(temp);
                map[i][j] = temp.charAt(j);
//                System.out.println(map[row][col]);
                if (map[i][j] == 'R') {
                    Rx = i;
                    Ry = j;
                    map[i][j] ='.';
                }
                if (map[i][j] == 'B') {
                    Bx = i;
                    By = j;
                    map[i][j] ='.';
                }
            }
        }
        q.add(new Point(Rx, Ry, Bx, By,0));

        int result = bfs();
        System.out.println(result);

    }

    private static int bfs() {
        while (!q.isEmpty()) {
            Point currentP = q.poll();
            if(currentP.cnt > 10) return -1;
            //상
            if (currentP.Rx < currentP.Bx) { //R이더 B위에 있는 경우
                int Rx = move(currentP.Rx, currentP.Ry, 'R', -1, 0);
                int Bx = move(currentP.Bx, currentP.By, 'B', -1, 0);
                if (Bx != -1 && Rx == -1)// R만 통과, B는 불통
                    return ++currentP.cnt;
                if (Bx != -1 && (Rx != currentP.Rx || Bx != currentP.Bx)) { //B만 통과한 경우는 실패 이므로 건너 뜀.
                    q.add(new Point(Rx, currentP.Ry, Bx, currentP.By, currentP.cnt + 1));//다음 단계
//                    System.out.println(Rx + " " + currentP.Ry + " " + Bx + " " + currentP.By);
                }
            } else { //B가 R보다 위에 있는 경우, 같은 높이에 있는 경우
                int Rx = move(currentP.Rx, currentP.Ry, 'R', -1, 0);
                int Bx = move(currentP.Bx, currentP.By, 'B', -1, 0);
                if (Bx != -1 && Rx == -1)
                    return ++currentP.cnt;

                if (Bx != -1 && (Rx != currentP.Rx || Bx != currentP.Bx)) {
                    q.add(new Point(Rx, currentP.Ry, Bx, currentP.By, currentP.cnt + 1));
                }
            }

            //하
            if (currentP.Rx > currentP.Bx) { //R이더 B보다 아래에 있는 경우
                int Rx = move(currentP.Rx, currentP.Ry, 'R', 1, 0);
                int Bx = move(currentP.Bx, currentP.By, 'B', 1, 0);
                if (Bx != -1 && Rx == -1)
                    return ++currentP.cnt;

                if (Bx != -1 && (Rx != currentP.Rx || Bx != currentP.Bx)) {
                    q.add(new Point(Rx, currentP.Ry, Bx, currentP.By, currentP.cnt + 1));
                }
            } else { //R이 B보다 위에 있는 경우, 같은 높이에 있는 경우
                int Bx = move(currentP.Bx, currentP.By, 'B', 1, 0);
                int Rx = move(currentP.Rx, currentP.Ry, 'R', 1, 0);
                if (Bx != -1 && Rx == -1)
                    return ++currentP.cnt;

                if (Bx != -1 && (Rx != currentP.Rx || Bx != currentP.Bx)){
                    q.add(new Point(Rx, currentP.Ry, Bx, currentP.By, currentP.cnt + 1));
                }
            }

            //좌
            if (currentP.Ry < currentP.By) { //R이 B보다 왼쪽에 있는 경우 있는 경우
                int Ry = move(currentP.Rx, currentP.Ry, 'R', 0, -1);
                int By = move(currentP.Bx, currentP.By, 'B', 0, -1);
                if (By != -1 && Ry == -1)// R만 통과, B는 불통
                    return ++currentP.cnt;

                if (By != -1 && (Ry != currentP.Ry || By != currentP.By)){ //B만 통과한 경우는 실패 이므로 건너 뜀.
                    q.add(new Point(currentP.Rx, Ry, currentP.Bx, By, currentP.cnt + 1));//다음 단계
                }
            } else { //B가 R보다 위에 있는 경우, 같은 높이에 있는 경우
                int By = move(currentP.Bx, currentP.By, 'B', 0, -1);
                int Ry = move(currentP.Rx, currentP.Ry, 'R', 0, -1);
                if (By != -1 && Ry == -1)// R만 통과, B는 불통
                    return ++currentP.cnt;
                if (By != -1 && (Ry != currentP.Ry || By != currentP.By)) {
                    q.add(new Point(currentP.Rx, Ry, currentP.Bx, By, currentP.cnt + 1));//다음 단계
                } //B만 통과한 경우는 실패 이므로 건너 뜀.
            }

            //우
            if (currentP.Ry > currentP.By) { //R이 B보다 오른쪽에 있는 경우 있는 경우
                int Ry = move(currentP.Rx, currentP.Ry, 'R', 0, 1);
                int By = move(currentP.Bx, currentP.By, 'B', 0, 1);
                if (By != -1 && Ry == -1)// R만 통과, B는 불통
                    return ++currentP.cnt;

                if (By != -1 && (Ry != currentP.Ry || By != currentP.By)) { //B만 통과한 경우는 실패 이므로 건너 뜀.
                    q.add(new Point(currentP.Rx, Ry, currentP.Bx, By, currentP.cnt + 1));//다음 단계
                }
            } else { //B가 R보다 오른쪽 있는 경우, 같은 좌우?에 있는 경우
                int By = move(currentP.Bx, currentP.By, 'B', 0, 1);
                int Ry = move(currentP.Rx, currentP.Ry, 'R', 0, 1);
                if (By != -1 && Ry == -1)// R만 통과, B는 불통
                    return ++currentP.cnt;

                if (By != -1 && (Ry != currentP.Ry || By != currentP.By)) { //B만 통과한 경우는 실패 이므로 건너 뜀.
                    q.add(new Point(currentP.Rx, Ry, currentP.Bx, By, currentP.cnt + 1));//다음 단계
                }
            }
        }
        return -1;
    }

    //입력받은 구슬의 좌표가 이동한 좌표를 반환함.
    /*x좌표 ,y좌표 ,구슬 종류(R or B), x의 변화랑, y의 변화랑*/
    private static int move(int x, int y, char c, int dx, int dy) {

        while (map[x][y] != '#') {
            int nextX = x + dx;
            int nextY = y + dy;

            if (map[nextX][nextY] == 'O') {
                return -1; //구멍에 빠진경우 -1 반환
            } else if (map[nextX][nextY] == 'R' || map[nextX][nextY] == 'B') { //다른 구슬이 있는 경우 #인경우, 다른 구슬인 경우
                map[x][y] = c;
                return dx == 0 ? y : x;
            }
            map[x][y] ='.';
            x = nextX;
            y = nextY;
        }

        if(dx == 0){
            map[x][y + -1*dy] = c;
        }else{
            map[ x + -1 * dx][y] = c;
        }
        return dx == 0 ? y + -1 * dy : x + -1 * dx;
    }


}
