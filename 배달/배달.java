import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N+1];
        List<Node>[] graph = new ArrayList[N+1];
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.distance - o2.distance;
            }
        });
        
        for (int i=0;i < N+1;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] temp: road) {
            int a = temp[0], b = temp[1], c = temp[2];
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        q.add(new Node(1, 0));
        while (!q.isEmpty()) {
            Node now = q.remove();
            
            if (distance[now.num] < now.distance) continue;
            if (now.distance <= K) answer++;

            for (Node node: graph[now.num]) {
                int d = node.distance + now.distance;
                if (distance[node.num] > d) {
                    distance[node.num] = d;
                    q.add(new Node(node.num, d));
                }
            }
        }
        return answer;
    }
    
    class Node {
        int num;
        int distance;
        
        Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }
}