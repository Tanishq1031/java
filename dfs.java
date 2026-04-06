import java.util.*;

public class DFSExample {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public DFSExample(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // DFS utility function
    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> it = adjList[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // DFS traversal
    void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(startVertex, visited);
    }

    // Main method
    public static void main(String[] args) {
        DFSExample graph = new DFSExample(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        System.out.println("DFS starting from vertex 0:");
        graph.DFS(0);
    }
}