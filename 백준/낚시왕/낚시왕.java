package 백준.낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class 낚시왕 {
    static int r, c, m;
    static int[] sizes;
    static int[] directions;
    static int[] velocities;
    private static List<Shark> sharks;
    private static int ans = 0;

    static class Shark {
        Point point;
        int index;

        public Shark(Point point, int index) {
            this.point = point;
            this.index = index;
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sizes = new int[m];
        velocities = new int[m];
        directions = new int[m];
        sharks = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            //s 속도 d 방향 z 크기
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(new Point(R, C), i));
            velocities[i] = s;
            directions[i] = d;
            sizes[i] = z;
        }

        //낚시
//        sharkFishing(0);

        for (int i = 0; i < c; i++) {
            System.out.println(i);
            //낚시
            System.out.println("전");
            printMap();
            sharkFishing(i);
            //상어이동
            sharksMove();
            System.out.println("이동 후");
            printMap();
        }

        System.out.println(ans);
    }

    private static void printMap() {
        int[][] map = new int[r][c];

        //맵채우기
        for (Shark shark : sharks) {
            map[shark.point.r][shark.point.c] = sizes[shark.index];
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void sharksMove() {
        HashMap<Point, Integer> unDuplicatedSharks = new HashMap<>(); //좌표와 상어인덱스
        for (Shark shark : sharks) {
            Point movedPoint = move(shark);
            if (!unDuplicatedSharks.containsKey(movedPoint)) {
                unDuplicatedSharks.put(movedPoint, shark.index);
            } else {
                int existingIndex = unDuplicatedSharks.get(movedPoint);
                if (sizes[shark.index] > sizes[existingIndex]) {
                    unDuplicatedSharks.put(movedPoint, shark.index);
                }
            }
        }
        List<Shark> afterMoveSharks = new ArrayList<>();
        //새로운 좌표를 만듬
        for (Map.Entry<Point, Integer> shark : unDuplicatedSharks.entrySet()) {
            afterMoveSharks.add(new Shark(shark.getKey(), shark.getValue()));
        }
        //기존의 상어의 좌표를 이동후로 교체함
        sharks = afterMoveSharks;
    }

    private static Point move(Shark shark) {
        int index = shark.index;
        int direction = directions[index];
        Point movedPoint = null;
        if (direction == 1) {//위
            movedPoint = moveUp(shark);
        } else if (direction == 2) {//아래
            movedPoint = moveDown(shark);
        } else if (direction == 3) {//오른쪽
            movedPoint = moveRight(shark);
        } else {//왼쪽
            movedPoint = moveLeft(shark);
        }
        return movedPoint;
    }

    //c가 바뀜
    private static Point moveLeft(Shark shark) {
        int R = shark.point.r;
        int C = shark.point.c;

        int moveDist = velocities[shark.index] % (2 * (c - 1));

        //왼쪽 이동
        if (moveDist <= C) {
            C -= moveDist;
            moveDist = 0;
        } else {//벽과 부딪힘
            moveDist -= C;
            C = 0;
        }

        //오른쪽 이동
        if (moveDist <= c - 1) {
            C += moveDist;
            moveDist = 0;
        } else {//벽과 부딪힘
            moveDist -= c - 1;
            C = c - 1;
            C -= moveDist;
        }

        return new Point(R, C);
    }

    //c가 변함
    private static Point moveRight(Shark shark) {
        int R = shark.point.r;
        int C = shark.point.c;

        int moveDist = velocities[shark.index] % (2 * (c - 1));
        //오른쪽
        if (moveDist <= c - 1 - C) {
            C += moveDist;
            moveDist = 0;
        } else {
            moveDist -= c - 1 - C;
            C = c - 1;
        }

        //왼쪽
        if (moveDist <= C) {
            C -= moveDist;
            moveDist = 0;
        } else {
            moveDist -= C;
            C = 0;
            C += moveDist;
        }
        return new Point(R, C);
    }

    //r이 변함
    private static Point moveDown(Shark shark) {
        int R = shark.point.r;
        int C = shark.point.c;

        int moveDist = velocities[shark.index] % (2 * (r - 1));

        //아래
        if (moveDist <= r - 1 - R) {
            R += moveDist;
            moveDist = 0;
        } else {
            moveDist -= r - 1 - R;
            R = r - 1;
        }
        //위
        if (moveDist <= R) {
            R -= moveDist;
            moveDist = 0;
        } else {
            moveDist -= R;
            R = 0;
            R += moveDist;
        }

        return new Point(R, C);
    }

    //r을 변경
    private static Point moveUp(Shark shark) {
        int R = shark.point.r;
        int C = shark.point.c;

        int moveDist = velocities[shark.index] % (2 * (r - 1));
        //위
        if (moveDist <= R) {
            R -= moveDist;
            moveDist = 0;
        } else {
            moveDist -= R;
            R = 0;
        }

        //아래
        if (moveDist <= r - 1) {
            R += moveDist;
            moveDist = 0;
        } else {
            moveDist -= r - 1;
            R = r - 1;
            R -= moveDist;
        }
        return new Point(R, C);
    }

    private static void sharkFishing(int manPosition) {
        int index = -1;
        sharks.sort((s1, s2) -> Integer.compare(s1.point.r, s2.point.r));
        int size = 0;
        for (int i = 0; i < sharks.size(); i++) {
            Shark shark = sharks.get(i);
            if (shark.point.c == manPosition) {
                index = i;
                size = sizes[shark.index];
                break;
            }
        }
        if (index == -1) {
            return;
        }
        ans += size;
        sharks.remove(index);
    }
}
