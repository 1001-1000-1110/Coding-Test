package 프로그래머스.퍼즐조각채우기;

import java.util.*;

class Solution {
    static int N;
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        int[][] game_board_copy = new int[N][N]; //game_board 깊은 복사본
        int[][] table_copy = new int[N][N]; // table 깊은 복사본

        for(int i = 0; i < N; i++){
            game_board_copy[i] = game_board[i].clone();
            table_copy[i] = table[i].clone();
        }

        /*game_board와 table에서 각 모양을 추출함*/
        List<List<Point>> board = new ArrayList<>();
        List<List<Point>> puzzle = new ArrayList<>();

        //bfs를 통해  game_board_copy의 빈공간, table_copy의 도형을 추출함
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(game_board_copy[i][j] == 0){//game_board에서 0은 구멍임
                    board.add(bfs(i,j,0,game_board_copy));
                }

                if(table_copy[i][j] == 1){//table에서 1은 도형임
                    puzzle.add(bfs(i,j,1,table_copy));
                }
            }
        }
        //board , puzzle의 좌표를 비교가 가능하도록 구멍/도형을 감싸는 사각형 형태로 좌표를 만들어줌
        List<int[][]> boardHole = makeRectangle(board, game_board);
        List<int[][]> puzzleBlock = makeRectangle(puzzle, table);

        /*game_board에서 추출한 사각형을 회전시켜가며 table에서 추출한 사각형과 비교함*/
        boolean[] visited = new boolean[puzzleBlock.size()];

        for(int i = 0; i < boardHole.size(); i++){
            int[][] now = boardHole.get(i);

            for(int j = 0; j < puzzleBlock.size(); j++){
                if(visited[j] == true)
                    continue;

                int[][] block = puzzleBlock.get(j);
                isCorrect(now,block,j, visited);
                if(visited[j] == true)
                    break;
                //90도 회전
                now = rotate(now);
                isCorrect(now,block,j, visited);
                if(visited[j] == true)
                    break;
                //180도 회전
                now = rotate(now);
                isCorrect(now,block,j, visited);
                if(visited[j] == true)
                    break;

                //270도 회전
                now = rotate(now);
                isCorrect(now,block,j, visited);
                if(visited[j] == true)
                    break;

            }
        }

        int answer = 0;

        for(int i = 0; i < puzzle.size(); i++){
            if(visited[i] == true){
                answer += puzzle.get(i).size();
            }
        }

        return answer;
    }

    //bfs
    // (시작지점x, 시작지점y, 찾는 값(1 or 0), bfs를 진행할 맵)
    private List<Point> bfs(int x, int y, int target, int[][] map){
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        map[x][y] = (target == 0) ? 1 : 0; //방문했음을 표시함

        List<Point> result = new ArrayList<>();

        while(!q.isEmpty()){
            Point now = q.poll();
            result.add(new Point(now.x, now.y));
            for(int i = 0; i < 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[nextX][nextY] == target){
                    q.add(new Point(nextX, nextY));
                    map[nextX][nextY] = (target == 0) ? 1 : 0;//방문했음을 표시함.
                }

            }
        }
        return result;
    }

    //입력된 좌표들을 모두 포함하는, map상의 직사각형을 모두 좌표로 만들어 반환함
    //((구멍이나 or 도형) 좌표 모음), 참고할 map(game_board or table))
    private List<int[][]> makeRectangle(List<List<Point>> list, int[][] map){

        List<int[][]> result = new ArrayList<>();
        //포함되어 있는 좌표들을 모두 포함하는 직사각형을 만듬
        for(int i = 0; i < list.size(); i++){
            List<Point> points = list.get(i);

            int minx = Integer.MAX_VALUE;
            int maxx = Integer.MIN_VALUE;
            int miny = Integer.MAX_VALUE;
            int maxy = Integer.MIN_VALUE;
            for(Point point : points){
                minx = Math.min(minx, point.x);
                maxx = Math.max(maxx, point.x);
                miny = Math.min(miny, point.y);
                maxy = Math.max(maxy, point.y);
            }
            //모든 사각형의 시작지점을 (0,0)으로 만듬
            int[][] rectangle = new int[maxx - minx + 1][maxy - miny + 1];

            for(int j = minx; j <= maxx; j++){
                for(int k = miny; k<= maxy; k++){
                    rectangle[j - minx][k - miny] = map[j][k];
                }
            }

            result.add(rectangle);
        }

        return result;
    }

    //비교 대상이되는 두개의 사각형좌표모음이 일치한지 판단함.
    private void isCorrect(int[][] now, int[][]block, int index, boolean[] visited){

        if(now.length != block.length || now[0].length != block[0].length){
            return;
        }

        for(int k = 0; k < block.length; k++){
            for(int l = 0; l < block[0].length; l++){
                if(now[k][l] == block[k][l]){ //같은 경우 종료, 하나는 구멍(0) 하나는 도형(1)이므로 두개가 달라야함.
                    return;
                }
            }
        }
        visited[index] = true;
    }

    //90도 회전
    private int[][] rotate(int[][] map){
        int[][] temp = new int[map.length][map[0].length];

        for(int i = 0; i < map.length; i++){
            temp[i] = map[i].clone();
        }

        int[][] rotated = new int[temp[0].length][temp.length];

        for(int i = 0;  i < temp.length; i++){
            for(int j = 0; j < temp[0].length; j++){
                rotated[j][rotated[0].length - 1 - i] = temp[i][j];
            }
        }
        return rotated;
    }
}