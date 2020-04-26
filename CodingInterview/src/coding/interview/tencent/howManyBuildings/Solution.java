package coding.interview.tencent.howManyBuildings;

import java.util.*;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class Solution {

    class Building {
        int height;
        int index;


       public Building(int i, int height){
            this.index = i;
            this.height = height;
        }

        public Building(int height){
           this.height = height;
        }
    }

    public int[] countBuildings (int[] heights){

        int[] result = new int[heights.length];
        Arrays.fill(result, 1);
        TreeSet<Building> set = new TreeSet<>((b1, b2) -> {
            if(b1.height == b2.height){
                return b1.index - b2.index;
            }
            return b1.height - b2.height;});

        // 往前数
        for(int i=0;i<heights.length;i++){
            process(heights[i], result, set, i, false);
        }

        set.clear();

        // 往后数
        for(int i=heights.length-1;i>=0;i--){
            process(heights[i], result, set, i, true);
        }

        return result;

    }

    private void process(int height, int[] result, TreeSet<Building> set, int i, boolean reverse) {
        Building curr = new Building(i, height);

        if(set.isEmpty()){
            set.add(curr);
        }else {
            Building ceil = set.ceiling(curr);
            if(ceil == null){
                // 当前建筑是目前位置最高的
                int interval = reverse? result.length-1-i: i;
                result[i] += interval;
            }else {
                // 如果当前不是最高的
                // 则一直往左找，找到一栋比当前更高的楼
                result[i] += Math.abs((i - ceil.index));
            }
            set.add(curr);
        }
    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();

        int[] buildings = new int[] {5, 3, 8, 3, 2, 5};

        int[] result = s.countBuildings(buildings);

        Arrays.stream(result).forEach(out::print);


    }

}
