package java8.matrix;

// Print All path from top left to bottom right
import java.util.Vector;

public class MatrixFindPath {
    static int totalCount = 0;
    static Vector vecRes = new Vector();

    static class MatrixPath {
        int startX = 0, startY = 0;
        int currentX  = 0, currentY = 0;
        int countDirection;

        /**
         * -1 not yet have direction
         * LEFT  1 RIGHT   2
         * UP    3 DOWN    4
         */
        int currentDirection = -1;
        Vector vectorDirection = new Vector();
        public MatrixPath(int startX, int startY) {
            this.startX = this.currentX = startX;
            this.startY = this.currentY = startY;
        }

        public boolean calDirection(int x, int y) {

            boolean result = false;
            int direction = -1;
            if(x > currentX) {
                direction = 4;
            } else if(x < currentX) {
                direction = 3;
            }
            if(y > currentY) {
                direction = 2;
            } else if(y < currentY) {
                direction = 1;
            }
            if(currentDirection == -1) {
                countDirection = 1;
                currentDirection = direction;
                vectorDirection.add(direction);
            }
            else {
                if(direction != currentDirection) {
                    countDirection++;
                    vectorDirection.add(direction);
                    result = true;
                }
            }
            currentX = x;
            currentY = y;
            return result;
        }
    }

    static class MatrixPoint {
        int x = 0, y = 0;
        int value = -1;
        public MatrixPoint(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private int countZeros(Vector<MatrixPoint> res) {
        int product = 1;
        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            int value = res.get(i).value;
            product *= value;
        }
        while (product > 0 && product % 10 == 0) {

            product /= 10;
            count++;
        }
        return count;
    }

    static String printString(Vector<MatrixPoint> res) {
        String value = "";
        for(int i=0;i<res.size();i++) {
            MatrixPoint point = res.get(i);
            value += point.value + " ";
        }
        return value;
//        System.out.println(value);
    }

    //LEFT  1 RIGHT   2
    //UP    3 DOWN    4
    private int calculateDirection(Vector<MatrixPoint> res) {
        if(res.size() < 3) return 1;

        int currentDirection = -1;
        MatrixPoint v1 = res.get(0);
        MatrixPoint v2 = res.get(1);
        if(v2.x > v1.x) {
            currentDirection = 4;
        } else if(v2.x < v1.x) {
            currentDirection = 3;
        }

        if(v2.y > v1.y) {
            currentDirection = 2;
        } else if(v2.y < v1.y) {
            currentDirection = 1;
        }

        int countDirection = 1;
        for(int i=2;i<res.size();i++) {
            v1 = res.get(i-1);
            v2 = res.get(i);
            int direction = -1;
            if(v2.x > v1.x) {
                direction = 4;
            } else if(v2.x < v1.x) {
                direction = 3;
            }
            if(v2.y > v1.y) {
                direction = 2;
            } else if(v2.y < v1.y) {
                direction = 1;
            }
            if(direction != currentDirection) {
                countDirection++;
                currentDirection = direction;
            }
        }
        return countDirection;
    }

    public boolean isValid(int i, int j, Vector<Vector<Integer>> vec
            , Vector<Vector<Integer>> hash) {
        if (i < 0 || j < 0
                || i >= vec.size()
                || j >= vec.get(0).size()
                || hash.get(i).get(j) == 1)
            return false;
        return true;
    }

    // Function to print all path
    void printAllPath(Vector<Vector<Integer>> vec
            , Vector<Vector<Integer>> hash, int i, int j
            , Vector<MatrixPoint> res, MatrixPath matrixPath) {

        if(!isValid(i, j, vec, hash)) return;
        // if the path is traverse already then
        // it will not go again the same path
        hash.get(i).set(j, 1);

        MatrixPoint point = new MatrixPoint(i, j, vec.get(i).get(j));
        // store the path
        res.add(point);

        // Keep current x, y, direction to roll back
        int previousX = matrixPath.currentX;
        int previousY = matrixPath.currentY;
        int previousDirection = matrixPath.currentDirection;
        boolean resultCalculation = matrixPath.calDirection(i, j);

        String value  = printString(res);
        int countDirection = calculateDirection(res);
        if(countDirection <= 2) {
            System.out.println(value + " Direction: " + countDirection);
            int tempCount = countZeros(res);
            if(tempCount > totalCount) {
                totalCount = tempCount;
                vecRes = new Vector(res);
            }
            // go to the right
            printAllPath(vec, hash, i, j + 1, res, matrixPath);

            // go to the down
            printAllPath(vec, hash, i + 1, j, res, matrixPath);

            // go to the up
            printAllPath(vec, hash, i - 1, j, res, matrixPath);

            // go to the left
            printAllPath(vec, hash, i, j - 1, res, matrixPath);
        }

        // pop the last element
        res.remove(res.size() - 1);

        // roll back x, y and direction
        if(resultCalculation) {
            matrixPath.countDirection--;
        }
        matrixPath.currentDirection = previousDirection;
        matrixPath.currentX = previousX;
        matrixPath.currentY = previousY;

        // hash position 0 for traverse another path
        hash.get(i).set(j, 0);

    }

    static Vector initVector() {
        Vector<Vector<Integer>> vec = new Vector<Vector<Integer>>();
        vec.add(new Vector<Integer>());
        vec.add(new Vector<Integer>());
        vec.add(new Vector<Integer>());
//        vec.add(new Vector<Integer>());

        vec.get(0).add(10); vec.get(0).add(100); vec.get(0).add(10);
        vec.get(1).add(1); vec.get(1).add(10);  vec.get(1).add(1);
        vec.get(2).add(1); vec.get(2).add(10); vec.get(2).add(1);

//        vec.get(0).add(6); vec.get(0).add(25); vec.get(0).add(4); vec.get(0).add(10);
//        vec.get(1).add(12); vec.get(1).add(25); vec.get(1).add(1); vec.get(1).add(15);
//        vec.get(2).add(7); vec.get(2).add(15); vec.get(2).add(15); vec.get(2).add(5);

//        vec.get(0).add(7500); vec.get(0).add(10); vec.get(0).add(11); vec.get(0).add(12);
//        vec.get(1).add(6250); vec.get(1).add(13); vec.get(1).add(14); vec.get(1).add(15);
//        vec.get(2).add(134); vec.get(2).add(17); vec.get(2).add(16); vec.get(2).add(1);
//        vec.get(3).add(5500); vec.get(3).add(2093); vec.get(3).add(5120); vec.get(3).add(238);

        return vec;
    }

    public static void main(String[] args) {

        MatrixFindPath matrixPrintPath = new MatrixFindPath();
        // Given matrix
        Vector<Vector<Integer>> vec = initVector();

        // mxn(2x3) 2d hash matrix
        for (int k = 0; k < vec.size(); k++) {
            for (int h = 0; h < vec.get(0).size(); h++) {
                Vector<Vector<Integer>> hash = new Vector<Vector<Integer>>();
                for (int i = 0; i < vec.size(); i++) {
                    hash.add(new Vector<Integer>());
                    for (int j = 0; j < vec.get(0).size(); j++) {
                        hash.get(i).add(0);
                    }
                }
                MatrixPath matrixPath = new MatrixPath(k, h);
                // print All Path of matrix
                matrixPrintPath.printAllPath(vec, hash, k, h, new Vector<MatrixPoint>(), matrixPath);
            }
        }

        System.out.println("Maximum trailing zeros: " + totalCount);
        String value = printString(vecRes);
        System.out.println("Path have maximum trailing zeros: " + value);

    }

}

