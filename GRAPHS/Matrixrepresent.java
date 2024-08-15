// package GRAPHS;

public class Matrixrepresent {
    static void matrixRep(int n, int[][] a) {
        int[][] mat = new int[n + 1][n + 1];
        for (int i = 0; i < a.length; i++) {
            int x = a[i][0];
            int y = a[i][1];

            mat[x][y] = 1;
            mat[y][x] = 1;
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(mat[i][j]);

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] a = {
                { 1, 2 },
                { 1, 3 },
                { 2, 4 },
                { 3, 4 },
                { 3, 5 },
                { 4, 5 },

        };
        matrixRep(n, a);
    }

}
