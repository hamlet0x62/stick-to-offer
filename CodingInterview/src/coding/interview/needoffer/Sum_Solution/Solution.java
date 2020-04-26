package coding.interview.needoffer.Sum_Solution;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public static int Sum_Solution(int n) {
        boolean rst = (n>0) && (n+=Sum_Solution(n-1)) > 0;
        return n;
    }


    public static void main(String[] args) {
        // test method
        out.println(Sum_Solution(0));


    }

}
