package coding.interview.findSolutionOfFormula;

import java.util.*;

import static java.lang.System.out;

public class Solution {
    interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
             // Note that f(x, y) is increasing with respect to both x and y.
             // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
              public int f(int x, int y);
  };

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        return result;
    }


    public static void main(String[] args) {
        // test method

        

    }

}
