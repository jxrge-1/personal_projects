/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudokusolver;

/**
 *
 * @author jorgegutierrezjr.
 */
public class SudokuSolver {

    /**
     * @param args the command line arguments
     */
    private final static int GRID_SIZE = 9;

    public static void main(String[] args) {
        // TODO code application logic here
        int[][] board = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        
        //before we call the solveBoard method
        printBoard(board);

        if (solveBoard(board)) {
            System.out.println("\nYou solved the puzzle!\n");
        } else {
            System.out.println("\nThe board is Unsolveable!!\n");
        }
        
        //after we call the solveBoard method
        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println(); //prints out a new line after each row 
        }
    }

    private static boolean isNumberInRow(int[][] board, int number, int row) {
        /*
        * user provides the row we are checking to see if the number is present or not
        var row stays the same but we iterate through the same row checking for the number we input
         */
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        /*
        * user provides the column we are checking to see if the number is present or not
        var column stays the same but we iterate through the same column checking for the number we input
         */
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        //purpose of this method is to traverse the local 3x3 box by starting at the upper left most square
        int localBoxRow = row - row % 3;
        //these formulas help us do so by getting the current row/column and using
        //mod to get the remainder which we subtract from said row/column
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        //method is checking if the user input coordinates are valid 
        return !isNumberInRow(board, number, row)
                && !isNumberInColumn(board, number, column)
                && !isNumberInBox(board, number, row, column);
    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    //the for loop below is looping numbers from 1 to 9 for the specific 
                    //coordinates the user input and checking if said coordiantes are a valid placement via placementMethod
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, column)) {
                            //if the placement is valid then we set the number equal to that coordinate
                            board[row][column] = numberToTry;

                            /*
                            recurvisely call the method to traverse the 
                            entire grid to find the first next blank spot
                             */
                            if (solveBoard(board)) {
                                return true;
                                /*
                                if a placement is valid then 
                                the next recusive call is made
                                else.. if the entire puzzle cannot be solved
                                based on "valid placements"..else *refer to Else statement below*
                                 */
                            } else {
                                /*
                                ..else we set back the previous coordinate back to 0
                                to try the remainder of the numbers
                                 */
                                board[row][column] = 0;
                                /*
                                we set to 0 because we cannot solve the Soduku
                                based on the previous coordinate(s).. so we set to 0
                                and try further into the current for loop
                                 */
                            }

                        }//end of innerMost for loop checking numbers 1 - 9
                    }
                    return false; //FIGURE OUT WHAT THIS FALSE REFERS TO
                }
            }
        }
        return true;
    }

}
