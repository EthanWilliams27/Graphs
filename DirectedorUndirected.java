import java.util.Scanner;

public class DirectedorUndirected {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = in.nextInt();

        boolean symmetric = true;
        for (int i = 0; i < n && symmetric; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] != m[j][i]) {
                    symmetric = false;
                    break;
                }
            }
        }

        System.out.println(symmetric ? "Undirected" : "Directed");
    }
}