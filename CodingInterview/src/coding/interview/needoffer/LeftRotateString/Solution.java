package coding.interview.needoffer.LeftRotateString;

import java.util.*;

public class Solution {

    public String LeftRotateString(String str, int n){
        StringBuilder sbuilder = new StringBuilder();

        for(int i=n;i<str.length();i++){
            sbuilder.append(str.charAt(i));

        }

        for(int i=0;i<n;i++){
            sbuilder.append(str.charAt(i));
        }

        return sbuilder.toString();


    }

}
