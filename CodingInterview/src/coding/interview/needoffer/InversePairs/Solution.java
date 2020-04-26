package coding.interview.needoffer.InversePairs;

import java.util.Arrays;

public class Solution {
    final int K = 1000000007;

    int[] copy = null;

    public int InversePairs(int [] array) {
        copy = Arrays.copyOf(array, array.length);
        return process(array, 0, array.length-1);
    }

    public int process(int[]array, int lo, int hi) {
        if (lo == hi) {
            return 0;
        }

        int mid = lo + (hi - lo) / 2;

        int leftCount = process(array, lo, mid) % K;
        int rightCount = process(array, mid + 1, hi) % K;

        int total = (leftCount + rightCount) % K;

        int i = mid, j = hi;
        int copyI = hi;
        int rightStart = mid + 1;
        while (i >= lo && j >= mid + 1) {
            if(array[i] > array[j]){
                total += (j-rightStart+1);
                if (total > K){
                    total = total % K;
                }
                copy[copyI] = array[i--];
            }else {
                copy[copyI] = array[j--];
            }
            copyI--;
        }

        // 处理剩余的部分
        while(i>=lo){
            copy[copyI--] = array[i--];
        }
        while(j>=mid+1){
            copy[copyI--] = array[j--];
        }
        // 将排好序的部分从copy中移至array
        for(int k=lo;k<=hi;k++){
            array[k] = copy[k];
        }

        return total;
    }

    public static void main(String[] args) {
        Solution  s = new Solution();
        int[] demo = {5, 4, 3, 2, 1};
        System.out.println(s.InversePairs(demo));
    }
}