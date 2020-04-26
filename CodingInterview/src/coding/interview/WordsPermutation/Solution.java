package coding.interview.WordsPermutation;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> rst = new ArrayList<>();
        if(str == null || str.length() == 0){
            return new ArrayList<>(0);
        }

        char[] chars = str.toCharArray();

        Arrays.sort(chars);
        str = String.valueOf(chars);

        HashSet<String> set = new HashSet<>();
        process("", str, rst, set);

        return rst;

    }

    void process(String prefix, String remain, ArrayList<String> rst, HashSet<String> occurred){

        if(remain.length() == 0){

            if(occurred.contains(prefix)){
                return ;
            }

            rst.add(prefix);
            occurred.add(prefix);
            return ;
        }

        for(int i=0;i<remain.length();i++){
            String newRemain = remain.substring(0, i) + remain.substring(i+1);
            process(prefix + remain.charAt(i), newRemain, rst, occurred);
        }
    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();
        for(String permutation: s.Permutation(null)){
            out.println(permutation);

        }

    }

}
