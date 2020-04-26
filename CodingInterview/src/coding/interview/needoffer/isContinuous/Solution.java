package coding.interview.needoffer.isContinuous;

import java.util.*;
import static java.lang.System.out;

public class Solution {

    public boolean isContinuous(int [] numbers) {

        if(numbers.length == 0){
            return false;
        }

        int jokers = 0;
        int min = Integer.MAX_VALUE;

        HashSet<Integer> set = new HashSet<>(13);

        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 0){
                jokers++;
            }else {
                if(set.contains(numbers[i])){
                    return false;
                }else{
                    set.add(numbers[i]);
                    if(numbers[i] < min){
                        min = numbers[i];
                    }
                }
            }
        }


        for(int i=0;i<=jokers;i++){
            int start = Math.max(min - i, 1);
            int currJokers = jokers;
            boolean flag = true;

            for(int j=1;j<=numbers.length-1;j++){
                if(!set.contains(start+j)){
                    // 如果没有找到可用的牌，用joker代替
                    if(currJokers > 0) {
                        currJokers--;
                    }else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                return true;
            }else if(start == 1){
                // 如果最小的数字是1，且不存在相应的顺子序列，直接返回false
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {0, 3, 1, 6, 4};
        out.println(solution.isContinuous(nums));

    }

}
