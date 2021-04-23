package assignment8;

public class Dijkstra {

    public int[] findShortestPaths(int graph[][], int source) {
        int countOfVertices = graph.length;
        int[] dist = new int[countOfVertices];
        boolean[] visited = new boolean[countOfVertices];
        dist[0] = 0;
        for (int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        for (int i = 1; i < countOfVertices; i++) {
            int minValue = Integer.MAX_VALUE;
            int currVertex = -1;
            for (int v = 0; v < countOfVertices; v++) {
                if (visited[v] == false && dist[v] <= minValue) {
                    minValue = dist[v];
                    currVertex = v;
                }
            }
            visited[currVertex] = true;
            for (int nextVertex = 0; nextVertex < countOfVertices; nextVertex++) {
                if (!visited[nextVertex] && graph[currVertex][nextVertex] != 0 && dist[currVertex] != Integer.MAX_VALUE
                        && dist[currVertex] + graph[currVertex][nextVertex] < dist[nextVertex]) {
                    dist[nextVertex] = dist[currVertex] + graph[currVertex][nextVertex];
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        int[][] graph = { { 0, 3, 1, 0, 0 },
                          { 3, 0, 9, 0, 0 },
                          { 1, 9, 0, 7, 0 },
                          { 0, 0, 7, 0, 6 },
                          { 0, 0, 0, 6, 0 }};

        int[] res = dijkstra.findShortestPaths(graph, 0);
        for (int i = 0; i < res.length; i++) {
            System.out.println(i + ": " + res[i]);
        }

    }
}
