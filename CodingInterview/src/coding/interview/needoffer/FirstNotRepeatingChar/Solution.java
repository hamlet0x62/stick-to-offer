package coding.interview.needoffer.FirstNotRepeatingChar;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> excludeSet = new HashSet<>();

        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            if (map.containsKey(ch)){
                if(!excludeSet.contains(ch)){
                    map.remove(ch);
                    excludeSet.add(ch);
                }

            }else if(!map.containsKey(ch) && !excludeSet.contains(ch)) {

                map.put(ch, i);
            }
        }

        int result = -1;
        for(Integer num: map.values()){
            if (result == -1){
                result = num;
            }else if(num < result){
                result = num;
            }
        }
        return result;
    }
}
