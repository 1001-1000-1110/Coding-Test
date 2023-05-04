package 프로그래머스.게임맵최단거리;

import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        //0벽 1길
        //시작 1,1 상대 n,m
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        boolean[][] visited = new boolean[n+1][m+1];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        //bfs
        Deque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(0,0,1));
        visited[0][0] = true;
        while(!dq.isEmpty()){
            Point currPoint = dq.poll();
            int currX = currPoint.x;
            int currY = currPoint.y;
            int currMove = currPoint.move;
            for(int i = 0; i < 4; i++){
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if(nextX >= 0 && nextX <= n && nextY >=0 && nextY <= m && maps[nextX][nextY] == 1){                                 if(!visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    if(nextX == n && nextY == m){
                        return currMove + 1;
                    }
                    dq.offer(new Point(nextX,nextY,currMove + 1));
                }
                }
            }
        }
        return -1;
    }
    class Point{
        int x;
        int y;
        int move;
        public Point(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}