package week3.sudoku;

import week3.utils.ConsolUtils;

import java.util.ArrayList;

public class SudokuSolver {

    boolean displayProgress = false;

    private boolean trySolve(SudokuBoard board)
    {
        if (!board.isValid())
            return false;

        if (board.isComplete())
            return true;

        if (displayProgress)
        {
            ConsolUtils.clearScreen();
            System.out.println(board);
            ConsolUtils.pause(10);
        }

        BoardPosition empty = firstEmptySpot(board);
      // TODO try implementing this function below to speed up calculation
      //  int[] possibleNumbers = getBossibleNumbers(board, empty);



        for (int i = 1; i <= board.getBoardSize() ; i++) {
            board.set(empty.getRow(),empty.getCol(),i);

            if (trySolve(board))
                return true;

            board.erase(empty.getRow(),empty.getCol());
        }

        return false;

    }

    private BoardPosition firstEmptySpot(SudokuBoard board) {

        for (int r = 0; r < board.getBoardSize(); r++) {
            for (int c = 0; c < board.getBoardSize(); c++) {
                if (board.isEmpty(r,c))
                    return new BoardPosition(r,c);
            }
        }

        return null;
    }

    /**
     * Returns the solution of a given board if it exists
     * returns null otherwise
     * @param board
     * @return
     */
    SudokuBoard solve(SudokuBoard board)
    {
        SudokuBoard solution = new SudokuBoard(board);

        if (trySolve(solution))
            return solution;

        System.out.println("NO SOLUTION!");
        return null;


    }


    public static void main(String[] args) {
        SudokuBoard sb = new SudokuBoard(25);
        SudokuSolver solver = new SudokuSolver();

        sb.set(1,4,3);
        sb.set(5,4,2);

        System.out.println(sb);

        SudokuBoard solution =  solver.solve(sb);
        if (solution!= null)
            System.out.println(solution);
    }
}
