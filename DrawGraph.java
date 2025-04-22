import java.util.*;

public class DrawGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read number of vertices
        int n = in.nextInt();
        char[] names = new char[n];
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = in.next().charAt(0);
            x[i] = in.nextInt();
        }

        // Build adjacency list
        Map<Character, List<Character>> adj = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(names[i], new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int left  = (i - x[i] % n + n) % n;
            int right = (i + x[i] % n) % n;
            adj.get(names[i]).add(names[left]);
            adj.get(names[i]).add(names[right]);
        }

        // Print it out
        for (char v : adj.keySet()) {
            System.out.print(v + " -> ");
            for (char w : adj.get(v)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
