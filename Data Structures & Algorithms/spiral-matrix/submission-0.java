class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int M = matrix.length;
        final int N = matrix[0].length;

        List<Integer> list = new ArrayList<>();
        Dir dir;

        int curUpperRow = 0, curLowerRow = M - 1, curLeftCol = 0, curRightCol = N - 1;
        int i = 0, row = 0, col = 0;
        dir = Dir.E;

        while (i < M * N) {
            list.add(matrix[row][col]);

            if (dir == Dir.N) {
                if (row > curUpperRow) {
                    row--;
                } else {
                    col++;
                    curLeftCol++;
                    dir = Dir.E;
                }
            } else if (dir == Dir.E) {
                if (col < curRightCol) {
                    col++;
                }
                else {
                    row++;
                    curUpperRow++;
                    dir = Dir.S;
                }
            } else if (dir == Dir.S) {
                if (row < curLowerRow) {
                    row++;
                } else {
                    col--;
                    curRightCol--;
                    dir = Dir.W;
                }
            } else if (dir == Dir.W) {
                if (col > curLeftCol) {
                    col--;
                } else {
                    row--;
                    curLowerRow--;
                    dir = Dir.N;
                }
            }
            i++;
        }
        
        return list;
    }

    private enum Dir {
        N, E, S, W
    }
}