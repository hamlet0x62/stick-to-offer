package coding.interview.needoffer.Special_Add;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public static int Add(int num1,int num2) {

        int rst = 0;
        int carry = 0;
        int bitOffset = 0;

        while (num1 != 0 || num2 != 0){
            int currBit = (num1 & 1) ^ (num2 & 1);

            if(currBit == 0 && (num1 & 1) == 1) {
                if (carry == 1){
                    // 如过上一位的产生了进位，则当位的结果为1
                    currBit = 1;
                    carry = 1; // 进位保留
                }else {
                    // 进位
                    carry = 1;
                }
            }else {
                if(carry == 1){
                    if(currBit == 1){
                        carry = 1;
                        currBit = 0;
                    }else {
                        currBit = 1;
                        carry = 0;
                    }
                }
            }
            rst = rst | (currBit << bitOffset);
            num1 >>>= 1;
            num2 >>>= 1;


            bitOffset++;
            out.println("CurrentBit:" + currBit);
            out.println("Carry: " + carry);
        }

        if(carry > 0){
            rst = rst | (carry << bitOffset);
        }

        return rst;
    }


    public static void main(String[] args) {
        // test method

        out.print(Add(-2, -2));
    }

}
