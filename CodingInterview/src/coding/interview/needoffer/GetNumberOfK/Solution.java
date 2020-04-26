package coding.interview.needoffer.GetNumberOfK;

public class Solution {

    int lowerBound(int[] array, int k){
        int lo = 0;
        int hi = array.length - 1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(array[mid] == k){
                if(mid > 0 && array[mid-1] == k){
                    hi = mid - 1;
                }else {
                    return mid;
                }
            }else if(array[mid] > k){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        int startIndex = lowerBound(array, k);

        if(startIndex < 0 || array.length == 0){
            return 0;
        }

        for(int i=startIndex;i<array.length && array[i] == k;i++){
            count++;
        }
        return count;

    }
}