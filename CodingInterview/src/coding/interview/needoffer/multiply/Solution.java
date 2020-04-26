package coding.interview.needoffer.multiply;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public int[] multiply(int[] A) {

        int[] result = new int[A.length];
        Arrays.fill(result, 0);
        if(A.length <= 1){
            return result;
        }

        for(int i=0;i<A.length;i++){
            result[i] = 1;
            for(int j=0;j<A.length;j++){
                if(j == i){
                    continue;
                }
                result[i] *= A[j];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        // test method
    }

}
