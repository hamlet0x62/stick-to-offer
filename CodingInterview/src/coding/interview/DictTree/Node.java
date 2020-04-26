package coding.interview.DictTree;

public class Node {

    Node[] children = new Node[26];

    public int getOffsetByChar(char ch) {
        return ch - 'a';
    }

    boolean isSafe(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

}
