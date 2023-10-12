package 코드트리;
import java.util.*;
import java.io.*;

public class 토끼와경주 {

    //Point클래스 구현
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }


    }

    //Rabbit 클래스 구현
    static class Rabbit implements Comparable<Rabbit> {
        int jump;
        Point point;
        int id;

        public Rabbit(int jump, Point point, int id) {
            super();
            this.jump = jump;
            this.point = point;
            this.id = id;
        }

        @Override
        public int compareTo(Rabbit o) {
            //점프가 다른경우
            if (this.jump != o.jump) {
                return Integer.compare(this.jump, o.jump);
            } else {
                //행+열이 다른 경우
                if (this.point.x + this.point.y != o.point.x + o.point.y) {
                    return Integer.compare(this.point.x + this.point.y, o.point.x + o.point.y);
                } else {
                    //행비교
                    if (this.point.x != o.point.x) {
                        return Integer.compare(this.point.x, o.point.x);
                    } else {
                        if (this.point.y != o.point.y) {
                            return Integer.compare(this.point.y, o.point.y);
                        } else {
                            return Integer.compare(this.id, o.id);
                        }
                    }
                }
            }
        }


    }

    //Position 클래스 구현
    static class Position implements Comparable<Position> {
        Point point;
        int id;

        public Position(Point point, int id) {
            super();
            this.point = point;
            this.id = id;
        }

        @Override
        public int compareTo(Position o) {
            //행+열이 다른 경우
            if (this.point.x + this.point.y != o.point.x + o.point.y) {
                return -1 * Integer.compare(this.point.x + this.point.y, o.point.x + o.point.y);
            } else {
                //행비교
                if (this.point.x != o.point.x) {
                    return -1 * Integer.compare(this.point.x, o.point.x);
                } else {
                    if (this.point.y != o.point.y) {
                        return -1 * Integer.compare(this.point.y, o.point.y);
                    } else {
                        return -1 * Integer.compare(this.id, o.id);
                    }
                }
            }
        }

    }

    //PriorityQueue<Rabbit>
    static PriorityQueue<Rabbit> rabbitPq = new PriorityQueue<>();
    //PriorityQueue<Position> 구현
    static PriorityQueue<Position> positionPq = new PriorityQueue<>();

    //토끼의 초기 정보들을 담음
    static int[] ids; //토끼의 아이디
    static HashMap<Integer, Integer> idToIdx = new HashMap<>();
    static Point[] points;//토끼의 위치
    static long[] scores;//토끼의 점수
    static int[] dists;//토끼의 이동거리
    static int[] jumps;//점프횟수
    static boolean[] isMove;//200에서 한번이라도 이동한 토끼를 찾음
    static int n, m, p;

    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();

    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int code = Integer.parseInt(st.nextToken());
            if (code == 100) {
                init(st);
            } else if (code == 200) {
                func200(st);
            } else if (code == 300) {
                func300(st);
            } else { //code == 400
                func400();
            }
        }
    }

    private static void func400() {
        long result = Long.MIN_VALUE;
        for (int i = 0; i < p; i++) {
            result = Math.max(result, scores[i]);
        }
        System.out.println(result);

    }

    private static void func300(StringTokenizer st) {
        int id = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int idx = idToIdx.get(id);
        dists[idx] *= l;


    }

    private static void func200(StringTokenizer st) {
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        Arrays.fill(isMove, false);

        for (int i = 0; i < k; i++) {
            Rabbit now = rabbitPq.poll();
            int dist = dists[idToIdx.get(now.id)];//움직여야할 거리

            positionPq.clear();

            positionPq.add(new Position(moveUp(now.point, dist), now.id));
            positionPq.add(new Position(moveDown(now.point, dist), now.id));
            positionPq.add(new Position(moveLeft(now.point, dist), now.id));
            positionPq.add(new Position(moveRight(now.point, dist), now.id));

            //하나만 뽑음
            Position position = positionPq.poll();
            int idx = idToIdx.get(position.id);

            //isMove에 이동했음을 체크함
            isMove[idx] = true;

            //jump횟수 증가
            jumps[idx]++;

            //위치 갱신
            points[idx] = position.point;
            //다른 토기들에게 점수 부여
            int score = position.point.x + position.point.y;
            for (int j = 0; j < p; j++) {
                if (j == idx) continue;
                scores[j] += score;
            }
//			System.out.println(i);
//			System.out.println(Arrays.toString(scores));
            rabbitPq.add(new Rabbit(jumps[idx], position.point, position.id));

        }

        //우선순위가 가장 높은 토끼에게 점수 지급
        positionPq.clear();
        for (int i = 0; i < p; i++) {
            if (!isMove[i]) continue;
            positionPq.add(new Position(points[i], ids[i]));
        }

        Position position = positionPq.poll();
        int idx = idToIdx.get(position.id);
        scores[idx] += s;
        //반복문
        //rabbitPq에서 하나 추출
        //TODO 상하좌우 이동 시킴
        //TODO 이동시킨 좌표를 받아서 PriorityQueue positionPq에 넣음
        //positionPq초기화
        //TODO 하나만 추출함
        //TODO 해당 토끼의 idx를 구한뒤, 나머지 토끼들에게 S부여
        //isMove체크
        //rabbitPq에 넣음

        //isMove를 통해 positionPq에 토끼들 최신값 넣음
        //하나만 추출해서 score에 점수 부여
        //positionPq초기화
        //rabbitPq에 넣음
    }

    private static Point moveRight(Point point, int dist) {
        int x = point.x;
        int y = point.y;
        dist %= 2 * (m - 1);

        //오른쪽 이동시 벽과 부딪히지 않음
        if (dist <= m - y) {
            y += dist;
            dist = 0;
        } else {
            dist -= (m - y);
            y = m;
        }

        //왼족으로 이동시 벽과 부딪히지 않음
        if (dist <= m - 1) {
            y -= dist;
            dist = 0;
        } else {
            y = 1;
            dist -= (m - 1);
        }

        y += dist;

        return new Point(x, y);
    }

    private static Point moveLeft(Point point, int dist) {
        int x = point.x;
        int y = point.y;
        dist %= 2 * (m - 1);

        //왼쪽으로 이동시, 벽과 부딪히지 않음.
        if (dist <= (y - 1)) {
            y -= dist;
            dist = 0;
        } else {
            dist -= (y - 1);
            y = 1;
        }

        //오른쪽으로 이동시,벽과 부딪히지 않음
        if (dist <= (m - 1)) {
            y += dist;
            dist = 0;
        } else {
            y = m;
            dist -= (m - 1);
        }

        y -= dist;
        return new Point(x, y);
    }

    private static Point moveDown(Point point, int dist) {
        int x = point.x;
        int y = point.y;
        dist %= 2 * (n - 1);

        //아래로 이동해도 벽과 부딪히지 않는 경우, 그냥 이동 시킴
        if (dist <= n - x) {
            x = x + dist;
            dist = 0;
        } else {//벽과 부딪히는 경우
            dist -= (n - x);
            x = n;
        }

        //위로 이동했을때 벽과 부딪히지 않는 경우, 그냥 이동시킴
        if (dist <= (n - 1)) {
            x -= dist;
            dist = 0;
        } else { //벽과 부딪힘
            dist -= (n - 1);
            x = 1;
        }

        x += dist;

        return new Point(x, y);
    }

    private static Point moveUp(Point point, int dist) {
        int x = point.x;
        int y = point.y;
        dist %= 2 * (n - 1);

        //위로 이동해도 벽과 부딪히지 않는 경우, 그냥 이동시킴
        if (dist <= x - 1) {
            x -= dist;
            dist = 0;
        } else {//벽에 부딪히는 경우
            dist -= (x - 1);
            x = 1;
        }

        //아래로 이동했을 때 벽과 부딪히지 않는 경우, 그냥 이동시킴
        if (dist <= n - 1) {
            x += dist;
            dist = 0;
        } else { //벽에 부딪히는 경우
            dist -= (n - 1);
            x = n;
        }

        x -= dist;
        return new Point(x, y);
    }

    private static void init(StringTokenizer st) {
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = Integer.parseInt(st.nextToken());

        points = new Point[p];
        scores = new long[p];
        dists = new int[p];
        jumps = new int[p];
        ids = new int[p];
        isMove = new boolean[p];
        //i번째 토끼의 위치, 점수,이동거리를 초기화함
        for (int i = 0; i < p; i++) {
            int id = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            points[i] = new Point(1, 1);
            dists[i] = dist;
            ids[i] = id;
            idToIdx.put(id, i);
        }

        //rabbitsPq의 초기값을 설정함.
        for (int i = 0; i < p; i++) {
            rabbitPq.add(new Rabbit(0, points[i], ids[i]));
        }

    }
}
