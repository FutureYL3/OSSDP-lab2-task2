import org.junit.Test;

import static org.junit.Assert.*;

public class L2022211709_19_Test {
    /*
     * For method gameOfLife
     * Formal description: int[][] -> int[][]
     *
     * Partition the input as follows:
     * int[][]: 1. 行和列的长度都为0
     *          2. 行的长度为0，列的长度不为0
     *          3. 列的长度为0，行的长度不为0
     *          4. 行的长度为1，列的长度为1
     *          5. 行的长度为1，列的长度大于1
     *          6. 列的长度为1，行的长度大于1
     *          7. 行和列的长度都大于1
     *
     * Exhaustive Cartesian coverage of partitions.
     */

    // covers 1. 行和列的长度都为0
    // input: int[0][0]
    // expected output: ArrayIndexOutOfBoundsException
    @Test
    public void testGameOfLifeCase1() {
        int[][] board = new int[0][0];
        Solution solution = new Solution();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            solution.gameOfLife(board);
        });
    }

    // covers 2. 行的长度为0，列的长度不为0
    // input: int[0][4]
    // expected output: ArrayIndexOutOfBoundsException
    @Test
    public void testGameOfLifeCase2() {
        int[][] board = new int[0][4];
        Solution solution = new Solution();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            solution.gameOfLife(board);
        });
    }

    // covers 3. 列的长度为0，行的长度不为0
    // input: int[4][0]
    // expected output: int[4][0]
    @Test
    public void testGameOfLifeCase3() {
        int[][] board = new int[4][0];
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[4][0];
        assertArrayEquals(expected, board);
    }

    // covers 4. 行的长度为1，列的长度为1
    // input: [[1]]
    // expected output: [[0]]
    @Test
    public void testGameOfLifeCase4() {
        int[][] board = new int[1][1];
        board[0][0] = 1;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[1][1];
        expected[0][0] = 0;
        assertArrayEquals(expected, board);
    }

    // covers 5. 行的长度为1，列的长度大于1
    // input: [[1, 0, 1]]
    // expected output: [[0, 0, 0]]
    @Test
    public void testGameOfLifeCase5() {
        int[][] board = new int[1][3];
        board[0][0] = 1;
        board[0][1] = 0;
        board[0][2] = 1;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[1][3];
        expected[0][0] = 0;
        expected[0][1] = 0;
        expected[0][2] = 0;
        assertArrayEquals(expected, board);
    }

    // covers 6. 列的长度为1，行的长度大于1
    // input: [[1], [0], [1]]
    // expected output: [[0], [0], [0]]
    @Test
    public void testGameOfLifeCase6() {
        int[][] board = new int[3][1];
        board[0][0] = 1;
        board[1][0] = 0;
        board[2][0] = 1;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[3][1];
        expected[0][0] = 0;
        expected[1][0] = 0;
        expected[2][0] = 0;
        assertArrayEquals(expected, board);
    }

    // covers 7. 行和列的长度都大于1
    // input: [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    // expected output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    @Test
    public void testGameOfLifeCase7() {
        int[][] board = new int[4][3];
        board[0][0] = 0;
        board[0][1] = 1;
        board[0][2] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 1;
        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;
        board[3][0] = 0;
        board[3][1] = 0;
        board[3][2] = 0;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[4][3];
        expected[0][0] = 0;
        expected[0][1] = 0;
        expected[0][2] = 0;
        expected[1][0] = 1;
        expected[1][1] = 0;
        expected[1][2] = 1;
        expected[2][0] = 0;
        expected[2][1] = 1;
        expected[2][2] = 1;
        expected[3][0] = 0;
        expected[3][1] = 1;
        expected[3][2] = 0;
        assertArrayEquals(expected, board);
    }

    // covers 7. 行和列的长度都大于1
    // input: [[1,1],[1,0]]
    // expected output: [[1,1],[1,1]]
    @Test
    public void testGameOfLifeCase8() {
        int[][] board = new int[2][2];
        board[0][0] = 1;
        board[0][1] = 1;
        board[1][0] = 1;
        board[1][1] = 0;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[2][2];
        expected[0][0] = 1;
        expected[0][1] = 1;
        expected[1][0] = 1;
        expected[1][1] = 1;
        assertArrayEquals(expected, board);
    }
}
