package coding.interview.cutRope;

import java.util.*;

import static java.lang.System.out;

public class Solution {
    public static int innerCnt = 0;
    public static int outerCnt = 0;

    // 这里用贪心，贪的是既希望每次切的足够大，又希望切的线段足够多
    public int cutRope(int target) {
        int max = 1;

        for(int firstCut = target-1;firstCut > 0;firstCut--){
            int tmpMax = firstCut;
            int left = target - firstCut;
            int tmpCutSize = firstCut;

            while (left > 0){
                while(tmpCutSize > left){
                    // 如果当前切不了tmpCutSize大小的线段
                    // 就缩小tmpCutSize直至能够剪出对应长度的线段
                    tmpCutSize--;
                    innerCnt++;
                }
                left -= tmpCutSize;
                tmpMax = tmpMax * tmpCutSize;
                outerCnt++;

            }

            max = Math.max(tmpMax, max);


        }

        return max;

    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();
        out.println(s.cutRope(60));
        out.println("count: " + (innerCnt + outerCnt));

    }

}
