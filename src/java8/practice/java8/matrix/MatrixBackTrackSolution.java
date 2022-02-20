package java8.matrix;

import java.util.*;

class MatrixBackTrackSolution {

    private static int[] BOTTOM_TO_UP = {-1,0};
    private static int[] TOP_TO_DOWN = {1,0};
    private static int[] LEFT_TO_RIGHT = {0,1};
    private static int[] RIGHT_TO_LEFT = {0,-1};

    private static int[][] DIRECTIONS = new int[][] {BOTTOM_TO_UP, TOP_TO_DOWN, LEFT_TO_RIGHT, RIGHT_TO_LEFT};

    private static int maxTrailingZeroes = -1;

    public static int getMaxZeroTrailingPath(int[][] matrix) {
        int colNum = matrix[0].length;
        Set<Integer> seen = new HashSet<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                for (int[] direction: DIRECTIONS) {
                    List<Integer> paths = new ArrayList<>();
                    int oneDimensionIdx = r * colNum + c;
                    seen.add(oneDimensionIdx);
                    paths.add(matrix[r][c]);
                    backtracking(matrix, r, c, 1, direction, false, seen, paths);
                    seen.remove(oneDimensionIdx);
                }
            }
        }


        return maxTrailingZeroes;
    }

    /**
     for each cell:
     if isTurned:
     only can go with currentDirection:
     if next cell is valid: in matrix and not yet seen:
     seen.add(nextcell)
     backtracking(nextcell)
     seen.remove(nextcell)
     else:
     There are 3 options:
     keep going with current directions
     if next cell is valid: in matrix and not yet seen:
     seen.add(nextcell)
     backtracking(nextcell)
     seen.remove(nextcell)
     Turn left
     if next cell is valid: in matrix and not yet seen:
     seen.add(nextcell)
     backtracking(nextcell)
     seen.remove(nextcell)
     Turn right
     if next cell is valid: in matrix and not yet seen:
     seen.add(nextcell)
     backtracking(nextcell)
     seen.remove(nextcell)

     so we also need to have 2 sub methods:
     rtraversal to do:
     if next cell is valid: in matrix and not yet seen:
     seen.add(nextcell)
     backtracking(nextcell)
     seen.remove(nextcell)
     turn() -> return next_direction
     */
    private static void backtracking(int[][] matrix, int cr, int cc
            , int pathProduct, int[] curDirection
            , boolean isTurned, Set<Integer> seen, List<Integer> paths) {

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int curPathProduct = pathProduct * matrix[cr][cc];
        int curZeroCnt = countZero(curPathProduct);
//        if (curZeroCnt == 5) {
//            System.out.print(curPathProduct);
//            paths.forEach(e -> System.out.print(e + " "));
//            System.out.println("end one case");
//        }
        maxTrailingZeroes = Math.max(maxTrailingZeroes, curZeroCnt);

        if (isTurned) {
            int nr = cr + curDirection[0];
            int nc = cc + curDirection[1];
            int oneDimensionIdx = nr * colNum + nc;
            if (isValid(rowNum, colNum, nr, nc, seen)) {
                seen.add(oneDimensionIdx);
                paths.add(matrix[nr][nc]);
                backtracking(matrix, nr, nc, pathProduct * matrix[cr][cc], curDirection, isTurned, seen, paths);
                paths.remove(paths.size()-1);
                seen.remove(oneDimensionIdx);
            }
        } else {
            // keep going
            int nr = cr + curDirection[0];
            int nc = cc + curDirection[1];
            int oneDimensionIdx = nr * colNum + nc;
            if (isValid(rowNum, colNum, nr, nc, seen)) {
                seen.add(oneDimensionIdx);
                paths.add(matrix[nr][nc]);
                backtracking(matrix, nr, nc, pathProduct * matrix[cr][cc], curDirection, false, seen, paths);
                paths.remove(paths.size()-1);
                seen.remove(oneDimensionIdx);
            }

            //turn left
            int[] next_loc = calculateTurn(curDirection, true);
            nr = cr + next_loc[0];
            nc = cc + next_loc[1];
            oneDimensionIdx = nr * colNum + nc;
            if (isValid(rowNum, colNum, nr, nc, seen)) {
                seen.add(oneDimensionIdx);
                paths.add(matrix[nr][nc]);
                backtracking(matrix, nr, nc, pathProduct * matrix[cr][cc], next_loc, true, seen, paths);
                paths.remove(paths.size()-1);
                seen.remove(oneDimensionIdx);
            }

            //turn right
            next_loc = calculateTurn(curDirection, false);
            nr = cr + next_loc[0];
            nc = cc + next_loc[1];
            oneDimensionIdx = nr * colNum + nc;
            if (isValid(rowNum, colNum, nr, nc, seen)) {
                seen.add(oneDimensionIdx);
                paths.add(matrix[nr][nc]);
                backtracking(matrix, nr, nc, pathProduct * matrix[cr][cc], next_loc, true, seen, paths);
                paths.remove(paths.size()-1);
                seen.remove(oneDimensionIdx);
            }
        }

    }

    private static boolean isValid(int rowNum, int colNum, int nr, int nc, Set<Integer> seen) {
        int oneDimensionIdx = nr * colNum + nc;
        return nr >= 0 && nr < rowNum &&
                nc >= 0 && nc < colNum &&
                !seen.contains(oneDimensionIdx);
    }

    private static int[] calculateTurn(int[] curDirection, boolean isTurnedLeft) {
        if (curDirection == BOTTOM_TO_UP) {
            return isTurnedLeft ? RIGHT_TO_LEFT : LEFT_TO_RIGHT;
        } else if (curDirection == TOP_TO_DOWN) {
            return isTurnedLeft ? LEFT_TO_RIGHT : RIGHT_TO_LEFT;
        } else if (curDirection == LEFT_TO_RIGHT) {
            return isTurnedLeft ? BOTTOM_TO_UP : TOP_TO_DOWN;
        } else {//if (curDirection == RIGHT_TO_LEFT)
            return isTurnedLeft ? TOP_TO_DOWN : BOTTOM_TO_UP;
        }
    }

    private static int countZero(int number) {
        int zero = 0;
        while (number % 10 == 0) {
            zero++;
            number = number / 10;
        }
        return zero;
    }

    public static void main(String[] args) {
        // int[][] data = new int[][] {
        //   {10, 100, 10},
        //   {1, 10, 1},
        //   {1, 10, 1}
        // };

        // int[][] data = new int[][] {
        //   {6, 25, 4,10},
        //   {12, 25, 1, 15},
        //   {7, 15, 15, 5}
        // };

        int[][] data = new int[][] {
                {5, 8, 3,1},
                {4, 15, 12, 1},
                {6, 7, 10, 1},
                {9, 1, 2, 1}
        };
        // getMaxZeroTrailingPath(data);
        System.out.print(getMaxZeroTrailingPath(data));
    }
}