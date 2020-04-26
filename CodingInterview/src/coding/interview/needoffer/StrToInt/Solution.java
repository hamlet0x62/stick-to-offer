package coding.interview.needoffer.StrToInt;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    static boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }

    public static int StrToInt(String str) {
        int rst = 0;

        if(str.length() == 0){
            return 0;
        }
        boolean isNegative = str.charAt(0) == '-'? true: false;
        if(!isNegative && str.charAt(0) != '+' && !isDigit(str.charAt(0))){
            return 0;
        }

        int start = 0;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            if(str.length() < 2){
                return 0;
            }
            start = 1;
        }
        for(int i=start;i<str.length();i++){
            char ch = str.charAt(i);
            if(!isDigit(ch)){
                return 0;
            }
            int digit = ch - '0';

            rst = rst * 10 + digit;
        }
        out.println(rst);

        if (rst < 0){
            // 溢出
            if (isNegative && rst == Integer.MAX_VALUE + 1){
                return Integer.MIN_VALUE;
            }else {
                return 0;
            }
        }
        if(isNegative){
            return -1 * rst;
        }else {
            return rst;
        }
    }



    public static void main(String[] args) {
        // test method

    }

}
