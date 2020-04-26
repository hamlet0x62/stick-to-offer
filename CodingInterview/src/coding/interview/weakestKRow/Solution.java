package coding.interview.weakestKRow;

import java.util.*;

import static java.lang.System.out;

class Solution {

    class Score implements Comparable<Score>{
        int pos;
        int soldierCount;

        public Score(int pos, int soldierCount){
            this.pos = pos;
            this.soldierCount = soldierCount;
        }

        public int compareTo(Score other){
            int compareResult = 0;
            if(this.soldierCount == other.soldierCount){
                compareResult = this.pos == other.pos ? 0 : this.pos > other.pos ? 1 : -1;
            }else {
                compareResult = this.soldierCount > other.soldierCount ? 1 : -1;
            }

            return compareResult;
        }

    }

    int countSoldier(int[] row){
        int lo = 0, hi = row.length-1;

        while (lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(row[mid] == 1 && (mid == hi || row[mid+1] != 1)){
                return mid+1; // soldier counts
            }else {
                if(row[mid] == 0){
                    hi = mid-1;
                }else {
                    lo = mid+1;
                }
            }
        }

        return 0;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        if(mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0){
            return new int[0];
        }
        int rowCount = mat.length;
        int colCount = mat[0].length;

        if (k > rowCount){
            return new int[0];
        }

        Score[] scores = new Score[rowCount];
        PriorityQueue<Score> pq = new PriorityQueue<Score>((s1, s2) -> -1*s1.compareTo(s2));

        for(int i=0;i<scores.length;i++){
            scores[i] = new Score(i, countSoldier(mat[i]));
            if(pq.size() < k){
                pq.offer(scores[i]);
            }else {
                if(pq.peek().compareTo(scores[i]) > 0) {
                    pq.poll();
                    pq.offer(scores[i]);
                }
            }
        }

        int[] result = new int[k];

        for(int i=0;i<result.length;i++){
            result[i] = pq.poll().pos;
        }

        return result;

    }
}
