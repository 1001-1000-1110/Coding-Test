package 백준.열쇠;

import java.io.*;
import java.util.*;

public class 열쇠 {
    static boolean[] Keys; //키를 가지고 있는지 확인하기 위한 배열
    static int h, w; //map의 크기
    static List<Point>[] DoorPoints = new ArrayList[26];//문의 위치를 기록함 -> key가 없으면 진입을 못하므로, key를 획득하게 된 경우 bfs를 위한 큐에 좌표를 넣어주기 위함
    static char[][] Map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int cnt; //획득한 문서의 개수
    private static class Point { //좌표를 기록하기 위한 클래스
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) { //테스크 케이스 만큼 반복
            bw.write(solve(br) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int solve(BufferedReader br) throws IOException {
        //초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        visited = new boolean[h][w];
        cnt = 0;
        Map = new char[h][w];
        //입력 받은 값으로 map을 만듬.
        for (int i = 0; i < h; i++) {
            Map[i] = br.readLine().toCharArray();
        }
        Keys = new boolean[26];
        DoorPoints = new ArrayList[26];
        for (int i = 0; i < DoorPoints.length; i++) {
            DoorPoints[i] = new ArrayList<>();
        }
        //입력으로 주어진 키를 입력 받음.
        String keyStr = br.readLine();

        if (!keyStr.equals("0")) {//키를 가지고 있는 경우
            for (int i = 0; i < keyStr.length(); i++) {
                Keys[keyStr.charAt(i) - 'a'] = true;
            }
        }

        //시작 지점을 찾아서 bfs를 진행함.
        //시작지점 = 벽이 아닌 곳
        findStartingPoint();
        return cnt;
    }

    private static void findStartingPoint() {
        for (int i = 0; i < h; i++) { //빌딩의 가장 위, 아래 가로방향
            for (int j = 0; j < w; j++) {
                if (i > 0 && i < h - 1 && j > 0 && j < w - 1) {
                    continue;
                }
                if(visited[i][j]){
                    continue;
                }

                if (Map[i][j] != '*') {
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
//        System.out.println("startPoint x: "+x+" y: "+y);

        visited[x][y] = true;
        //시작 위치가 문인 경우
        if(Map[x][y] >= 'A' &&  Map[x][y] <= 'Z'){
            if(!Keys[Map[x][y] - 'A']){ //키를 가지고 있지 않은 경우, 더이상 진입이 불가능
                DoorPoints[Map[x][y] - 'A'].add(new Point(x, y));//문의 위치를 기록함
                return;//bfs메서드를 종료함
            }
        }

        //시작 위치가 키인 경우
        if (Map[x][y] >= 'a' && Map[x][y] <= 'z') {
            Keys[Map[x][y] - 'a'] = true; //키를 가지게 되었으므로 true처리
        }

        //시작 위치가 문서인 경우
        if (Map[x][y] == '$') {
            cnt++;
        }

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                //주어진 맵을 벗어나지 않은 경우, 한번도 방문하지 않은 경우, 벽이 아닌 경우
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && Map[nx][ny] != '*') {
                    visited[nx][ny] = true;
                    //문인 경우
                    if (Map[nx][ny] >= 'A' && Map[nx][ny] <= 'Z') {
                        if (!Keys[Map[nx][ny] - 'A']) { //키가 없는 경우
                            DoorPoints[Map[nx][ny] - 'A'].add(new Point(nx, ny)); //현재 열수 없는 문의 좌표를 저장함.
                            continue;
                        }
                    }
                    //키인 경우
                    else if (Map[nx][ny] >= 'a' && Map[nx][ny] <= 'z') {
                        if (!Keys[Map[nx][ny] - 'a']) { //키를 가지고 있지 않은 경우
                            Keys[Map[nx][ny] - 'a'] = true;
                            //큐에 획득한 키로 방문할 수 있는 곳을 추가함.
                            for(Point point : DoorPoints[Map[nx][ny] - 'a']){
                                q.add(point);
                            }
                        }
                    }
                    //문서인 경우
                    else if (Map[nx][ny] == '$') {
                      cnt++;
                    }

                    q.add(new Point(nx, ny));
                }
            }
        }
    }


}
