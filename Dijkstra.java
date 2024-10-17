import java.util.*;

class Edge {
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class NodeComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[1], b[1]);
    }
}

public class Dijkstra{

    public static void dijkstra(List<List<Edge>> graph, int startNode) {
        int n = graph.size();
        int[] dist = new int[n]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new NodeComparator());
        pq.add(new int[]{startNode, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int distance = current[1];

            for (Edge edge : graph.get(u)) {
                int v = edge.node;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Distance from node " + startNode + " to node " + i + " is: " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int numNodes = 10; 
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Example edges (node1, node2, weight)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(7, 8));
        graph.get(1).add(new Edge(2, 8));
        graph.get(1).add(new Edge(7, 11));
        graph.get(2).add(new Edge(3, 7));
        graph.get(2).add(new Edge(5, 4));
        graph.get(3).add(new Edge(4, 9));
        graph.get(3).add(new Edge(5, 14));
        graph.get(4).add(new Edge(5, 10));
        graph.get(5).add(new Edge(6, 2));
        graph.get(6).add(new Edge(7, 1));
        graph.get(7).add(new Edge(8, 7));
        graph.get(8).add(new Edge(6, 6));
        graph.get(8).add(new Edge(2, 2));

        int startNode = 0;
        dijkstra(graph, startNode);
    }
}
