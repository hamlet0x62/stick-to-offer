package coding.interview.deliverFruit;
import static java.lang.System.out;

public class Solution {

    static int f(int n, int i){
        // 参数表示分到第n个人的时候还剩i个

        if (n % 4 != 0){
            return -1;
        }

        if(i == 5){
            return n;
        }

        return f(n*5/4+1, i+1);

    }

    public static void main(String[] args) {

        for(int i=6;i<Integer.MAX_VALUE;i++){
            if((i-1) % 5 == 0) {
                int result = f(i, 1);
                if (result != -1) {
                    out.println(result);
                    out.println(i);
                    return;
                }
            }
        }
    }
}
