package coding.interview.Median_Num_In_Stream;

import java.util.*;

import static java.lang.System.out;

public class Solution {
    ArrayList<Integer> nums = new ArrayList<>();

    public void Insert(Integer num) {
        nums.add(num);
    }

    public Double GetMedian() {
        int sz = nums.size();
        if(sz % 2 == 0){
            Double num1 = (double)findKth(sz/2), num2 = (double)findKth(sz/2+1);
            return (num1 + num2) / 2;
        }else {
            return (double) findKth(sz/2 + 1);
        }
    }

    Integer findKth(int k){

        Integer[] array = new Integer[nums.size()];
        array = nums.toArray(array);
        return findKth(k, array, 0, array.length-1);
    }

    void swap(Integer[] array, int i, int j){
        int tmp  = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    Integer findKth(int k, Integer[] array, int low, int high){

        int pivot = low;

        for(int i=low;i<high;i++){
            if(array[i] < array[high]){
                swap(array, i, pivot++);
            }
        }

        swap(array, pivot, high);
        int lessEqualCount = pivot-low+1;

        if(lessEqualCount == k){
            return array[pivot];
        }else if(lessEqualCount < k){
            return findKth(k-lessEqualCount, array, pivot+1, high);
        }else {
            return findKth(k, array, low, pivot-1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[] nums = new Integer[] {2, 3, 1, 5, 6, 4};

        for(Integer num:nums){
            s.Insert(num);
            out.println(s.GetMedian());
        }

    }
}
