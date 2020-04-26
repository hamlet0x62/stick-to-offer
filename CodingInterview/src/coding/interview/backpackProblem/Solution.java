package coding.interview.backpackProblem;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    class Num implements Comparable<Num>{

        @Override
        public int compareTo(Num o) {
            return 0;
        }
    }


    public int solve(int[]m, int[] value, int capacity) {
        int n = m.length;
        int[][] dp = new int[n+1][capacity+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }

        for(int i=0;i<capacity+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<capacity+1;j++){
                if (j-m[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-m[i-1]]+value[i-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][capacity];

    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(), capacity = input.nextInt();
        int[] m = new int[n], value = new int[n];

        for(int i=0;i<n;i++){
            m[i] = input.nextInt();
            value[i] = input.nextInt();
        }

        out.println(s.solve(m, value, capacity));

    }


    boolean isToConflictWithClasses(CourseClass one, List<CourseClass> courseClasses){
        for (CourseClass cc : courseClasses){
            if (cc.startWeek > one.endWeek || cc.endWeek < one.startWeek){
                // 一门课在另外一门课开始上课之前结束
                // 或一门课在另外一门课结束之后开始
                // 则两门课程不冲突
                continue;
            }else {
                if(hasConflicts(one.schedules, cc.scheudles)){
                    return true;
                }
            }
        }
        return false;
    }


}
