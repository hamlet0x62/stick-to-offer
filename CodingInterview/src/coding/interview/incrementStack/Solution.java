package coding.interview.incrementStack;

import java.util.*;

import static java.lang.System.out;

class CustomStack {

    class IncItem{
        int k;
        int val;
        long endId;

        public IncItem(long endId, int k, int val){
            this.endId = endId;
            this.k = k;
            this.val = val;
        }

        public boolean isBetween(long id){
            return id > endId - k && id <= endId;
        }

        public long lowerBound(){
            return endId - k + 1;
        }
    }

    class Item{
        long id;
        int val;

        public Item(long id, int val){
            this.id = id;
            this.val = val;
        }
    }

    Stack<Item> stack = new Stack<>();
    Stack<IncItem> incStack = new Stack<>();
    long nextId = 0;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int x) {

        if(stack.size() < maxSize){
            stack.push(new Item(nextId++, x));
        }

    }

    public int pop() {

        if(stack.isEmpty()){
            return -1;
        }else {
            Item item = stack.pop();
            int val = item.val;

            Stack<IncItem> tmpStack = new Stack<>();
            while(!incStack.isEmpty()){
                IncItem top = incStack.pop();

                if (top.isBetween(item.id)){
                    val += item.val;
                }
                if(top.lowerBound() <= item.id){
                    tmpStack.push(top);
                }
            }
            this.incStack = tmpStack;
            return val;

        }

    }

    public void increment(int k, int val) {
        long endId = stack.peek().id;
        IncItem incItem = new IncItem(endId, Math.min(k, stack.size()), val);
        incStack.push(incItem);
    }
}
