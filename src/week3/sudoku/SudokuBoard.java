package week3.sudoku;

import week3.utils.ConsolUtils;

import java.util.Arrays;

public class SudokuBoard {

    public static final int DEFAULT_BOARD_SIZE = 9;
    public static final int EMPTY = 0;

    private int[][] board;
    private int boardSize;
    private int blockSize;

    public SudokuBoard(int[][] board) {
        this.board = board;
        boardSize = board.length;
        blockSize = (int)Math.sqrt(boardSize);
    }

    SudokuBoard(SudokuBoard other)
    {
        boardSize = other.boardSize;
        blockSize = other.blockSize;
        board = new int[boardSize][boardSize];

        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                board[r][c]= other.board[r][c];
            }
        }
    }

    /**
     * Creates an empty board with given size
     * @param boardSize
     */
    public SudokuBoard(int boardSize) {
        this(new int[boardSize][boardSize]);
    }

    /**
     * Creates an empty board with default size
     */
    public SudokuBoard() {
        this(DEFAULT_BOARD_SIZE);
    }

    /**ü
     * This is not recommended for safety reasons
     * @return
     */
    int[][] getBoard()
    {
        return board;
    }

    public int get(int r, int c)
    {
        return board[r][c];
    }

    public int getBoardSize()
    {
        return boardSize;
    }

    public void set(int r, int c ,int val)
    {
        board[r][c]= val;
    }

    public void erase(int r, int c)
    {
        set(r,c,EMPTY);
    }


    /**
     * TODO: returns if the current is valid.
     * @return
     */
    public boolean isValid()
    {
        return allRowsValid() && allColsValid() && allBlocksValid();
    }


    boolean isValidArray(int[] arr)
    {
        int[] counts =  new int[boardSize+1];

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            if (n <0 || n>boardSize)
                return false;
            if (n == EMPTY)
                continue;

            counts[n]++;
            if (counts[n]>1)
                return false;
        }

        return true;
    }

    private boolean allBlocksValid() {
        for (int block = 0; block < boardSize; block++) {
            if (! isValidBlock(block))
                return false;
        }

        return true;
    }

    private boolean isValidBlock(int block) {
        int[] column = getBlock(block);
        return isValidArray(column);
    }

    private int[] getBlock(int b) {
        int[] block = new int[boardSize];
        int count =0;
        int tr= (b/blockSize)* blockSize;
        int tc = (b%blockSize)*blockSize;

        for (int r = tr; r < tr + blockSize; r++) {
            for (int c = tc; c < tc + blockSize; c++) {
                block[count++]= board[r][c];
            }
        }

        return block;
    }

    private boolean allColsValid() {
        for (int col = 0; col < boardSize; col++) {
            if (! isValidCol(col))
                return false;
        }

        return true;

    }

    private boolean isValidCol(int col) {
        int[] column = getColumn(col);
        return isValidArray(column);
    }

    private int[] getColumn(int c) {
        int[] column = new int[boardSize];

        for (int r = 0; r < boardSize; r++) {
            column[r] = board[r][c];
        }
        return column;
    }

    private boolean allRowsValid() {
        for (int row = 0; row < boardSize; row++) {
            if (! isValidRow(row))
                return false;
        }

        return true;
    }

    private boolean isValidRow(int row) {
        return isValidArray(board[row]);
    }
    /**
     * TODO:
     */
    public boolean isComplete()
    {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                if (isEmpty(r,c))
                    return false;
            }
        }
        return true;
    }

    public boolean isEmpty(int r, int c) {
        return board[r][c]== EMPTY;
    }


    public boolean isSolved()
    {
        return isComplete() && isValid();
    }

    /**
     * returns the string representation as follows:
     * -------------------------
     * | 0 1 0 | 0 0 0 | 0 5 0 |
     * | 0 0 0 | 0 3 0 | 0 0 0 |
     * | 2 0 0 | 0 0 0 | 0 0 0 |
     * -------------------------
     * | 0 0 0 | 0 0 0 | 0 0 0 |
     * | 0 5 0 | 0 0 0 | 0 0 0 |
     * | 0 0 0 | 0 0 0 | 0 0 0 |
     * -------------------------
     * | 0 0 0 | 0 0 9 | 0 0 0 |
     * | 0 0 0 | 0 0 0 | 0 1 0 |
     * | 0 0 7 | 0 8 0 | 0 0 0 |
     * -------------------------
     */
    public String toString() {
        String st = drawBoardLine() + "\n";

        for (int r = 0; r < boardSize; r++) {
            st += rowToString(r)+"\n";
            if ( (r+1)%blockSize==0)
                st += drawBoardLine()+ "\n";
        }

        return st;
    }

    private String rowToString(int row) {
        String st =ConsolUtils.colorize("| ",ConsolUtils.ANSI_CYAN);
        for (int c = 0; c < boardSize; c++) {
            st += getAsText(row,c) + " ";
            if ( (c+1)%blockSize==0 )
                st += ConsolUtils.colorize("| ",ConsolUtils.ANSI_CYAN);
        }

        return st;
    }

    private String getAsText(int row, int col) {

        if (board[row][col]== EMPTY)
            return ConsolUtils.colorize(".", ConsolUtils.ANSI_YELLOW);
        return ConsolUtils.colorize(board[row][col]+ "", ConsolUtils.ANSI_RED);
    }

    private String drawBoardLine() {
        int linewidth = 2*(boardSize + blockSize)+1;
        String st ="";
        for (int i = 0; i < linewidth; i++) {
            st += "=";
        }

        return ConsolUtils.colorize(st,ConsolUtils.ANSI_CYAN);
    }

    public static void main(String[] args) {
        SudokuBoard sb = new SudokuBoard();

        ConsolUtils.clearScreen();

        sb.set(1,4,3);
        sb.set(5,4,3);

        System.out.println(sb);

        System.out.println("Valid: "+ sb.isValid());
        System.out.println("Complete: "+ sb.isComplete());
        System.out.println("Solved: "+ sb.isSolved());

    }
}
