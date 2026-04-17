class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check for repetitions in each of the following scenarios:
        Set<Character> boardFreq = new HashSet<>();

        // each row
        for ( int r = 0; r < 9; r++ ) {
            for ( int c = 0; c < 9; c++ ) {
                if ( board[r][c] == '.') {
                    continue;
                }
                else if ( boardFreq.add(board[r][c]) == false ) { // repeated num
                    return false;
                }
            }
            boardFreq.clear();
        }

        // each col
        for ( int c = 0; c < 9; c++ ) {
            for ( int r = 0; r < 9; r++ ) {
                if ( board[r][c] == '.' ) {
                    continue;
                }
                else if ( boardFreq.add(board[r][c]) == false ) { // repeated num
                    return false;
                }
            }
            boardFreq.clear();
        }

        // each 3x3 box
        for ( int b = 0; b < 9; b++ ) {
            for ( int i = 0; i < 9; i++ ) {
                int row = (i / 3) + ((b / 3) * 3);
                int col = (i % 3) + ((b % 3) * 3);

                if ( board[row][col] == '.' ) {
                    continue;
                }
                else if ( boardFreq.add(board[row][col]) == false ) { // repeated num
                    return false;
                }
            }
            boardFreq.clear();
        }

        return true;

        //box 0
        //iter 012345678
        //row: 000111222
        //col: 012012012

        //box 1
        //iter 012345678
        //row: 000111222
        //col: 345345345

        //...

        //box 3
        //iter 012345678
        //row: 333444555
        //col: 012012012

        //row: (iter / 3) + ((box % 3) * 3)
        //col: (iter % 3) + ((box % 3) * 3)
    }
}
