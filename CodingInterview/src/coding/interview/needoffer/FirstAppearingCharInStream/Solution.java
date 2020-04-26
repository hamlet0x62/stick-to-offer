package coding.interview.needoffer.FirstAppearingCharInStream;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    class Pair{
        int index;
        char ch;

        public Pair(int index, char ch){
            this.index = index;
            this.ch = ch;
        }

        @Override
        public boolean equals(Object obj) {
            if(! (obj instanceof Pair) || obj == null){
                return false;
            }
            Pair other = (Pair) obj;
            return other.ch == this.ch;

        }
    }

    HashSet<Character> occured =  new HashSet<>();
    HashSet<Character> occuredOnce = new HashSet<>();
    PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.index > o2.index ? 1 : -1;
        }
    });

    int i = 0;


    public void Insert(char ch){
        Pair current = new Pair(i, ch);
        if (!occured.contains(ch)){
            occured.add(ch);
            occuredOnce.add(ch);
            pq.add(current);
        }else if(occuredOnce.contains(ch)){
            occuredOnce.remove(ch);
            pq.remove(current);
        }
        i++;
    }

    public char FirstAppearingOnce() {
        if (!pq.isEmpty()){
            return pq.peek().ch;
        }else {
            return '#';
        }
    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();
        char[] arr = "".toCharArray();
        for (char ch : arr){
            s.Insert(ch);
        }
        out.println(s.FirstAppearingOnce());
    }

}
