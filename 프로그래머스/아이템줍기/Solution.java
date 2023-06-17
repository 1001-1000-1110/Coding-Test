package 프로그래머스.아이템줍기;
import java.util.*;

class Solution {
    static int[][]  map = new int[50 * 2 + 1][50 * 2 + 1];
    static boolean[][] visited = new boolean[50 * 2 + 1][50 * 2 + 1];
    static int min = Integer.MAX_VALUE;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        //2차원 맵에 이동할 수 있는 경로(테두리)를 표현함  1 = 이동가능, 0 = 이동불가)
        //표현되는 각 좌표에 * 2를 함 = 맵을 확대함, 인접한 테두리들을 자세하게 표현하기 위해
        characterX = characterX * 2;
        characterY = characterY * 2;

        itemX = itemX * 2;
        itemY = itemY * 2;

        //2차원 배열로, 사각형의 꼭지점을 표현함.
        int[][] vertex = new int[rectangle.length][8];

        for(int i = 0; i < rectangle.length; i++){
            //왼쪽 아래 꼭지점 좌표
            vertex[i][0] = rectangle[i][0] * 2;
            vertex[i][1] = rectangle[i][1] * 2;

            //왼쪽 위
            vertex[i][2] = rectangle[i][0] * 2;
            vertex[i][3] = rectangle[i][3] * 2;

            //오른쪽 위
            vertex[i][4] = rectangle[i][2] * 2;
            vertex[i][5] = rectangle[i][3] * 2;

            //오른쪽 아래
            vertex[i][6] = rectangle[i][2] * 2;
            vertex[i][7] = rectangle[i][1] * 2;

        }

        for(int[] rec : vertex){
            int ldX = rec[0];
            int ldY = rec[1];

            int luX = rec[2];
            int luY = rec[3];

            int ruX = rec[4];
            int ruY = rec[5];

            int rdX = rec[6];
            int rdY = rec[7];

            makeMap(ldX,ldY,luX,luY,'u');
            makeMap(luX,luY,ruX,ruY,'r');
            makeMap(ruX,ruY,rdX,rdY,'d');
            makeMap(rdX,rdY,ldX,ldY,'l');


        }

        //테두리가 아닌 값들 0으로 변경
        for(int[] rec : vertex){
            for(int i = rec[0] + 1; i < rec[4]; i++){
                for(int j = rec[1] + 1; j < rec[5]; j++){
                    map[i][j] = 0;

                }
            }
        }

        bfs(characterX,characterY, itemX, itemY);


        return min / 2;
    }
    private static void makeMap(int startx, int starty, int endx, int endy, char c){
        int dx = 0;
        int dy = 0;

        if(c == 'u')
            dy = 1;
        if(c == 'd')
            dy = -1;
        if(c == 'r')
            dx = 1;
        if(c == 'l')
            dx = -1;

        while(startx != endx || starty != endy){
            map[startx][starty] = 1;
            startx += dx;
            starty += dy;
        }

    }
    private static void bfs(int x, int y, int targetx, int targety){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        visited[x][y] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == targetx && now.y == targety){
                min = Math.min(min, now.cnt);
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nextx = now.x + dx[i];
                int nexty = now.y + dy[i];
                if(0 < nextx && nextx < 101 && 0 < nexty && nexty < 101 && visited[nextx][nexty] == false && map[nextx][nexty] == 1){
                    q.add(new Point(nextx,nexty,now.cnt + 1));
                    visited[nextx][nexty] = true;
                }
            }
        }
    }

}

class Point{
    int x;
    int y;
    int cnt;
    public Point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

}
