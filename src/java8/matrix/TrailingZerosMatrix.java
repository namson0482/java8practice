package java8.matrix;

public class TrailingZerosMatrix {
    // Stores the maximum count of zeros
    static int zeros = 0;

    public void maxZeros(int[][] mat,
                                int i, int j,
                                int product) {
        // If reached end of matrix
        if (i == mat.length - 1
                && j == mat[0].length - 1) {

            // Count the no of zeros product
            product *= mat[i][j];
            zeros = Math.max(zeros, countZeros(product));

            return;
        }

        // If out of bounds, return
        if (i >= mat.length)
            return;
        if (j >= mat[0].length)
            return;

        // Recurse with move (i+1, j)
        maxZeros(mat, i + 1, j,
                product * mat[i][j]);

        // Recurse with  move(i, j+1)
        maxZeros(mat, i, j + 1,
                product * mat[i][j]);
    }

    // Function that counts the trailing
    // zeros in the given number num
    public int  countZeros(int num) {
        // Stores the count of zeros
        int count = 0;
        System.out.println(num);
        // Iterate digits of num
        while (num > 0 && num % 10 == 0) {

            num /= 10;
            count++;
        }

        // Return the count
        return count;
    }

    // Function to print the maximum
    // count of trailing zeros obtained
    public int solution(int[][] mat, int m, int n) {

        // Function Call
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                maxZeros(mat, i, j, 1);
            }
        }
        // Print the maximum count
        System.out.println("Result: " + zeros);
        return zeros;
    }

    // Driver Code
    public static void main(String[] args) {

        //5
//        int mat[][] =
//                {{10, 100, 10},
//                {1, 10, 1},
//                {1, 10, 1}};

        //4
        int mat[][] =
                {{6, 25, 4, 10},
                {12, 25 , 1, 15},
                {7, 15, 15, 5}};

        //2
//        int mat[][] =
//                {{5, 8, 3, 1},
//                {4, 15 , 12, 1},
//                {6, 7, 10, 1},
//                {9, 1 , 2, 1},};
        //13
//        int mat[][] =
//                {{7500, 10, 11, 12},
//                {6250, 13 , 14, 15},
//                {134, 17, 16, 1},
//                {5500, 2093 , 5120, 238},};


        TrailingZerosMatrix m = new TrailingZerosMatrix();
        m.solution(mat, mat.length, mat[0].length);
    }

}
