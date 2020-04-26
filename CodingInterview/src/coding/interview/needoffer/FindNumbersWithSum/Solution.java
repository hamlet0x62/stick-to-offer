package coding.interview.needoffer.FindNumbersWithSum;
import java.util.*;

public class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        ArrayList<Integer> result = new ArrayList<>(2);
        HashSet<Integer> occured = new HashSet<>();

        for(int i=0;i<array.length;i++){
            occured.add(array[i]);
        }
        int multiply = Integer.MAX_VALUE;

        for(int i=0;i<array.length;i++){
            int other = sum - array[i];
            if(occured.contains(other) && multiply > other * array[i]){
                result.clear();
                result.add(Math.min(other, array[i]));
                result.add(Math.max(other, array[i]));
            }
        }
        return result;
    }

}
