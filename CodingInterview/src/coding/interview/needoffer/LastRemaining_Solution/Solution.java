package coding.interview.needoffer.LastRemaining_Solution;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public int LastRemaining_Solution(int n, int m) {

        if(m < 1 || n == 0){
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            queue.offer(i);
        }


        while(queue.size() > 1){
            for(int i=0;i<m-1;i++){
                queue.offer(queue.poll());
            }
            // 移除叫号为 m-1 的朋友
            queue.poll();
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        out.println(solution.LastRemaining_Solution(0, 1));
    }

}
