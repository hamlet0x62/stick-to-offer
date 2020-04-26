package coding.interview.DictTree;
import java.util.Arrays;

import static java.lang.System.out;

public class Solution {

    char[] matrix;
    int[][] moves;
    int rowNum, colNum;
    boolean[] visited;

    boolean dfs(int i, int j, int currIndex, char[] str){

        visited[indexFor(i, j)] = true;

        if(getCharacter(i, j) != str[currIndex]){
            return false;
        } else {
            if(currIndex == str.length - 1){
                return true;
            }
        }


        for(int d = 0; d < moves.length; d++){
            int rd = moves[d][0], cd = moves[d][1];
            int targetX = i + rd, targetY = j + cd;
            int visitedIndex = indexFor(targetX, targetY);
            if(isSafe(targetX, targetY) && !visited[visitedIndex]){
                boolean matched = dfs(targetX, targetY, currIndex+1, str);
                if(matched){
                    return true;
                }
                // 除当前点外，其他的点还是可以访问点 visitedIndex 的
                visited[visitedIndex] = false;
            }
        }

        return false;

    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){

        if(matrix == null || matrix.length != rows * cols || str == null || str.length > matrix.length){
            return false;
        }

        this.matrix = matrix;
        this.rowNum = rows;
        this.colNum = cols;

        int[][] moves = new int[4][];
        moves[0] = new int[]{1, 0};
        moves[1] = new int[]{-1, 0};
        moves[2] = new int[]{0, -1};
        moves[3] = new int[]{0, 1};

        visited = new boolean[matrix.length];
        initVisited();

        this.moves = moves;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                boolean matched = dfs(i, j, 0, str);
                if (matched){
                    return true;
                }
                initVisited();
            }
        }
        return false;

    }

    void initVisited(){
        Arrays.fill(visited, false);
    }

    int indexFor(int row, int col){
        int i = row * colNum + col;
        return i;
    }

    boolean isSafe(int row, int col){
        return row >=0 && row < rowNum && col >= 0 && col < colNum;
    }


    char getCharacter(int row, int col){

        return matrix[indexFor(row, col)];
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        char[] matrix = new char[] {
                'A', 'B', 'C', 'E',
                'S', 'F', 'C', 'S',
                'A', 'D', 'E', 'E',
        };

        matrix = "ABCESFCSADEE".toCharArray();
        char[] str = new char[] {
                'A', 'C', 'C'
        };
        out.println(s.hasPath(matrix, 3, 4, str));

    }


}
