package coding.interview.FindNumsAppearOnce;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult = xorResult ^ array[i];
        }

        int specialBitInNum1 = 1;
        num1[0] = 0;
        num2[0] = 0;

        while ((specialBitInNum1 & xorResult) == 0) {
            // 找到其中一个数的特征位，
            // 这个特征位在另一个数中是不存在的
            specialBitInNum1 <<= 1;
        }

        for (int i = 0; i < array.length; i++) {
            // num1 与 num2 各自排除另一个数对自身的干扰
            if ((array[i] & specialBitInNum1) != 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();

        int[] nums = new int[]{2,4,3,6,3,2,5,5};

        int[] num1 = new int[1];
        int[] num2 = new int[1];

        s.FindNumsAppearOnce(nums, num1, num2);

        out.println("Num1: " + num1[0] + ", Num2: " + num2[0]);
    }

}
