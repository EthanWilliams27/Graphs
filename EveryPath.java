import java.util.*;

public class EveryPath {
    static class Edge {
        int to, weight;
        Edge(int t, int w) { to = t; weight = w; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int E = in.nextInt();
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = in.nextInt(), v = in.nextInt(), w = in.nextInt();
            adj.get(u).add(new Edge(v, w));
        }

        int start = in.nextInt(), goal = in.nextInt();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[V];
        dfs(adj, start, goal, 0, path, used);
    }

    static void dfs(List<List<Edge>> adj, int u, int goal, int sum,
                    List<Integer> path, boolean[] used) {
        if (sum > 7) return;
        if (u == goal && sum == 7) {
            path.add(u);
            System.out.println(path);
            path.remove(path.size() - 1);
            return;
        }
        used[u] = true;
        path.add(u);

        for (Edge e : adj.get(u)) {
            if (!used[e.to]) {
                dfs(adj, e.to, goal, sum + e.weight, path, used);
            }
        }

        path.remove(path.size() - 1);
        used[u] = false;
    }
}