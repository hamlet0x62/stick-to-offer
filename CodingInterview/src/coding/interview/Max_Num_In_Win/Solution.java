package coding.interview.Max_Num_In_Win;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        Deque<Integer> deque = new LinkedList<>();

        ArrayList<Integer> rst = new ArrayList<>();

        for(int i=0;i<num.length;i++){
            if(deque.isEmpty()){
                deque.offerLast(i);
                if (size == 1){
                    rst.add(num[i]);
                }
            }else{
                Integer first = deque.peekFirst();
                if (first == i - size){
                    // 窗口已经离开 first
                    deque.pollFirst();

                }
                Integer last = deque.peekLast();
                while(last != null && num[last] <= num[i]){
                    // 在i之前比num[i]更小的元素
                    // 都不可能成为新窗口中的最大值了
                    deque.pollLast();
                    last = deque.peekLast();
                }

                deque.offerLast(i);
                if (i+1 >= size) {
                    // 以 num[i] 为结尾的窗口的所有数都遍历过了
                    int maxI = deque.peekFirst();
                    rst.add(num[maxI]);
                }

            }
        }

        return rst;

    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();
        int nums[] = new int[] {1, 2, 3, 5, 6, 3, 1, 3};

        ArrayList<Integer> rst = s.maxInWindows(nums, 1);
        for(Integer num : rst){
            out.print(num + ", ");
        }

    }

}
