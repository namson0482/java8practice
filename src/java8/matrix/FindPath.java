package java8.matrix;

import java.util.Stack;

public class FindPath {
    public static void findPaths(int[][] mat, Stack<Integer> path, int i, int j) {
        // base case
        if (mat == null || mat.length == 0) {
            return;
        }

        int M = mat.length;
        int N = mat[0].length;

        // if the last cell is reached, print the route
        if (i == M - 1 && j == N - 1) {
            path.add(mat[i][j]);
            System.out.println(path);
            path.pop();
            return;
        }

        // include the current cell in the path
        path.add(mat[i][j]);

        // move right
        if ((i >= 0 && i < M && j + 1 >= 0 && j + 1 < N)) {
            findPaths(mat, path, i, j + 1);
        }

        // move down
        if ((i + 1 >= 0 && i + 1 < M && j >= 0 && j < N)) {
            findPaths(mat, path, i + 1, j);
        }

        // backtrack: remove the current cell from the path
        path.pop();
    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        Stack<Integer> path = new Stack<>();
        // start from `(0, 0)` cell
        int x = 0, y = 0;

        findPaths(mat, path, x, y);
    }
}
