package java8.matrix;

import java.util.ArrayList;
import java.util.List;

class Point {
    int x;
    int y;
    int value;
    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

class Path {
    ArrayList list;
    int start;
    int end;

    public Path() {

    }

    public Path(ArrayList list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    public void addPoint(Point point) {
        list.add(point);
    }

    public ArrayList getArrayList() {
        return this.list;
    }
}

// Java program to Print all possible paths from
// top left to bottom right of a mXn matrix
public class MatrixTraversal {


    private static void printMatrix(int mat[][], int m, int n,
                                    int i, int j, List<Integer> list, Path path) {

        //return if i or j crosses matrix size
        if (i > m || j > n || i < 0 || j < 0)
            return;

        list.add(mat[i][j]);
        Point p = new Point(i, j, mat[i][j]);
        path.addPoint(p);
        System.out.println(list);

        printMatrix(mat, m, n, i + 1, j, list, path);
        printMatrix(mat, m, n, i, j + 1, list, path);
//        printMatrix(mat, m, n, i, j - 1, list, path);

        list.remove(list.size() - 1);

    }

    // Driver code
    public static void main(String[] args) {

//        int mat[][] = {{1, 2, 3},
//                       {4, 5, 6}};
        int mat[][] =
       {{5, 8,  3,  1},
        {4, 15, 12, 1},
        {6, 7,  10, 1},
        {9, 1 , 2,  1},};

        int m = mat.length;
        int n = mat[0].length;
        int total = 0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> list = new ArrayList<>();
                Path path = new Path(new ArrayList(), i, j);
                printMatrix(mat, m - 1, n - 1, i, j, list, path);
                total += path.getArrayList().size();

            }
        }
        System.out.print(total);
    }
}
