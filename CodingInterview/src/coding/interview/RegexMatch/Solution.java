package coding.interview.RegexMatch;

import sun.nio.ch.sctp.SendFailed;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    void addToStack(char[] chrs, Stack<Character> stack) {
        for (char ch : chrs) {
            stack.add(ch);
        }
    }

    public boolean match(char[] str, char[] pattern) {

        return process(str, pattern, 0, 0);
    }

    boolean process(char[] str, char[] pattern, int sStart, int pStart){

        int sEnd = str.length, pEnd = pattern.length;

        if (pStart == pEnd){
            // pattern已经匹配完毕
            // 若此时str也已经匹配完毕
            // 则说明匹配成功
            return sStart == sEnd;
        }else {
            if(sStart == sEnd || (pattern[pStart] != str[sStart] && pattern[pStart] != '.')){
                if(pStart+1 < pEnd){
                    // pattern 中还有1个以上的字符
                    if(pattern[pStart+1] == '*'){
                        // 重复0次
                        return process(str, pattern, sStart, pStart+2);
                    }
                }
                // 当前字符不相等且不能重复0次
                return false;
            }else {

                if(pStart+1 < pEnd){
                    if(pattern[pStart+1] == '*'){
                        return process(str, pattern, sStart, pStart+2) // 当前模式匹配0次
                                || process(str, pattern, sStart+1, pStart+2) // 当前模式只匹配1次
                                || process(str, pattern, sStart+1, pStart); // 当前模式匹配1次后接着匹配

                    }
                }
                // 继续匹配下一个字符
                return process(str, pattern, sStart+1, pStart+1);
            }
        }

    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();
        boolean rst = s.match("b".toCharArray(), "b*".toCharArray());

        out.println(rst);

    }

}
